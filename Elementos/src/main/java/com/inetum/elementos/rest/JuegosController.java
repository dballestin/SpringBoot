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
import com.inetum.elementos.model.Regla;
import com.inetum.elementos.model.service.IJuegoService;

@RestController
@RequestMapping("/juegos")
public class JuegosController {
	
	@Autowired
	private IJuegoService juegoService;
	
	@GetMapping
	public List<Juego> listar() {
		List<Juego> juegos = juegoService.listar();
		for (final Juego juego : juegos) {
			juego.setElementos(null);
			juego.setReglas(null);
		}
		return juegos;
	}
	
	@GetMapping(value = "/{id}")
	public Juego obtener(@PathVariable("id") Integer codigo) {
		Juego juego = juegoService.obtener(codigo);
		Set<Elemento> elementos = juego.getElementos();
		for (final Elemento elemento : elementos) {
			elemento.setJuegos(null);
		}
		Set<Regla> reglas = juego.getReglas();
		for (final Regla regla : reglas) {
			regla.setJuego(null);
		}
		return juego;
	}
	
	@GetMapping(value = "/nombre/{nombre}")
	public Juego obtenerPorNombre(@PathVariable("nombre") String nombre) {
		Juego juego = juegoService.obtenerPorNombre(nombre);
		Set<Elemento> elementos = juego.getElementos();
		for (final Elemento elemento : elementos) {
			elemento.setJuegos(null);
		}
		Set<Regla> reglas = juego.getReglas();
		for (final Regla regla : reglas) {
			regla.setJuego(null);
		}
		return juego;
	}
	
	@PostMapping
	public Juego insertar(@RequestBody Juego juego) {
		juego = juegoService.insertar(juego);
		Set<Elemento> elementos = juego.getElementos();
		for (final Elemento elemento : elementos) {
			elemento.setJuegos(null);
		}
		Set<Regla> reglas = juego.getReglas();
		for (final Regla regla : reglas) {
			regla.setJuego(null);
		}
		return juego;
	}
	
	@PutMapping(value = "/{id}")
	public Juego modificar(@PathVariable("id") Integer codigo, @RequestBody Juego juego) {
		juego = juegoService.modificar(codigo, juego);
		Set<Elemento> elementos = juego.getElementos();
		for (final Elemento elemento : elementos) {
			elemento.setJuegos(null);
		}
		Set<Regla> reglas = juego.getReglas();
		for (final Regla regla : reglas) {
			regla.setJuego(null);
		}
		return juego;
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer codigo) {
		juegoService.eliminar(codigo);
	}
	
	@DeleteMapping(value = "/nombre/{nombre}")
	public void eliminarPorNombre(@PathVariable(" nombre") String nombre) {
		juegoService.eliminarPorNombre(nombre);
	}
}
