package com.inetum.elementos.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.elementos.model.Elemento;
import com.inetum.elementos.model.Juego;
import com.inetum.elementos.model.Regla;
import com.inetum.elementos.model.dao.IReglaDao;
import com.inetum.elementos.model.exceptions.ReglaException;

@Service
public class ReglaService implements IReglaService {
	
	@Autowired
	private IReglaDao reglaDao;
	
	@Autowired
	private IElementoJuegoService elementoJuegoService;
	
	@Autowired
	private IElementoService elementoService;
	
	@Autowired
	private IJuegoService juegoService;
	
	@Override
	public Regla insertar(int codigoElementoGanador, int codigoElementoPerdedor, int codigoJuego) {
		Elemento elementoGanadorDB = elementoService.obtener(codigoElementoGanador);
		Elemento elementoPerdedorDB = elementoService.obtener(codigoElementoPerdedor);
		Juego juegoDB = juegoService.obtener(codigoJuego);
		Regla regla = new Regla();
		regla.setElementoGanador(elementoGanadorDB);
		regla.setElementoPerdedor(elementoPerdedorDB);
		regla.setJuego(juegoDB);
		checkInsertarElementosJuego(regla);
		return reglaDao.save(regla);
	}

	@Override
	@Transactional
	public Regla insertarPorNombre(String nombreElementoGanador, String nombreElementoPerdedor, String nombreJuego) {
		Elemento elementoGanadorDB = elementoService.obtenerPorNombre(nombreElementoGanador);
		Elemento elementoPerdedorDB = elementoService.obtenerPorNombre(nombreElementoPerdedor);
		Juego juegoDB = juegoService.obtenerPorNombre(nombreJuego);
		Regla regla = new Regla();
		regla.setElementoGanador(elementoGanadorDB);
		regla.setElementoPerdedor(elementoPerdedorDB);
		regla.setJuego(juegoDB);
		checkInsertarElementosJuego(regla);
		return reglaDao.save(regla);
	}

	private void checkInsertarElementosJuego(Regla reglaDB) {
		if (reglaDB.getElementoGanador() != null && reglaDB.getElementoPerdedor() != null && reglaDB.getJuego() != null) {
			if (!elementoJuegoService.tieneElementoJuego(reglaDB.getElementoGanador().getCodigo(), reglaDB.getJuego().getCodigo()) || 
					!elementoJuegoService.tieneElementoJuego(reglaDB.getElementoPerdedor().getCodigo(), reglaDB.getJuego().getCodigo())) {
				throw new ReglaException("Algunos de los elementos no son del juego por lo que no se puede crear la regla");
			}
		}
	}

	@Override
	@Transactional
	public Regla modificar(int codigo, int codigoElementoGanador, int codigoElementoPerdedor, int codigoJuego) {
		Regla reglaDB = reglaDao.findById(codigo).orElseThrow();
		Regla regla = new Regla();
		regla.setCodigo(codigo);
		boolean elementoGanadorModificado;
		if (codigoElementoGanador == 0) {
			regla.setElementoGanador(reglaDB.getElementoGanador());
			elementoGanadorModificado = false;
		} else {
			Elemento elementoGanadorDB = elementoService.obtener(codigoElementoGanador);
			regla.setElementoGanador(elementoGanadorDB);
			elementoGanadorModificado = elementoGanadorDB.equals(reglaDB.getElementoGanador());
		}
		boolean elementoPerdedorModificado;
		if (codigoElementoPerdedor == 0) {
			regla.setElementoPerdedor(reglaDB.getElementoPerdedor());
			elementoPerdedorModificado = false;
		} else {
			Elemento elementoPerdedorDB = elementoService.obtener(codigoElementoPerdedor);
			regla.setElementoPerdedor(elementoPerdedorDB);
			elementoPerdedorModificado = elementoPerdedorDB.equals(reglaDB.getElementoPerdedor());
		}
		boolean juegoModificado;
		if (codigoJuego == 0) {
			regla.setJuego(reglaDB.getJuego());
			juegoModificado = false;
		} else {
			Juego juegoDB = juegoService.obtener(codigoJuego);
			regla.setJuego(juegoDB);
			juegoModificado = juegoDB.equals(reglaDB.getJuego());
		}
		checkModificarElementoJuego(reglaDB, elementoGanadorModificado, elementoPerdedorModificado, juegoModificado);
		return reglaDao.save(regla);
	}

	@Override
	@Transactional
	public Regla modificarPorNombre(int codigo, String nombreElementoGanador, String nombreElementoPerdedor, String nombreJuego) {
		Regla reglaDB = reglaDao.findById(codigo).orElseThrow();
		Regla regla = new Regla();
		regla.setCodigo(codigo);
		boolean elementoGanadorModificado;
		if ("null".equals(nombreElementoGanador)) {
			regla.setElementoGanador(reglaDB.getElementoGanador());
			elementoGanadorModificado = false;
		} else {
			Elemento elementoGanadorDB = elementoService.obtenerPorNombre(nombreElementoGanador);
			regla.setElementoGanador(elementoGanadorDB);
			elementoGanadorModificado = elementoGanadorDB.equals(reglaDB.getElementoGanador());
		}
		boolean elementoPerdedorModificado;
		if ("null".equals(nombreElementoPerdedor)) {
			regla.setElementoPerdedor(reglaDB.getElementoPerdedor());
			elementoPerdedorModificado = false;
		} else {
			Elemento elementoPerdedorDB = elementoService.obtenerPorNombre(nombreElementoPerdedor);
			regla.setElementoPerdedor(elementoPerdedorDB);
			elementoPerdedorModificado = elementoPerdedorDB.equals(reglaDB.getElementoPerdedor());
		}
		boolean juegoModificado;
		if ("null".equals(nombreJuego)) {
			regla.setJuego(reglaDB.getJuego());
			juegoModificado = false;
		} else {
			Juego juegoDB = juegoService.obtenerPorNombre(nombreJuego);
			regla.setJuego(juegoDB);
			juegoModificado = juegoDB.equals(reglaDB.getJuego());
		}
		checkModificarElementoJuego(reglaDB, elementoGanadorModificado, elementoPerdedorModificado, juegoModificado);
		return reglaDao.save(regla);
	}

	private void checkModificarElementoJuego(Regla regla, boolean elementoGanadorModificado, boolean elementoPerdedorModificado, boolean juegoModificado) {
		if (juegoModificado || (elementoGanadorModificado && elementoPerdedorModificado)) {
			if (!elementoJuegoService.tieneElementoJuego(regla.getElementoGanador().getCodigo(), regla.getJuego().getCodigo()) || 
					!elementoJuegoService.tieneElementoJuego(regla.getElementoPerdedor().getCodigo(), regla.getJuego().getCodigo())) {
				throw new ReglaException("Algunos de los elementos no son del juego por lo que no se puede modificar la regla");
			}
		} else if (elementoGanadorModificado) {
			if (!elementoJuegoService.tieneElementoJuego(regla.getElementoGanador().getCodigo(), regla.getJuego().getCodigo())) {
				throw new ReglaException("El elemento ganador no es del juego por lo que no se puede modificar la regla");
			}
		} else if (elementoPerdedorModificado) {
			if (!elementoJuegoService.tieneElementoJuego(regla.getElementoPerdedor().getCodigo(), regla.getJuego().getCodigo())) {
				throw new ReglaException("El elemento perdedor no es del juego por lo que no se puede modificar la regla");
			}
		}
	}

	@Override
	public boolean tieneReglasElementoAndJuego(int codigoElemento, int codigoJuego) {
		return !reglaDao.findByElemento_CodigoAndJuego_Codigo(codigoElemento, codigoJuego).isEmpty();
	}

	@Override
	public void eliminar(int codigo) {
		reglaDao.deleteById(codigo);
	}

	@Override
	@Transactional
	public void eliminarPorNombre(String nombreElementoGanador, String nombreElementoPerdedor, String nombreJuego) {
		Elemento elementoGanadorDB = elementoService.obtenerPorNombre(nombreElementoGanador);
		Elemento elementoPerdedorDB = elementoService.obtenerPorNombre(nombreElementoPerdedor);
		Juego juegoDB = juegoService.obtenerPorNombre(nombreJuego);
		reglaDao.deleteByElementoGanador_CodigoAndElementoPerdedor_CodigoAndJuego_Codigo(elementoGanadorDB.getCodigo(), elementoPerdedorDB.getCodigo(), juegoDB.getCodigo());
	}

	@Override
	public void eliminarReglasElemento(int codigoElemento) {
		reglaDao.deleteByElementoGanador_CodigoOrElementoPerdedor_Codigo(codigoElemento, codigoElemento);
	}

	@Override
	public void eliminarReglasJuego(int codigoJuego) {
		reglaDao.deleteByJuego_Codigo(codigoJuego);
	}
}
