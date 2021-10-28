package com.inetum.elementos.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "juegos")
@JsonInclude(Include.NON_NULL)
public class Juego implements Serializable {
	
	private static final long serialVersionUID = -8465592529835350619L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column(length = 45, nullable = false)
	private String nombre;
	@Column(length = 200)
	private String descripcion;
	@ManyToMany(cascade = {})
	@JoinTable(name = "elementosjuegos", joinColumns = {@JoinColumn(name="juego_id")}, inverseJoinColumns = {@JoinColumn(name="elemento_id")})
	@ToString.Exclude
	private Set<Elemento> elementos;
	@OneToMany(mappedBy = "juego", cascade = {})
	@ToString.Exclude
	private Set<Regla> reglas;
	
	@Override
	public int hashCode() {
		return Integer.valueOf(codigo).hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Juego)) {
			return false;
		}
		Juego other = (Juego)obj;
		return codigo == other.codigo;
	}
}
