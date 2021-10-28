package com.inetum.elementos.rest;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inetum.elementos.model.Elemento;
import com.inetum.elementos.model.Juego;
import com.inetum.elementos.model.service.IElementoService;

@RestController
@RequestMapping("/elementos")
public class ElementosController {
	
	@Autowired
	private IElementoService elementoService;
	
	@GetMapping
	public List<Elemento> listar() {
		List<Elemento> elementos = elementoService.listar();
		for (final Elemento elemento : elementos) {
			elemento.setJuegos(null);
		}
		return elementos;
	}
	
	@GetMapping(value = "/{id}")
	public Elemento obtener(@PathVariable("id") Integer codigo) {
		Elemento elemento = elementoService.obtener(codigo);
		Set<Juego> juegos = elemento.getJuegos();
		for (final Juego juego : juegos) {
			juego.setElementos(null);
			juego.setReglas(null);
		}
		return elemento;
	}
	
	@GetMapping(value = "/nombre/{nombre}")
	public Elemento obtenerPorNombre(@PathVariable("nombre") String nombre) {
		Elemento elemento = elementoService.obtenerPorNombre(nombre);
		Set<Juego> juegos = elemento.getJuegos();
		for (final Juego juego : juegos) {
			juego.setElementos(null);
			juego.setReglas(null);
		}
		return elemento;
	}
	
	@PostMapping
	public Elemento insertar(@RequestBody Elemento elemento) {
		elemento = elementoService.insertar(elemento);
		Set<Juego> juegos = elemento.getJuegos();
		for (final Juego juego : juegos) {
			juego.setElementos(null);
			juego.setReglas(null);
		}
		return elemento;
	}
	
	@PutMapping(value = "/{id}")
	public Elemento modificar(@PathVariable("id") Integer codigo, @RequestBody Elemento elemento) {
		elemento = elementoService.modificar(codigo, elemento);
		Set<Juego> juegos = elemento.getJuegos();
		for (final Juego juego : juegos) {
			juego.setElementos(null);
			juego.setReglas(null);
		}
		return elemento;
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer codigo) {
		elementoService.eliminar(codigo);
	}
	
	@DeleteMapping(value = "/nombre/{nombre}")
	public void eliminarPorNombre(@PathVariable(" nombre") String nombre) {
		elementoService.eliminarPorNombre(nombre);
	}
}
