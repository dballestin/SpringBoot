package com.inetum.elementos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "reglas")
@JsonInclude(Include.NON_NULL)
public class Regla {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@ManyToOne
	@JoinColumn(name = "elemento_ganador_id")
	private Elemento elementoGanador;
	@ManyToOne
	@JoinColumn(name = "elemento_perdedor_id")
	private Elemento elementoPerdedor;
	@ManyToOne
	@JoinColumn(name = "juego_id")
	private Juego juego;
	
	@Override
	public int hashCode() {
		return Integer.valueOf(codigo).hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Regla)) {
			return false;
		}
		Regla other = (Regla)obj;
		return codigo == other.codigo;
	}
}
