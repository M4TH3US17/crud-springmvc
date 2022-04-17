package com.matheus;

import java.time.LocalDate;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.matheus.model.Pessoa;
import com.matheus.repository.PessoaRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Autowired
	private PessoaRepository repo;

	@Override
	public void run(String... args) throws Exception {
		repo.save(new Pessoa(1L, "PessoaTeste", LocalDate.of(Calendar.YEAR, (Calendar.MONTH + 1), Calendar.DAY_OF_MONTH),
				"pessoa.teste@gmail.com"));
	}
}
