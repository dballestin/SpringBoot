package com.inetum.curso.springboot.model.service;

import java.util.List;

import com.inetum.curso.springboot.model.Alumno;

public interface IAlumnoService {

	public List<Alumno> listar();
	public Alumno obtener(int codigo);
	public Alumno insertar(Alumno alumno);
	public void modificar(int codigo, Alumno alumno);
	public void eliminar(int codigo);
}
