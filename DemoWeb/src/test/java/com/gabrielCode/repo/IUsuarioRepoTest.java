package com.gabrielCode.repo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gabrielCode.model.Usuario;

@SpringBootTest
class IUsuarioRepoTest {
	
	@Autowired
	IUsuarioRepo usuRepo;
	Usuario usu;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	void testAgregar() {
		Usuario usu = new Usuario(0, "Gabriel", encoder.encode("gcasas"));
		Usuario usuRetorno = usuRepo.save(usu);
		assertEquals(usu.getClave(), usuRetorno.getClave());
		System.out.println(usu.getClave());
		usuRepo.delete(usuRetorno);
	}

}
