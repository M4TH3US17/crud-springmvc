package com.matheus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.matheus.model.Pessoa;
import com.matheus.services.PessoaService;

@Controller
public class PessoaController {

	private PessoaService service;
	
	public PessoaController(PessoaService service) {
		this.service = service;
	}
	
	@GetMapping("/cadastro")
	public ModelAndView loadPageSave() {
		ModelAndView view = new ModelAndView("pessoa/add");
		return view;
	}
	
	@PostMapping("/save")
	public ModelAndView save(Pessoa pessoa) {
		ModelAndView view = service.save(pessoa);
		return view;
	}
	
	@GetMapping("/update/{id}")
	public ModelAndView update(@PathVariable("id") Long id) {
		ModelAndView view = service.update(id);
		return view;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable Long id) {
		ModelAndView view = service.delete(id);
		return view;
	}
}
