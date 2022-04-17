package com.matheus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.matheus.model.Pessoa;
import com.matheus.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
    private PessoaRepository repository;
	
	public ModelAndView save(Pessoa pessoa) {
		ModelAndView view = new ModelAndView("redirect:/");
		repository.save(pessoa);
		return view;
	}
	
	public ModelAndView delete(Long id) {
		if(repository.existsById(id) == false) {
			throw new IllegalArgumentException("Pessoa com id " + id + " não existe.");
		}
		ModelAndView view = new ModelAndView("redirect:/");
		repository.deleteById(id);
		return view;
	}
	
	public ModelAndView update(Long id) {
		if(repository.existsById(id) == false) {
			throw new IllegalArgumentException("Pessoa com id " + id + " não existe.");
		}
		ModelAndView view = new ModelAndView("pessoa/edit");
		view.addObject("pessoaobj", repository.findById(id).get());
		return view;
	}
	
}
