package es.com.inetum.elementos.modelo;

public class Piedra extends ElementoFactory {

	public Piedra() {
		super("piedra", 0);
	}

	@Override
	public int comparar(ElementoFactory pElem) {
		int numero = pElem.getNumero();
		int resultado;
		if (numero == TIJERA) {
			resultado = 1;
		} else if (numero == PAPEL) {
			resultado = -1;
		} else {
			resultado = 0;
		}
		return resultado;
	}

}
