package com.inetum.elementos.model.service;

import com.inetum.elementos.model.ElementoJuego;

public interface IElementoJuegoService {

	public boolean tieneElementoJuego(int codigoElemento, int codigoJuego);
	public ElementoJuego insertar(int codigoElemento, int codigoJuego);
	public ElementoJuego insertarPorNombre(String nombreElemento, String nombreJuego);
	public ElementoJuego modificar(int codigo, int codigoElemento, int codigoJuego);
	public ElementoJuego modificarPorNombre(int codigo, String nombreElemento, String nombreJuego);
	public void eliminar(int codigo);
	public void eliminarPorNombre(String nombreElemento, String nombreJuego);
	public void eliminarElementosJuego(int codigoJuego);
	public void eliminarJuegosElemento(int codigoElemento);
}
