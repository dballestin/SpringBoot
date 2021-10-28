package com.inetum.elementos.model.service;

import java.util.List;

import com.inetum.elementos.model.Juego;

public interface IJuegoService {

	public List<Juego> listar();
	public Juego obtener(int codigo);
	public Juego obtenerPorNombre(String nombre);
	public Juego insertar(Juego juego);
	public Juego modificar(int codigo, Juego juego);
	public void eliminar(int codigo);
	public void eliminarPorNombre(String nombre);
}
