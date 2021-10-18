package es.com.inetum.elementos.modelo;

public class Lagarto extends ElementoFactory {

	public Lagarto() {
		super("lagarto", 3);
	}

	@Override
	public int comparar(ElementoFactory pElem) {
		int numero = pElem.getNumero();
		int resultado;
		if (numero == PAPEL || numero == SPOCK) {
			resultado = 1;
			descripcionResultado = nombre + " le gano a " + ElementoFactory.getInstance(numero).getNombre();
		} else if (numero == PIEDRA || numero == TIJERA) {
			resultado = -1;
			descripcionResultado = nombre + " perdio con " + ElementoFactory.getInstance(numero).getNombre();
		} else {
			resultado = 0;
			descripcionResultado = "EMPATE";
		}
		return resultado;
	}

}
