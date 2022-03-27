package com.gerardo.xmen;

import com.gerardo.xmen.mutant.services.MutantServiceImpl;
import com.gerardo.xmen.mutant.utils.ArrayUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XmenApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmenApplication.class, args);
		/*
		MutantServiceImpl mutantService = new MutantServiceImpl();
		String [] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		System.out.println("¿Esta persona es mutante?:"+ mutantService.isMutant(dna));
		*/
	}

}
