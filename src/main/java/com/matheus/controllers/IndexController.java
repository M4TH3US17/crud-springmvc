package com.matheus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.matheus.repository.PessoaRepository;

@Controller
public class IndexController {

private PessoaRepository repository;
	
	public IndexController(PessoaRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/")
	public String index(Model pessoa) {
		pessoa.addAttribute("lista", repository.findAll());
		return "index";
	}
}
