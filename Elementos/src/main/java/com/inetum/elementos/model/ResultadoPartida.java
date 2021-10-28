package com.inetum.elementos.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResultadoPartida implements Serializable {
	
	private static final long serialVersionUID = 4728376102906599913L;
	
	private String juego;
	private String elementoJugador;
	private String elementoComputadora;
	private String resultado;
	private String resultadoComp;	
}
