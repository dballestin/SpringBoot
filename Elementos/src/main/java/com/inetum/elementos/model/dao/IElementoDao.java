package com.inetum.elementos.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inetum.elementos.model.Elemento;

public interface IElementoDao extends JpaRepository<Elemento, Integer> {
	
	public List<Elemento> findAllByOrderByCodigoAsc();
	public List<Elemento> findByNombre(String nombre);
}
