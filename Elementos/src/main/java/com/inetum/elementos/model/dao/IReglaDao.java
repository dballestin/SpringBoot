package com.inetum.elementos.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inetum.elementos.model.Regla;

public interface IReglaDao extends JpaRepository<Regla, Integer> {

	public List<Regla> findAllByOrderByCodigoAsc();
	@Query("SELECT r FROM Regla r WHERE (r.elementoGanador.codigo = :codigoElemento OR r.elementoPerdedor.codigo = :codigoElemento) AND r.juego.codigo = :codigoJuego ORDER BY r.codigo")
	public List<Regla> findByElemento_CodigoAndJuego_Codigo(@Param("codigoElemento") Integer codigoElemento, @Param("codigoJuego") Integer codigoJuego);
	public void deleteByElementoGanador_CodigoOrElementoPerdedor_Codigo(Integer codigoElementoGanador, Integer codigoElementoPerdedor);
	public void deleteByJuego_Codigo(Integer codigoJuego);
	public void deleteByElementoGanador_CodigoAndElementoPerdedor_CodigoAndJuego_Codigo(Integer codigoElementoGanador, Integer codigoElementoPerdedor, Integer codigoJuego);
}
