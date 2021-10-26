package com.inetum.curso.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable {

	private static final long serialVersionUID = 7747669258379940280L;

	@Id
	@Column(name = "ALU_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column(name= "ALU_NOMBRE", length = 45, nullable = false)
	private String nombre;
	@Column(name= "ALU_APELLIDO", length = 45, nullable = false)
	private String apellido;
	@Column(name= "ALU_EMAIL", length = 45, nullable = false)
	private String email;
	@Column(name= "ALU_CONOCIMIENTOS", length = 200, nullable = false)
	private String estudios;
	@Column(name= "ALU_GIT", length = 200, nullable = false)
	private String linkARepositorio;
	@Column(name= "ALU_OBSERVACIONES", length = 200, nullable = false)
	private String observaciones;
}
