package es.com.inetum.elementos.modelo;

public class Tijera extends ElementoFactory {

	public Tijera() {
		super("tijera", 2);
	}

	@Override
	public int comparar(ElementoFactory pElem) {
		int numero = pElem.getNumero();
		int resultado;
		if (numero == PAPEL || numero == LAGARTO) {
			resultado = 1;
			descripcionResultado = nombre + " le gano a " + ElementoFactory.getInstance(numero).getNombre();
		} else if (numero == PIEDRA || numero == SPOCK) {
			resultado = -1;
			descripcionResultado = nombre + " perdio con " + ElementoFactory.getInstance(numero).getNombre();
		} else {
			resultado = 0;
			descripcionResultado = "EMPATE";
		}
		return resultado;
	}

}
