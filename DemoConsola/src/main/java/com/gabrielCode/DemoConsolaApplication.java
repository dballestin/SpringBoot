package com.gabrielCode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gabrielCode.service.IPersonaService;
import com.gabrielCode.service.PersonaServiceImpl;

@SpringBootApplication
public class DemoConsolaApplication implements CommandLineRunner {

	private static Logger log = LoggerFactory.getLogger(DemoConsolaApplication.class);
	private IPersonaService service;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoConsolaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		log.info("impresion en consola");
		log.warn("Esto es una advertencia");
		log.error("Esto es un error");
		*/
		service = new PersonaServiceImpl();
		service.registrarHandler("Gabriel");
	}

}
