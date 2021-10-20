package com.domain.modelo.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.domain.modelo.Alumno;

public class AlumnoTest {

	private static final String NOMBRE_TEST = "nom_test";
	private static final String APELLIDO_TEST = "ape_test";
	private static final String EMAIL_TEST = "ema_test";
	private static final String ESTUDIOS_TEST = "est_test";
	private static final String LINK_A_REPOSITORIO_TEST = "lin_test";
	private static final String OBSERVACIONES_TEST = "obs_test";
	
	private static final String DISTINTO = "dis_";
	
	private Alumno alumno;
	private Alumno alumnoIgualDelTodo;
	private Alumno alumnoIgual;
	private Alumno alumnoDistintoDelTodo;
	private Alumno alumnoDistintoId;
	private Alumno alumnoDistintoNombre;
	private Alumno alumnoDistintoApellido;
	private Alumno alumnoConstructorVacio;
	private Alumno alumnoCamposVacios;
	
	@Before
	public void setUp() throws Exception {
		alumno = new Alumno(1, NOMBRE_TEST, APELLIDO_TEST, EMAIL_TEST, ESTUDIOS_TEST, LINK_A_REPOSITORIO_TEST, OBSERVACIONES_TEST);
		alumnoIgualDelTodo = new Alumno(1, NOMBRE_TEST, APELLIDO_TEST, EMAIL_TEST, ESTUDIOS_TEST, LINK_A_REPOSITORIO_TEST, OBSERVACIONES_TEST);
		alumnoIgual = new Alumno(1, NOMBRE_TEST, APELLIDO_TEST, DISTINTO + EMAIL_TEST, DISTINTO + ESTUDIOS_TEST, DISTINTO + LINK_A_REPOSITORIO_TEST, DISTINTO + OBSERVACIONES_TEST);
		alumnoDistintoDelTodo = new Alumno(2, DISTINTO + NOMBRE_TEST, DISTINTO + APELLIDO_TEST, DISTINTO + EMAIL_TEST, DISTINTO + ESTUDIOS_TEST, DISTINTO + LINK_A_REPOSITORIO_TEST, DISTINTO + OBSERVACIONES_TEST);
		alumnoDistintoId = new Alumno(2, NOMBRE_TEST, APELLIDO_TEST, EMAIL_TEST, ESTUDIOS_TEST, LINK_A_REPOSITORIO_TEST, OBSERVACIONES_TEST);
		alumnoDistintoNombre = new Alumno(1, DISTINTO + NOMBRE_TEST, APELLIDO_TEST, EMAIL_TEST, ESTUDIOS_TEST, LINK_A_REPOSITORIO_TEST, OBSERVACIONES_TEST);
		alumnoDistintoApellido = new Alumno(1, NOMBRE_TEST, DISTINTO + APELLIDO_TEST, EMAIL_TEST, ESTUDIOS_TEST, LINK_A_REPOSITORIO_TEST, OBSERVACIONES_TEST);
		alumnoConstructorVacio = new Alumno();
		alumnoCamposVacios = new Alumno(0, "", "", "", "", "", "");
	}

	@After
	public void tearDown() throws Exception {
		alumno = null;
		alumnoIgualDelTodo = null;
		alumnoIgual = null;
		alumnoDistintoDelTodo = null;
		alumnoDistintoId = null;
		alumnoDistintoNombre = null;
		alumnoDistintoApellido = null;
		alumnoConstructorVacio = null;
		alumnoCamposVacios = null;
	}

	@Test
	public void testGetCodigo() {
		assertEquals(alumno.getCodigo(), 1);
	}

	@Test
	public void testSetCodigo() {
		alumno.setCodigo(2);
		assertEquals(alumno.getCodigo(), 2);
	}

	@Test
	public void testGetNombre() {
		assertEquals(alumno.getNombre(), NOMBRE_TEST);
	}

	@Test
	public void testSetNombre() {
		String otroNombre = "otro_nom_test";
		alumno.setNombre(otroNombre);
		assertEquals(alumno.getNombre(), otroNombre);
	}

	@Test
	public void testGetApellido() {
		assertEquals(alumno.getApellido(), APELLIDO_TEST);
	}

	@Test
	public void testSetApellido() {
		String otroApellido = "otro_ape_test";
		alumno.setApellido(otroApellido);
		assertEquals(alumno.getApellido(), otroApellido);
	}

	@Test
	public void testGetEstudios() {
		assertEquals(alumno.getEstudios(), ESTUDIOS_TEST);
	}

	@Test
	public void testSetEstudios() {
		String otrosEstudios = "otros_est_test";
		alumno.setEstudios(otrosEstudios);
		assertEquals(alumno.getEstudios(), otrosEstudios);
	}

	@Test
	public void testGetLinkARepositorio() {
		assertEquals(alumno.getLinkARepositorio(), LINK_A_REPOSITORIO_TEST);
	}

	@Test
	public void testSetLinkARepositorio() {
		String otroLinkARepositorio = "otro_lin_test";
		alumno.setLinkARepositorio(otroLinkARepositorio);
		assertEquals(alumno.getLinkARepositorio(), otroLinkARepositorio);
	}

	@Test
	public void testGetEmail() {
		assertEquals(alumno.getEmail(), EMAIL_TEST);
	}

	@Test
	public void testSetEmail() {
		String otroEmail = "otro_ema_test@inetum.com";
		alumno.setEmail(otroEmail);
		assertEquals(alumno.getEmail(), otroEmail);
	}

	@Test
	public void testGetObservaciones() {
		assertEquals(alumno.getObservaciones(), OBSERVACIONES_TEST);
	}

	@Test
	public void testSetObservaciones() {
		String otrasObservaciones = "otras_obs_test";
		alumno.setObservaciones(otrasObservaciones);
		assertEquals(alumno.getObservaciones(), otrasObservaciones);
	}

	@Test
	public void testEqualsObject() {
		assertEquals(alumno, alumno);
		assertEquals(alumno, alumnoIgualDelTodo);
		assertEquals(alumno, alumnoIgual);
		assertNotEquals(alumno, alumnoDistintoDelTodo);
		assertNotEquals(alumno, alumnoDistintoId);
		assertNotEquals(alumno, alumnoDistintoNombre);
		assertNotEquals(alumno, alumnoDistintoApellido);
		assertNotEquals(alumnoConstructorVacio, alumnoCamposVacios);
		assertNotEquals(alumnoConstructorVacio, null);
		assertNotEquals(alumnoConstructorVacio, "otro tipo");
	}

	@Test
	public void testToString() {
		StringBuilder sb = 
				new StringBuilder("codigo=").append(1)
				.append(", nombre=").append(NOMBRE_TEST)
				.append(", apellido=").append(APELLIDO_TEST)
				.append(", email=").append(EMAIL_TEST)
				.append(", estudios=").append(ESTUDIOS_TEST)
				.append(", linkARepositorio=").append(LINK_A_REPOSITORIO_TEST)
				.append(", observaciones=").append(OBSERVACIONES_TEST);
		assertEquals(alumno.toString(), sb.toString());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(alumno.isEmpty());
		assertFalse(alumnoIgualDelTodo.isEmpty());
		assertFalse(alumnoIgual.isEmpty());
		assertFalse(alumnoDistintoDelTodo.isEmpty());
		assertFalse(alumnoDistintoId.isEmpty());
		assertFalse(alumnoDistintoNombre.isEmpty());
		assertFalse(alumnoDistintoApellido.isEmpty());
		assertTrue(alumnoConstructorVacio.isEmpty());
		assertTrue(alumnoCamposVacios.isEmpty());
	}

}
