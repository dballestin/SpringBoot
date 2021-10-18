package es.com.inetum.elementos.modelo;

public class Papel extends ElementoFactory {

	public Papel() {
		super("papel", 1);
	}

	@Override
	public int comparar(ElementoFactory pElem) {
		int numero = pElem.getNumero();
		int resultado;
		if (numero == PIEDRA || numero == SPOCK) {
			resultado = 1;
			descripcionResultado = nombre + " le gano a " + ElementoFactory.getInstance(numero).getNombre();
		} else if (numero == TIJERA || numero == LAGARTO) {
			resultado = -1;
			descripcionResultado = nombre + " perdio con " + ElementoFactory.getInstance(numero).getNombre();
		} else {
			resultado = 0;
			descripcionResultado = "EMPATE";
		}
		return resultado;
	}

}
