package com.inetum.elementos.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inetum.elementos.model.Juego;

public interface IJuegoDao extends JpaRepository<Juego, Integer> {
	
	public List<Juego> findAllByOrderByCodigoAsc();
	public List<Juego> findByNombre(String nombre);
}
