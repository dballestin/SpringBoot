package com.inetum.elementos.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inetum.elementos.model.ElementoJuego;

public interface IElementoJuegoDao extends JpaRepository<ElementoJuego, Integer> {
	
	public List<ElementoJuego> findAllByOrderByCodigoAsc();
	public List<ElementoJuego> findByElemento_CodigoAndJuego_Codigo(Integer codigoElemento, Integer juegoElemento);
	public List<ElementoJuego> findByElemento_Codigo(Integer codigoElemento);
	public List<ElementoJuego> findByJuego_Codigo(Integer codigoJuego);
	public void deleteByElemento_CodigoAndJuego_Codigo(Integer codigoElemento, Integer codigoJuego);
	public void deleteByElemento_Codigo(Integer codigoElemento);
	public void deleteByJuego_Codigo(Integer codigoJuego);
}
