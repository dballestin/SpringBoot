package es.com.inetum.elementos.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class ElementoFactory {
	
	public static final int PIEDRA = 0;
	public static final int PAPEL = 1;
	public static final int TIJERA = 2;
	
	//atributos
	protected String descripcionResultado;
	private static List<ElementoFactory> elementos;
	protected String nombre;
	protected int numero;
	
	//constructor
	public ElementoFactory() {
	}

	public ElementoFactory(String pNombre, int pNumero) {
		nombre = pNombre;
		numero = pNumero;
	}

	//getter y setter accesors
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDescripcionResultado() {
		return descripcionResultado;
	}
	
	//metodos de negocio
	public boolean isMe(int pNum) {
		return numero == pNum;
	}
	public abstract int comparar(ElementoFactory pElem);
	
	public static ElementoFactory getInstance(int pNum) {
		elementos = new ArrayList<ElementoFactory>();
		elementos.add(new Piedra());
		elementos.add(new Papel());
		elementos.add(new Tijera());
		//van a ir el resto de los elementos
		for (ElementoFactory elementoFactory : elementos) {
			if (elementoFactory.isMe(pNum)) {
				return elementoFactory;
			}
		}
		return null;
	}
}
