package com.Alice_and_her_Bakery.Alice_and_her_Bakery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AliceAndHerBakeryApplication implements CommandLineRunner {

//	@Autowired
//	CakeBaker cakebaker;

	final private CakeBaker cakebaker;
	public AliceAndHerBakeryApplication(CakeBaker cakebaker){
		this.cakebaker = cakebaker;;
	}

	public static void main(String[] args) {
		SpringApplication.run(AliceAndHerBakeryApplication.class, args);
	}

	public void run(String... args) throws Exception {
		cakebaker.bakeCake();
	}

}
