package com.inetum.elementos.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inetum.elementos.model.Elemento;
import com.inetum.elementos.model.Juego;
import com.inetum.elementos.model.Partida;
import com.inetum.elementos.model.Regla;
import com.inetum.elementos.model.Resultado;
import com.inetum.elementos.model.ResultadoPartida;
import com.inetum.elementos.model.exceptions.PartidaException;
import com.inetum.elementos.model.service.ElementoService;
import com.inetum.elementos.model.service.JuegoService;

@RestController
@RequestMapping("/partida")
public class PartidaController {
	
	@Autowired
	private JuegoService juegoService;
	
	@Autowired
	private ElementoService elementoService;
	
	@PostMapping
	public ResultadoPartida partida(@RequestBody Partida partida) {
		Juego juego = obtenerJuego(partida);
		Elemento elementoJugador = obtenerElementoJugador(partida);
		checkElementoJugador(elementoJugador, juego);
		Elemento elementoComputadora = obtenerElementoComputadora(juego);
		Resultado resultado = obtenerResultado(juego, elementoJugador, elementoComputadora);
		return mapearResultadoPartida(juego, elementoJugador, elementoComputadora, resultado);
	}
	
	private Juego obtenerJuego(Partida partida) {
		Juego juego = null;
		try {
			juego = juegoService.obtenerPorNombre(partida.getJuego());
		} catch (NoSuchElementException nsee) {
			throw new PartidaException(new StringBuffer("No existe el juego ").append(partida.getJuego()).toString());
		}
		return juego;
	}
	
	private Elemento obtenerElementoJugador(Partida partida) {
		Elemento elemento = null;
		try {
			elemento = elementoService.obtenerPorNombre(partida.getElemento());
		} catch (NoSuchElementException nsee) {
			throw new PartidaException(new StringBuffer("No existe el elemento ").append(partida.getElemento()).toString());
		}
		return elemento;
	}
	
	private void checkElementoJugador(Elemento elementoJugador, Juego juego) {
		if (!juego.getElementos().contains(elementoJugador)) {
			throw new PartidaException(new StringBuffer("El elemento ").append(elementoJugador.getNombre()).append(" no forma parte del juego ").append(juego.getNombre()).toString());
		}
	}
	
	private Elemento obtenerElementoComputadora(Juego juego) {
		List<Elemento> elementos = new ArrayList<Elemento>(juego.getElementos());
		return elementos.get(ThreadLocalRandom.current().nextInt(0, elementos.size()));
	}
	
	private Resultado obtenerResultado(Juego juego, Elemento elementoJugador, Elemento elementoComputadora) {
		Resultado resultado = Resultado.EMPATE;
		for (final Regla regla : juego.getReglas()) {
			if (elementoJugador.equals(regla.getElementoGanador()) && elementoComputadora.equals(regla.getElementoPerdedor())) {
				resultado = Resultado.VICTORIA;
				break;
			} else if (elementoJugador.equals(regla.getElementoPerdedor()) && elementoComputadora.equals(regla.getElementoGanador())) {
				resultado = Resultado.DERROTA;
				break;
			}
		}
		return resultado;
	}
	
	private ResultadoPartida mapearResultadoPartida(Juego juego, Elemento elementoJugador, Elemento elementoComputadora, Resultado resultado) {
		ResultadoPartida resultadoPartida = new ResultadoPartida();
		resultadoPartida.setJuego(juego.getNombre());
		resultadoPartida.setElementoJugador(elementoJugador.getNombre());
		resultadoPartida.setElementoComputadora(elementoComputadora.getNombre());
		resultadoPartida.setResultado(resultado.toString());
		resultadoPartida.setResultadoComp(resultado.toStringComp(elementoJugador, elementoComputadora));
		return resultadoPartida;
	}
}
