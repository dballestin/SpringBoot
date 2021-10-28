package com.inetum.elementos.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Partida implements Serializable {
	
	private static final long serialVersionUID = 5700262193114073564L;
	
	private String juego;
	private String elemento;
}
