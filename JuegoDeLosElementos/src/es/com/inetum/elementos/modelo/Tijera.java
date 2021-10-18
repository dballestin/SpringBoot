package es.com.inetum.elementos.modelo;

public class Tijera extends ElementoFactory {

	public Tijera() {
		super("tijera", 2);
	}

	@Override
	public int comparar(ElementoFactory pElem) {
		int numero = pElem.getNumero();
		int resultado;
		if (numero == PAPEL) {
			resultado = 1;
			descripcionResultado = "Tijerra le gano a Papel";
		} else if (numero == PIEDRA) {
			resultado = -1;
			descripcionResultado = "Tijera perdio con Piedra";
		} else {
			resultado = 0;
			descripcionResultado = "EMPATE";
		}
		return resultado;
	}

}
