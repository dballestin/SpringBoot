package es.com.inetum.elementos.modelo.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.com.inetum.elementos.modelo.Papel;
import es.com.inetum.elementos.modelo.Piedra;
import es.com.inetum.elementos.modelo.Tijera;

public class ElementoFactoryTest {
	//lote de pruebas
	Piedra piedra;
	Papel papel;
	Tijera tijera;
	
	@Before
	public void setUp() throws Exception {
		//antes de cada testeo
		piedra = new Piedra();
		papel = new Papel();
		tijera = new Tijera();
	}
	
	@After
	public void tearDown() throws Exception {
		//antes de cada testeo
		piedra = new Piedra();
		papel = new Papel();
		tijera = new Tijera();
	}
	
	@Test
	public void testCompararPiedraConTijera() {
		assertEquals(1, piedra.comparar(tijera));
	}

	@Test
	public void testCompararPiedraConPapel() {
		assertEquals(-1, piedra.comparar(papel));
	}

	@Test
	public void testCompararPiedraConPiedra() {
		assertEquals(0, piedra.comparar(piedra));
	}
	
	@Test
	public void testCompararPapelConTijera() {
		assertEquals(-1, papel.comparar(tijera));
	}

	@Test
	public void testCompararPapelConPapel() {
		assertEquals(0, piedra.comparar(papel));
	}

	@Test
	public void testCompararPapelConPiedra() {
		assertEquals(1, piedra.comparar(piedra));
	}

	@Test
	public void testCompararTijeraConTijera() {
		assertEquals(0, papel.comparar(tijera));
	}

	@Test
	public void testCompararTijeraConPapel() {
		assertEquals(1, piedra.comparar(papel));
	}

	@Test
	public void testCompararTijeraConPiedra() {
		assertEquals(-1, piedra.comparar(piedra));
	}

	@Test
	public void testGetInstance() {
		fail("Not yet implemented");
	}

}
