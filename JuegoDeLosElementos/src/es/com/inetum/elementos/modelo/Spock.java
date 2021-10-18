package es.com.inetum.elementos.modelo;

public class Spock extends ElementoFactory {

	public Spock() {
		super("spock", 4);
	}

	@Override
	public int comparar(ElementoFactory pElem) {
		int numero = pElem.getNumero();
		int resultado;
		if (numero == PIEDRA || numero == TIJERA) {
			resultado = 1;
			descripcionResultado = nombre + " le gano a " + ElementoFactory.getInstance(numero).getNombre();
		} else if (numero == PAPEL || numero == LAGARTO) {
			resultado = -1;
			descripcionResultado = nombre + " perdio con " + ElementoFactory.getInstance(numero).getNombre();
		} else {
			resultado = 0;
			descripcionResultado = "EMPATE";
		}
		return resultado;
	}

}
