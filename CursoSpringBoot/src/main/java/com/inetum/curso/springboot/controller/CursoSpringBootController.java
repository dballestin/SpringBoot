package com.inetum.curso.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inetum.curso.springboot.model.Alumno;
import com.inetum.curso.springboot.model.service.IAlumnoService;

@Controller
public class CursoSpringBootController {
	
	@Autowired
	IAlumnoService alumnoService;
	
	@RequestMapping("/listado")
	public String goListado(Model model) {
		
		List<Alumno> alumnos = alumnoService.listar();
		
		model.addAttribute("titulo", "Listado de alumnos");
		model.addAttribute("profesor", "Gabriel Casas");
		model.addAttribute("alumnos", alumnos);
		
		return "listado";
	}
}
