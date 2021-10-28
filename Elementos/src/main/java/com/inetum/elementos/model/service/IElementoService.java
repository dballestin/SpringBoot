package com.inetum.elementos.model.service;

import java.util.List;

import com.inetum.elementos.model.Elemento;

public interface IElementoService {

	public List<Elemento> listar();
	public Elemento obtener(int codigo);
	public Elemento obtenerPorNombre(String nombre);
	public Elemento insertar(Elemento elemento);
	public Elemento modificar(int codigo, Elemento elemento);
	public void eliminar(int codigo);
	public void eliminarPorNombre(String nombre);
}
