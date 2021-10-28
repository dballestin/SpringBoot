package com.inetum.elementos.model;

import java.io.Serializable;
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
@Table(name = "elementosjuegos")
@JsonInclude(Include.NON_NULL)
public class ElementoJuego implements Serializable {
	
	private static final long serialVersionUID = 6859710256840993908L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@ManyToOne
	@JoinColumn(name = "elemento_id")
	private Elemento elemento;
	@ManyToOne
	@JoinColumn(name = "juego_id")
	private Juego juego;
	
	@Override
	public int hashCode() {
		return Integer.valueOf(codigo).hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ElementoJuego)) {
			return false;
		}
		ElementoJuego other = (ElementoJuego)obj;
		return codigo == other.codigo;
	}
}
