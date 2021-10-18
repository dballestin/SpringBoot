package es.com.inetum.elementos.modelo;

public class Papel extends ElementoFactory {

	public Papel() {
		super("papel", 1);
	}

	@Override
	public int comparar(ElementoFactory pElem) {
		int numero = pElem.getNumero();
		int resultado;
		if (numero == PIEDRA) {
			resultado = 1;
			descripcionResultado = "Papel le gano a Piedra";
		} else if (numero == TIJERA) {
			resultado = -1;
			descripcionResultado = "Papel perdio con Tijera";
		} else {
			resultado = 0;
			descripcionResultado = "EMPATE";
		}
		return resultado;
	}

}
