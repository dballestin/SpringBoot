package com.inetum.elementos.model.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.elementos.model.Elemento;
import com.inetum.elementos.model.ElementoJuego;
import com.inetum.elementos.model.Juego;
import com.inetum.elementos.model.dao.IElementoJuegoDao;
import com.inetum.elementos.model.exceptions.ElementoJuegoException;

@Service
public class ElementoJuegoService implements IElementoJuegoService {
	
	@Autowired
	private IElementoJuegoDao elementoJuegoDao;
	
	@Autowired
	private IReglaService reglaService;
	
	@Autowired
	private IElementoService elementoService;
	
	@Autowired
	private IJuegoService juegoService;
	
	
	@Override
	public ElementoJuego insertar(int codigoElemento, int codigoJuego) {
		Elemento elementoDB = elementoService.obtener(codigoElemento);
		Juego juegoDB = juegoService.obtener(codigoJuego);
		ElementoJuego elementoJuego = new ElementoJuego();
		elementoJuego.setElemento(elementoDB);
		elementoJuego.setJuego(juegoDB);
		return elementoJuegoDao.save(elementoJuego);
	}
	
	@Override
	@Transactional
	public ElementoJuego insertarPorNombre(String nombreElemento, String nombreJuego) {
		Elemento elementoDB = elementoService.obtenerPorNombre(nombreElemento);
		Juego juegoDB = juegoService.obtenerPorNombre(nombreJuego);
		ElementoJuego elementoJuego = new ElementoJuego();
		elementoJuego.setElemento(elementoDB);
		elementoJuego.setJuego(juegoDB);
		return elementoJuegoDao.save(elementoJuego);
	}

	@Override
	public boolean tieneElementoJuego(int codigoElemento, int codigoJuego) {
		return !elementoJuegoDao.findByElemento_CodigoAndJuego_Codigo(codigoElemento, codigoJuego).isEmpty();
	}
	
	@Override
	@Transactional
	public ElementoJuego modificar(int codigo, int codigoElemento, int codigoJuego) {
		ElementoJuego elementoJuegoDB = elementoJuegoDao.findById(codigo).orElseThrow();
		ElementoJuego elementoJuego = new ElementoJuego();
		elementoJuego.setCodigo(codigo);
		boolean elementoModificado;
		if (codigoElemento == 0) {
			elementoJuego.setElemento(elementoJuegoDB.getElemento());
			elementoModificado = false;
		} else {
			Elemento elementoDB = elementoService.obtener(codigoElemento);
			elementoJuego.setElemento(elementoDB);
			elementoModificado = !elementoDB.equals(elementoJuegoDB.getElemento());
		}
		boolean juegoModificado;
		if (codigoJuego == 0) {
			elementoJuego.setJuego(elementoJuegoDB.getJuego());
			juegoModificado = false;
		} else {
			Juego juegoDB = juegoService.obtener(codigoJuego);
			elementoJuego.setJuego(juegoDB);
			juegoModificado = !juegoDB.equals(elementoJuegoDB.getJuego());
		}
		checkModificarReglas(elementoJuegoDB, elementoModificado, juegoModificado);
		return elementoJuegoDao.save(elementoJuego);
	}

	@Override
	@Transactional
	public ElementoJuego modificarPorNombre(int codigo, String nombreElemento, String nombreJuego) {
		ElementoJuego elementoJuegoDB = elementoJuegoDao.findById(codigo).orElseThrow();
		ElementoJuego elementoJuego = new ElementoJuego();
		elementoJuego.setCodigo(codigo);
		boolean elementoModificado;
		if ("null".equals(nombreElemento)) {
			elementoJuego.setElemento(elementoJuegoDB.getElemento());
			elementoModificado = false;
		} else {
			Elemento elementoDB = elementoService.obtenerPorNombre(nombreElemento);
			elementoJuego.setElemento(elementoDB);
			elementoModificado = !elementoDB.equals(elementoJuegoDB.getElemento());
		}
		boolean juegoModificado;
		if ("null".equals(nombreJuego)) {
			elementoJuego.setJuego(elementoJuegoDB.getJuego());
			juegoModificado = false;
		} else {
			Juego juegoDB = juegoService.obtenerPorNombre(nombreJuego);
			elementoJuego.setJuego(juegoDB);
			juegoModificado = !juegoDB.equals(elementoJuegoDB.getJuego());
		}
		checkModificarReglas(elementoJuegoDB, elementoModificado, juegoModificado);
		return elementoJuegoDao.save(elementoJuego);
	}

	private void checkModificarReglas(ElementoJuego elementoJuegoDB, boolean elementoModificado, boolean juegoModificado) {
		if (elementoModificado && reglaService.tieneReglasElementoAndJuego(elementoJuegoDB.getElemento().getCodigo(), elementoJuegoDB.getJuego().getCodigo())) {
			if (juegoModificado) {
				throw new ElementoJuegoException("El elemento actual esta vinculado a algunas reglas del juego actual por lo que no se puede modificar ni uno ni otro");
			} else {
				throw new ElementoJuegoException("El elemento actual esta vinculado a algunas reglas del juego actual por lo que no se puede modificar");
			}
		} else if (juegoModificado && reglaService.tieneReglasElementoAndJuego(elementoJuegoDB.getElemento().getCodigo(), elementoJuegoDB.getJuego().getCodigo())) {
			throw new ElementoJuegoException("El juego actual esta vinculado a algunas reglas con el elemento actual por lo que no se puede modificar");
		}
	}
	
	@Override
	@Transactional
	public void eliminar(int codigo) {
		ElementoJuego elementoJuegoDB = elementoJuegoDao.findById(codigo).orElseThrow();
		if (reglaService.tieneReglasElementoAndJuego(elementoJuegoDB.getElemento().getCodigo(), elementoJuegoDB.getJuego().getCodigo())) {
			throw new ElementoJuegoException("El elemento actual esta vinculado a algunas reglas del juego actual por lo que no se puede eliminar");
		}
		elementoJuegoDao.deleteById(codigo);
	}
	
	@Override
	@Transactional
	public void eliminarPorNombre(String nombreElemento, String nombreJuego) {
		Elemento elementoDB = elementoService.obtenerPorNombre(nombreElemento);
		Juego juegoDB = juegoService.obtenerPorNombre(nombreJuego);
		List<ElementoJuego> elementosJuegosDB = elementoJuegoDao.findByElemento_CodigoAndJuego_Codigo(elementoDB.getCodigo(), juegoDB.getCodigo());
		if (elementosJuegosDB.isEmpty()) {
			throw new NoSuchElementException("No value present");
		}
		ElementoJuego elementoJuegoDB = elementosJuegosDB.get(0);
		checkEliminarReglas(elementoJuegoDB.getElemento().getCodigo(), elementoJuegoDB.getJuego().getCodigo());
		elementoJuegoDao.deleteById(elementoJuegoDB.getCodigo());
	}

	@Override
	@Transactional
	public void eliminarElementosJuego(int codigoJuego) {
		checkEliminarReglas(0, codigoJuego);
		elementoJuegoDao.deleteByJuego_Codigo(codigoJuego);
	}

	@Override
	@Transactional
	public void eliminarJuegosElemento(int codigoElemento) {
		checkEliminarReglas(codigoElemento, 0);
		elementoJuegoDao.deleteByElemento_Codigo(codigoElemento);
	}
	
	private void checkEliminarReglas(int codigoElemento, int codigoJuego) {
		List<ElementoJuego> elementosJuegosDB = null;
		if (codigoElemento == 0) {
			if (codigoJuego != 0) {
				elementosJuegosDB = elementoJuegoDao.findByJuego_Codigo(codigoJuego);
			}
		} else {
			if (codigoJuego == 0) {
				elementosJuegosDB = elementoJuegoDao.findByElemento_Codigo(codigoElemento);
			}
		}
		if (elementosJuegosDB == null) {
			if (reglaService.tieneReglasElementoAndJuego(codigoElemento, codigoJuego)) {
				throw new ElementoJuegoException("El elemento actual esta vinculado a algunas reglas del juego actual por lo que no se puede eliminar");
			}
		} else if (!elementosJuegosDB.isEmpty()) {
			for (ElementoJuego elementoJuegoDB : elementosJuegosDB) {
				if (codigoElemento == 0) {
					if (codigoJuego != 0) {
						if (reglaService.tieneReglasElementoAndJuego(elementoJuegoDB.getElemento().getCodigo(), codigoJuego)) {
							throw new ElementoJuegoException("Algunos de los elementos actuales estan vinculados a algunas reglas del juego por lo que no se pueden eliminar");
						}
					}
				} else {
					if (codigoJuego == 0) {
						if (reglaService.tieneReglasElementoAndJuego(codigoElemento, elementoJuegoDB.getJuego().getCodigo())) {
							throw new ElementoJuegoException("Algunos de los juegos actuales estan vinculados a algunas reglas con el elemento por lo que no se pueden eliminar");
						}						
					}
				}
			}
		}
	}
}
