package com.inetum.elementos.model.service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.elementos.model.Elemento;
import com.inetum.elementos.model.Juego;
import com.inetum.elementos.model.dao.IElementoDao;

@Service
public class ElementoService implements IElementoService {
	
	@Autowired
	private IElementoDao elementoDao;
	
	@Autowired
	private IElementoJuegoService elementoJuegoService;
	
	@Autowired
	private IReglaService reglaService;
	
	@Override
	public List<Elemento> listar() {
		return elementoDao.findAllByOrderByCodigoAsc();
	}

	@Override
	public Elemento obtener(int codigo) {
		return elementoDao.findById(codigo).orElseThrow();
	}

	@Override
	public Elemento obtenerPorNombre(String nombre) {
		List<Elemento> elementos = elementoDao.findByNombre(nombre);
		if (elementos.isEmpty()) {
			throw new NoSuchElementException("No value present");
		}
		return elementos.get(0);
	}

	@Override
	public Elemento insertar(Elemento elemento) {
		elemento.setCodigo(0);
		elemento.setJuegos(new HashSet<Juego>());
		return elementoDao.save(elemento);
	}

	@Override
	@Transactional
	public Elemento modificar(int codigo, Elemento elemento) {
		Elemento elementoDB = obtener(codigo);
		elemento.setCodigo(codigo);
		if (elemento.getNombre() == null) {
			elemento.setNombre(elementoDB.getNombre());
		}
		elemento.setJuegos(elementoDB.getJuegos());
		return elementoDao.save(elemento);
	}

	@Override
	@Transactional
	public void eliminar(int codigo) {
		reglaService.eliminarReglasElemento(codigo);
		elementoJuegoService.eliminarJuegosElemento(codigo);
		elementoDao.deleteById(codigo);
	}

	@Override
	@Transactional
	public void eliminarPorNombre(String nombre) {
		Elemento elementoDB = obtenerPorNombre(nombre);
		eliminar(elementoDB.getCodigo());
	}
}
