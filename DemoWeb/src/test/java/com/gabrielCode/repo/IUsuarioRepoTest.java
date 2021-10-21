package com.gabrielCode.repo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gabrielCode.model.Usuario;

@SpringBootTest
class IUsuarioRepoTest {
	
	@Autowired
	IUsuarioRepo usuRepo;
	Usuario usu;
	
	@BeforeEach
	void setUp() throws Exception {
		usu = new Usuario(0, "Gabriel", "gcasas");
	}

	@AfterEach
	void tearDown() throws Exception {
		usu = null;
	}
	
	@Test
	void testAgregar() {
		Usuario usuRetorno = usuRepo.save(usu);
		assertEquals("gcasas", usuRetorno.getClave());
		usuRepo.delete(usuRetorno);
	}

}
