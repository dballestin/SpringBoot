package es.com.inetum.elementos.modelo;

public class Piedra extends ElementoFactory {

	public Piedra() {
		super("piedra", 0);
	}

	@Override
	public int comparar(ElementoFactory pElem) {
		int numero = pElem.getNumero();
		int resultado;
		if (numero == TIJERA || numero == LAGARTO) {
			resultado = 1;
			descripcionResultado = nombre + " le gano a " + ElementoFactory.getInstance(numero).getNombre();
		} else if (numero == PAPEL || numero == SPOCK) {
			resultado = -1;
			descripcionResultado = nombre + " perdio con " + ElementoFactory.getInstance(numero).getNombre();
		} else {
			resultado = 0;
			descripcionResultado = "EMPATE";
		}
		return resultado;
	}

}
