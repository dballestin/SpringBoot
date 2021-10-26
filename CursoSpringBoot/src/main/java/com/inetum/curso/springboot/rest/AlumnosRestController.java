package com.inetum.curso.springboot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inetum.curso.springboot.model.Alumno;
import com.inetum.curso.springboot.model.service.IAlumnoService;

@RestController
@RequestMapping("/alumnos")
public class AlumnosRestController {

	@Autowired
	IAlumnoService alumnoService;
	
	@GetMapping
	public List<Alumno> listar() {
		return alumnoService.listar();
	}
	
	@GetMapping(value = "/{id}")
	public Alumno obtener(@PathVariable("id") Integer codigo) {
		return alumnoService.obtener(codigo);
	}
	
	@PostMapping
	public Alumno insertar(@RequestBody Alumno alumno) {
		return alumnoService.insertar(alumno);
	}
	
	@PutMapping(value = "/{id}")
	public void modificar(@PathVariable("id") Integer codigo, @RequestBody Alumno alumno) {
		alumnoService.modificar(codigo, alumno);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer codigo) {
		alumnoService.eliminar(codigo);
	}
}
