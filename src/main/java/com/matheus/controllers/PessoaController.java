package com.matheus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.matheus.model.Pessoa;
import com.matheus.repository.PessoaRepository;

@Controller
public class PessoaController {

	private PessoaRepository repository;
	
	public PessoaController(PessoaRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/cadastro")
	public ModelAndView loadPageSave() {
		ModelAndView view = new ModelAndView("pessoa/add");
		return view;
	}
	
	@PostMapping("/save")
	public ModelAndView save(Pessoa pessoa) {
		ModelAndView view = new ModelAndView("redirect:/");
		repository.save(pessoa);
		return view;
	}
	
	@GetMapping("/update/{id}")
	public ModelAndView update(@PathVariable("id") Long id) {
		if(repository.existsById(id) == false) {
			throw new IllegalArgumentException("Pessoa com id " + id + " não existe.");
		}
		ModelAndView view = new ModelAndView("pessoa/edit");
		view.addObject("pessoaobj", repository.findById(id).get());
		return view;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable Long id) {
		if(repository.existsById(id) == false) {
			throw new IllegalArgumentException("Pessoa com id " + id + " não existe.");
		}
		ModelAndView view = new ModelAndView("redirect:/");
		repository.deleteById(id);
		return view;
	}
}
