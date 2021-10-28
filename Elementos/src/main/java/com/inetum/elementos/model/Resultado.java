package com.inetum.elementos.model;

public enum Resultado {
	
	VICTORIA("Victoria", " gana a "), EMPATE("Empate", " empata con "), DERROTA("Derrota", " pierde con ");
	
	private String resultado;
	private String resultadoComp;
	
	private Resultado(String resultado, String resultadoComp) {
		this.resultado = resultado;
		this.resultadoComp = resultadoComp;
	}

	@Override
	public String toString() {
		return resultado;
	}
	
	public String toStringComp(Elemento elemento1, Elemento elemento2) {
		StringBuffer sb = new StringBuffer(elemento1.getNombre())
				.append(resultadoComp)
				.append(elemento2.getNombre());
		return sb.toString();
	}
}
