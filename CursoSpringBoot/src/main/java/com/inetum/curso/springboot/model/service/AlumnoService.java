package com.inetum.curso.springboot.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inetum.curso.springboot.model.Alumno;
import com.inetum.curso.springboot.model.dao.IAlumnoDao;

@Service
public class AlumnoService implements IAlumnoService {

	@Autowired
	private IAlumnoDao alumnoDao;
	
	@Override
	public List<Alumno> listar() {
		return alumnoDao.findAll();
	}

	@Override
	public Alumno obtener(int codigo) {
		return alumnoDao.findById(codigo).orElseThrow();
	}

	@Override
	public Alumno insertar(Alumno alumno) {
		alumno.setCodigo(0);
		if (alumno.getNombre() == null) {
			alumno.setNombre("");
		}
		if (alumno.getApellido() == null) {
			alumno.setApellido("");
		}
		if (alumno.getEmail() == null) {
			alumno.setEmail("");
		}
		if (alumno.getEstudios() == null) {
			alumno.setEstudios("");
		}
		if (alumno.getLinkARepositorio() == null) {
			alumno.setLinkARepositorio("");
		}
		if (alumno.getObservaciones() == null) {
			alumno.setObservaciones("");
		}
		return alumnoDao.save(alumno);
	}

	@Override
	public void modificar(int codigo, Alumno alumno) {
		Alumno alumnoDB = obtener(codigo);
		alumno.setCodigo(codigo);
		if (alumno.getNombre() == null) {
			alumno.setNombre(alumnoDB.getNombre());
		}
		if (alumno.getApellido() == null) {
			alumno.setApellido(alumnoDB.getApellido());
		}
		if (alumno.getEmail() == null) {
			alumno.setEmail(alumnoDB.getEmail());
		}
		if (alumno.getEstudios() == null) {
			alumno.setEstudios(alumnoDB.getEstudios());
		}
		if (alumno.getLinkARepositorio() == null) {
			alumno.setLinkARepositorio(alumnoDB.getLinkARepositorio());
		}
		if (alumno.getObservaciones() == null) {
			alumno.setObservaciones(alumnoDB.getObservaciones());
		}
		alumnoDao.save(alumno);
	}

	@Override
	public void eliminar(int codigo) {
		alumnoDao.deleteById(codigo);
	}
}
