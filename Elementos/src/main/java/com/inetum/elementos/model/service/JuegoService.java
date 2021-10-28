package com.inetum.elementos.model.service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.elementos.model.Elemento;
import com.inetum.elementos.model.Juego;
import com.inetum.elementos.model.Regla;
import com.inetum.elementos.model.dao.IJuegoDao;

@Service
public class JuegoService implements IJuegoService {
	
	@Autowired
	private IJuegoDao juegoDao;
	
	@Autowired
	private ElementoJuegoService elementoJuegoService;
	
	@Autowired
	private ReglaService reglaService;
	
	@Override
	public List<Juego> listar() {
		return juegoDao.findAllByOrderByCodigoAsc();
	}

	@Override
	public Juego obtener(int codigo) {
		return juegoDao.findById(codigo).orElseThrow();
	}

	@Override
	public Juego obtenerPorNombre(String nombre) {
		List<Juego> juegos = juegoDao.findByNombre(nombre);
		if (juegos.isEmpty()) {
			throw new NoSuchElementException("No value present");
		}
		return juegos.get(0);
	}

	@Override
	public Juego insertar(Juego juego) {
		juego.setCodigo(0);
		if (juego.getDescripcion() == null) {
			juego.setDescripcion("");
		}
		juego.setElementos(new HashSet<Elemento>());
		juego.setReglas(new HashSet<Regla>());
		return juegoDao.save(juego);
	}

	@Override
	@Transactional
	public Juego modificar(int codigo, Juego juego) {
		Juego juegoDB = obtener(codigo);
		juego.setCodigo(codigo);
		if (juego.getNombre() == null) {
			juego.setNombre(juegoDB.getNombre());
		}
		if (juego.getDescripcion() == null) {
			juego.setDescripcion(juegoDB.getDescripcion());
		}
		juego.setElementos(juegoDB.getElementos());
		juego.setReglas(juegoDB.getReglas());
		return juegoDao.save(juego);
	}

	@Override
	@Transactional
	public void eliminar(int codigo) {
		reglaService.eliminarReglasJuego(codigo);
		elementoJuegoService.eliminarElementosJuego(codigo);
		juegoDao.deleteById(codigo);
	}

	@Override
	@Transactional
	public void eliminarPorNombre(String nombre) {
		Juego juegoDB = obtenerPorNombre(nombre);
		eliminar(juegoDB.getCodigo());
	}
}
