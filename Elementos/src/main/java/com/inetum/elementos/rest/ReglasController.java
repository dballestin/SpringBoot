package com.inetum.elementos.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inetum.elementos.model.Elemento;
import com.inetum.elementos.model.Juego;
import com.inetum.elementos.model.Regla;
import com.inetum.elementos.model.service.ReglaService;

@RestController
@RequestMapping("/reglas")
public class ReglasController {
	
	@Autowired
	private ReglaService reglaService;
	
	@PostMapping("/{idElementoGanador}/{idElementoPerdedor}/{idJuego}")
	public Regla insertar(@PathVariable("idElementoGanador") int codigoElementoGanador, @PathVariable("idElementoPerdedor") int codigoElementoPerdedor, @PathVariable("idJuego") int codigoJuego) {
		Regla regla = reglaService.insertar(codigoElementoGanador, codigoElementoPerdedor, codigoJuego);
		Elemento elementoGanador = regla.getElementoGanador();
		elementoGanador.setJuegos(null);
		Elemento elementoPerdedor = regla.getElementoPerdedor();
		elementoPerdedor.setJuegos(null);
		Juego juego = regla.getJuego();
		juego.setElementos(null);
		juego.setReglas(null);
		return regla;
	}
	
	@PostMapping("/ganador/{nombreElementoGanador}/perdedor/{nombreElementoPerdedor}/juego/{nombreJuego}")
	public Regla insertarPorNombre(@PathVariable("nombreElementoGanador") String nombreElementoGanador, @PathVariable("nombreElementoPerdedor") String nombreElementoPerdedor, 
			@PathVariable("nombreJuego") String nombreJuego) {
		Regla regla = reglaService.insertarPorNombre(nombreElementoGanador, nombreElementoPerdedor, nombreJuego);
		Elemento elementoGanador = regla.getElementoGanador();
		elementoGanador.setJuegos(null);
		Elemento elementoPerdedor = regla.getElementoPerdedor();
		elementoPerdedor.setJuegos(null);
		Juego juego = regla.getJuego();
		juego.setElementos(null);
		juego.setReglas(null);
		return regla;
	}
	
	@PutMapping(value = "/{id}/{idElementoGanador}/{idElementoPerdedor}/{idJuego}")
	public Regla modificar(@PathVariable("id") Integer codigo, @PathVariable("idElementoGanador") int codigoElementoGanador, @PathVariable("idElementoPerdedor") int codigoElementoPerdedor, 
			@PathVariable("idJuego") int codigoJuego) {
		Regla regla = reglaService.modificar(codigo, codigoElementoGanador, codigoElementoPerdedor, codigoJuego);
		Elemento elementoGanador = regla.getElementoGanador();
		elementoGanador.setJuegos(null);
		Elemento elementoPerdedor = regla.getElementoPerdedor();
		elementoPerdedor.setJuegos(null);
		Juego juego = regla.getJuego();
		juego.setElementos(null);
		juego.setReglas(null);
		return regla;
	}
	
	@PutMapping(value = "/{id}/ganador/{nombreElementoGanador}/perdedor/{nombreElementoPerdedor}/juego/{nombreJuego}")
	public Regla modificarPorNombre(@PathVariable("id") Integer codigo, @PathVariable("nombreElementoGanador") String nombreElementoGanador, 
			@PathVariable("nombreElementoPerdedor") String nombreElementoPerdedor, @PathVariable("nombreJuego") String nombreJuego) {
		Regla regla = reglaService.modificarPorNombre(codigo, nombreElementoGanador, nombreElementoPerdedor, nombreJuego);
		Elemento elementoGanador = regla.getElementoGanador();
		elementoGanador.setJuegos(null);
		Elemento elementoPerdedor = regla.getElementoPerdedor();
		elementoPerdedor.setJuegos(null);
		Juego juego = regla.getJuego();
		juego.setElementos(null);
		juego.setReglas(null);
		return regla;
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer codigo) {
		reglaService.eliminar(codigo);
	}
	
	@DeleteMapping(value = "/ganador/{nombreElementoGanador}/perdedor/{nombreElementoPerdedor}/juego/{nombreJuego}")
	public void eliminarPorNombre(@PathVariable("nombreElementoGanador") String nombreElementoGanador, @PathVariable("nombreElementoPerdedor") String nombreElementoPerdedor, 
			@PathVariable("nombreJuego") String nombreJuego) {
		reglaService.eliminarPorNombre(nombreElementoGanador, nombreElementoPerdedor, nombreJuego);
	}
}
