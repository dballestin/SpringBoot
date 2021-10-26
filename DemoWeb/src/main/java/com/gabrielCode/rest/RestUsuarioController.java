package com.gabrielCode.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielCode.model.Usuario;
import com.gabrielCode.repo.IUsuarioRepo;

@RestController
@RequestMapping("/usuarios")
public class RestUsuarioController {

	@Autowired
	private IUsuarioRepo repo;
	
	@Autowired
	public BCryptPasswordEncoder bcrypt;
	
	@GetMapping
	public List<Usuario> listar() {
		return repo.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Usuario obtener(@PathVariable("id") Integer id) {
		return repo.findById(id).orElse(null);
	}
	
	@PostMapping
	public void insertar(@RequestBody Usuario per) {
		per.setCodigo(0);
		per.setClave(bcrypt.encode(per.getClave()));
		repo.save(per);
	}
	
	@PutMapping(value = "/{id}")
	public void modificar(@PathVariable("id") Integer id, @RequestBody Usuario per) throws Exception {
		if (id == 0 || !repo.existsById(id)) {
			throw new Exception("No se pueden dar de alta registros nuevos con modificar");
		}
		per.setCodigo(id);
		per.setClave(bcrypt.encode(per.getClave()));
		repo.save(per);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		repo.delete(new Usuario(id));
	}
	
}
