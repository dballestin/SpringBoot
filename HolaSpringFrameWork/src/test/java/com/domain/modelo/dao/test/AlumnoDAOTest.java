package com.domain.modelo.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.domain.modelo.Alumno;
import com.domain.modelo.Model;
import com.domain.modelo.dao.AlumnoDAO;

public class AlumnoDAOTest {

	private static final String NOMBRE_TEST = "nom_test";
	private static final String APELLIDO_TEST = "ape_test";
	private static final String EMAIL_TEST = "ema_test";
	private static final String ESTUDIOS_TEST = "est_test";
	private static final String LINK_A_REPOSITORIO_TEST = "lin_test";
	private static final String OBSERVACIONES_TEST = "obs_test";
	
	private static final String NOMBRE_INSERT = "nom_ins";
	private static final String APELLIDO_INSERT = "ape_ins";
	private static final String EMAIL_INSERT = "ema_ins";
	private static final String ESTUDIOS_INSERT = "est_ins";
	private static final String LINK_A_REPOSITORIO_INSERT = "lin_ins";
	private static final String OBSERVACIONES_INSERT = "obs_ins";

	private static final String NOMBRE_UPDATE = "nom_upd";
	private static final String APELLIDO_UPDATE = "ape_upd";
	private static final String EMAIL_UPDATE = "ema_upd";
	private static final String ESTUDIOS_UPDATE = "est_upd";
	private static final String LINK_A_REPOSITORIO_UPDATE = "lin_upd";
	private static final String OBSERVACIONES_UPDATE = "obs_upd";
	
	private static final String NOMBRE_UPDATE2 = "nom_upd2";
	private static final String APELLIDO_UPDATE2 = "ape_upd2";
	private static final String EMAIL_UPDATE2 = "ema_upd2";
	private static final String ESTUDIOS_UPDATE2 = "est_upd2";
	private static final String LINK_A_REPOSITORIO_UPDATE2 = "lin_upd2";
	private static final String OBSERVACIONES_UPDATE2 = "obs_upd2";

	private static final String NOMBRE_DELETE = "nom_del";
	private static final String APELLIDO_DELETE = "ape_del";
	private static final String EMAIL_DELETE = "ema_del";
	private static final String ESTUDIOS_DELETE = "est_del";
	private static final String LINK_A_REPOSITORIO_DELETE = "lin_del";
	private static final String OBSERVACIONES_DELETE = "obs_del";
	
	private static Alumno alumno;
	private static Alumno alumnoAgregar;
	private static Alumno alumnoModificar;
	private static Alumno alumnoEliminar;
	
	private static int codigoAlumnoModificar;
	private static int codigoAlumnoEliminar;	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		alumno = new Alumno(0, NOMBRE_TEST, APELLIDO_TEST, EMAIL_TEST, ESTUDIOS_TEST, LINK_A_REPOSITORIO_TEST, OBSERVACIONES_TEST);
		alumnoAgregar = new Alumno(0, NOMBRE_INSERT, APELLIDO_INSERT, EMAIL_INSERT, ESTUDIOS_INSERT, LINK_A_REPOSITORIO_INSERT, OBSERVACIONES_INSERT);
		Alumno alumnoParaModificar = new Alumno(0, NOMBRE_UPDATE, APELLIDO_UPDATE, EMAIL_UPDATE, ESTUDIOS_UPDATE, LINK_A_REPOSITORIO_UPDATE, OBSERVACIONES_UPDATE);
		AlumnoDAO aluDao = new AlumnoDAO();
		aluDao.agregar(alumno);
		aluDao.agregar(alumnoParaModificar);
		codigoAlumnoModificar = ((Alumno)aluDao.leer(alumnoParaModificar).get(0)).getCodigo();
		alumnoModificar = new Alumno(codigoAlumnoModificar, NOMBRE_UPDATE2, APELLIDO_UPDATE2, EMAIL_UPDATE2, ESTUDIOS_UPDATE2, LINK_A_REPOSITORIO_UPDATE2, OBSERVACIONES_UPDATE2);
		Alumno alumnoParaEliminar = new Alumno(0, NOMBRE_DELETE, APELLIDO_DELETE, EMAIL_DELETE, ESTUDIOS_DELETE, LINK_A_REPOSITORIO_DELETE, OBSERVACIONES_DELETE);
		aluDao.agregar(alumnoParaEliminar);
		codigoAlumnoEliminar = ((Alumno)aluDao.leer(alumnoParaEliminar).get(0)).getCodigo();
		alumnoEliminar = new Alumno(codigoAlumnoEliminar);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		AlumnoDAO aluDao = new AlumnoDAO();
		Model aluKill = aluDao.leer(alumno).get(0);
		aluDao.eliminar(aluKill);
		aluKill = aluDao.leer(alumnoAgregar).get(0);
		aluDao.eliminar(aluKill);
		aluKill = aluDao.leer(alumnoModificar).get(0);
		aluDao.eliminar(aluKill);
		alumno = null;
		alumnoAgregar = null;
		alumnoModificar = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAgregar() {
		AlumnoDAO aluDao = new AlumnoDAO();
		try {
			aluDao.agregar(alumnoAgregar);
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
			e.printStackTrace();
		}
	}

	@Test
	public void testModificar() {
		AlumnoDAO aluDao = new AlumnoDAO();
		try {
			aluDao.modificar(alumnoModificar);
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
			e.printStackTrace();
		}
	}

	@Test
	public void testEliminar() {
		AlumnoDAO aluDao = new AlumnoDAO();
		try {
			aluDao.eliminar(alumnoEliminar);
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
			e.printStackTrace();
		}
	}

	@Test
	public void testLeer() {
		AlumnoDAO aluDao = new AlumnoDAO();
		try {
			List<Model> listadoCompleto = aluDao.leer(new Alumno());
			assertTrue(listadoCompleto.size() > 0);
			List<Model> listadoAlumno = aluDao.leer(alumno);
			assertTrue(listadoAlumno.size() == 1);
		} catch (Exception e) {
			assertTrue(false);
			e.printStackTrace();
		}
	}

}
