package com.inetum.elementos.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inetum.elementos.model.Elemento;
import com.inetum.elementos.model.ElementoJuego;
import com.inetum.elementos.model.Juego;
import com.inetum.elementos.model.service.ElementoJuegoService;

@RestController
@RequestMapping("/elementosjuegos")
public class ElementosJuegosController {
	
	@Autowired
	private ElementoJuegoService elementoJuegoService;
	
	@PostMapping("/{idElemento}/{idJuego}")
	public ElementoJuego insertar(@PathVariable("idElemento") int codigoElemento, @PathVariable("idJuego") int codigoJuego) {
		ElementoJuego elementoJuego = elementoJuegoService.insertar(codigoElemento, codigoJuego);
		Elemento elemento = elementoJuego.getElemento();
		elemento.setJuegos(null);
		Juego juego = elementoJuego.getJuego();
		juego.setElementos(null);
		juego.setReglas(null);
		return elementoJuego;
	}
	
	@PostMapping("/elemento/{nombreElemento}/juego/{nombreJuego}")
	public ElementoJuego insertarPorNombre(@PathVariable("nombreElemento") String nombreElemento, @PathVariable("nombreJuego") String nombreJuego) {
		ElementoJuego elementoJuego = elementoJuegoService.insertarPorNombre(nombreElemento, nombreJuego);
		Elemento elemento = elementoJuego.getElemento();
		elemento.setJuegos(null);
		Juego juego = elementoJuego.getJuego();
		juego.setElementos(null);
		juego.setReglas(null);
		return elementoJuego;
	}
	
	@PutMapping(value = "/{id}/{idElemento}/{idJuego}")
	public ElementoJuego modificar(@PathVariable("id") Integer codigo, @PathVariable("idElemento") int codigoElemento, @PathVariable("idJuego") int codigoJuego) {
		ElementoJuego elementoJuego = elementoJuegoService.modificar(codigo, codigoElemento, codigoJuego);
		Elemento elemento = elementoJuego.getElemento();
		elemento.setJuegos(null);
		Juego juego = elementoJuego.getJuego();
		juego.setElementos(null);
		juego.setReglas(null);
		return elementoJuego;
	}
	
	@PutMapping(value = "/{id}/elemento/{nombreElemento}/juego/{nombreJuego}")
	public ElementoJuego modificarPorNombre(@PathVariable("id") Integer codigo, @PathVariable("nombreElemento") String nombreElemento, @PathVariable("nombreJuego") String nombreJuego) {
		ElementoJuego elementoJuego = elementoJuegoService.modificarPorNombre(codigo, nombreElemento, nombreJuego);
		Elemento elemento = elementoJuego.getElemento();
		elemento.setJuegos(null);
		Juego juego = elementoJuego.getJuego();
		juego.setElementos(null);
		juego.setReglas(null);
		return elementoJuego;
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer codigo) {
		elementoJuegoService.eliminar(codigo);
	}
	
	@DeleteMapping(value = "/elemento/{nombreElemento}/juego/{nombreJuego}")
	public void eliminarPorNombre(@PathVariable("nombreElemento") String nombreElemento, @PathVariable("nombreJuego") String nombreJuego) {
		elementoJuegoService.eliminarPorNombre(nombreElemento, nombreJuego);
	}
}
