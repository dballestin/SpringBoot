package com.inetum.elementos.model.service;

import com.inetum.elementos.model.Regla;

public interface IReglaService {

	public Regla insertar(int codigoElementoGanador, int codigoElementoPerdedor, int codigoJuego);
	public Regla insertarPorNombre(String nombreElementoGanador, String nombreElementoPerdedor, String nombreJuego);
	public Regla modificar(int codigo, int codigoElementoGanador, int codigoElementoPerdedor, int codigoJuego);
	public Regla modificarPorNombre(int codigo, String nombreElementoGanador, String nombreElementoPerdedor, String nombreJuego);
	public boolean tieneReglasElementoAndJuego(int codigoElemento, int codigoJuego);
	public void eliminar(int codigo);
	public void eliminarPorNombre(String nombreElementoGanador, String nombreElementoPerdedor, String nombreJuego);
	public void eliminarReglasElemento(int codigoElemento);
	public void eliminarReglasJuego(int codigoJuego);
}
