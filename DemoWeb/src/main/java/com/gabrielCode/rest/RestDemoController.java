package com.gabrielCode.rest;

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

import com.gabrielCode.model.Persona;
import com.gabrielCode.repo.IPersonaRepo;

@RestController
@RequestMapping("/personas")
public class RestDemoController {

	@Autowired
	private IPersonaRepo repo;
	
	@GetMapping
	public List<Persona> listar() {
		return repo.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Persona obtener(@PathVariable("id") Integer id) {
		return repo.findById(id).orElse(null);
	}
	
	@PostMapping
	public void insertar(@RequestBody Persona per) {
		per.setCodigo(0);
		repo.save(per);
	}
	
	@PutMapping(value = "/{id}")
	public void modificar(@PathVariable("id") Integer id, @RequestBody Persona per) throws Exception {
		if (id == 0 || !repo.existsById(id)) {
			throw new Exception("No se pueden dar de alta registros nuevos con modificar");
		}
		per.setCodigo(id);
		repo.save(per);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		repo.delete(new Persona(id));
	}
	
}
