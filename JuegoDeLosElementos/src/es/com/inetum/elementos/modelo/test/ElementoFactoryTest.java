package es.com.inetum.elementos.modelo.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.com.inetum.elementos.modelo.ElementoFactory;
import es.com.inetum.elementos.modelo.Lagarto;
import es.com.inetum.elementos.modelo.Papel;
import es.com.inetum.elementos.modelo.Piedra;
import es.com.inetum.elementos.modelo.Spock;
import es.com.inetum.elementos.modelo.Tijera;

public class ElementoFactoryTest {
	//lote de pruebas
	Piedra piedra;
	Papel papel;
	Tijera tijera;
	Lagarto lagarto;
	Spock spock;
	
	@Before
	public void setUp() throws Exception {
		//antes de cada testeo
		piedra = new Piedra();
		papel = new Papel();
		tijera = new Tijera();
		lagarto = new Lagarto();
		spock = new Spock();
	}
	
	@After
	public void tearDown() throws Exception {
		//despues de cada testeo
		piedra = null;
		papel = null;
		tijera = null;
		lagarto = null;
		spock = null;
	}
	
	@Test
	public void testCompararPiedraConTijera() {
		assertEquals(1, piedra.comparar(tijera));
		assertEquals(piedra.getNombre() + " le gano a " + tijera.getNombre(), piedra.getDescripcionResultado());
	}

	@Test
	public void testCompararPiedraConPapel() {
		assertEquals(-1, piedra.comparar(papel));
		assertEquals(piedra.getNombre() + " perdio con " + papel.getNombre(), piedra.getDescripcionResultado());
	}

	@Test
	public void testCompararPiedraConPiedra() {
		assertEquals(0, piedra.comparar(piedra));
		assertEquals("EMPATE", piedra.getDescripcionResultado());
	}
	
	@Test
	public void testCompararPiedraConLagarto() {
		assertEquals(1, piedra.comparar(lagarto));
		assertEquals(piedra.getNombre() + " le gano a " + lagarto.getNombre(), piedra.getDescripcionResultado());
	}

	@Test
	public void testCompararPiedraConSpock() {
		assertEquals(-1, piedra.comparar(spock));
		assertEquals(piedra.getNombre() + " perdio con " + spock.getNombre(), piedra.getDescripcionResultado());
	}
	
	@Test
	public void testCompararPapelConTijera() {
		assertEquals(-1, papel.comparar(tijera));
		assertEquals(papel.getNombre() + " perdio con " + tijera.getNombre(), papel.getDescripcionResultado());
	}

	@Test
	public void testCompararPapelConPapel() {
		assertEquals(0, papel.comparar(papel));
		assertEquals("EMPATE", papel.getDescripcionResultado());
	}

	@Test
	public void testCompararPapelConPiedra() {
		assertEquals(1, papel.comparar(piedra));
		assertEquals(papel.getNombre() + " le gano a " + piedra.getNombre(), papel.getDescripcionResultado());
	}

	@Test
	public void testCompararPapelConLagarto() {
		assertEquals(-1, papel.comparar(lagarto));
		assertEquals(papel.getNombre() + " perdio con " + lagarto.getNombre(), papel.getDescripcionResultado());
	}

	@Test
	public void testCompararPapelConSpock() {
		assertEquals(1, papel.comparar(spock));
		assertEquals(papel.getNombre() + " le gano a " + spock.getNombre(), papel.getDescripcionResultado());
	}

	@Test
	public void testCompararTijeraConTijera() {
		assertEquals(0, tijera.comparar(tijera));
		assertEquals("EMPATE", tijera.getDescripcionResultado());
	}

	@Test
	public void testCompararTijeraConPapel() {
		assertEquals(1, tijera.comparar(papel));
		assertEquals(tijera.getNombre() + " le gano a " + papel.getNombre(), tijera.getDescripcionResultado());
	}

	@Test
	public void testCompararTijeraConPiedra() {
		assertEquals(-1, tijera.comparar(piedra));
		assertEquals(tijera.getNombre() + " perdio con " + piedra.getNombre(), tijera.getDescripcionResultado());
	}

	@Test
	public void testCompararTijeraConLagarto() {
		assertEquals(1, tijera.comparar(lagarto));
		assertEquals(tijera.getNombre() + " le gano a " + lagarto.getNombre(), tijera.getDescripcionResultado());
	}

	@Test
	public void testCompararTijeraConSpock() {
		assertEquals(-1, tijera.comparar(spock));
		assertEquals(tijera.getNombre() + " perdio con " + spock.getNombre(), tijera.getDescripcionResultado());
	}

	@Test
	public void testGetInstancePiedra() {
		assertTrue(ElementoFactory.getInstance(ElementoFactory.PIEDRA) instanceof Piedra);
	}

	@Test
	public void testGetInstancePapel() {
		assertTrue(ElementoFactory.getInstance(ElementoFactory.PAPEL) instanceof Papel);
	}

	@Test
	public void testGetInstanceTijera() {
		assertTrue(ElementoFactory.getInstance(ElementoFactory.TIJERA) instanceof Tijera);
	}

	@Test
	public void testGetInstanceLagarto() {
		assertTrue(ElementoFactory.getInstance(ElementoFactory.LAGARTO) instanceof Lagarto);
	}

	@Test
	public void testGetInstanceSpock() {
		assertTrue(ElementoFactory.getInstance(ElementoFactory.SPOCK) instanceof Spock);
	}
}
