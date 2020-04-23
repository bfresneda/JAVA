package com.qintess.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qintess.eventos.DAO.DAO;
import com.qintess.eventos.model.CasaDeShow;

@Controller
@RequestMapping("/casadeshow")
public class CasaDeShowController {
	
	@Autowired
	private DAO dao;
	
	@RequestMapping("")
	public String carregar(Model model) {
		
		model.addAttribute("casasdeshows", dao.buscarTodos(CasaDeShow.class));
		model.addAttribute("casadeshow",new CasaDeShow());
		return "casadeshow";
	}
	
	@RequestMapping("/salvar")
	public String salvar(@ModelAttribute CasaDeShow casadeshow) {
		if(casadeshow.getId() == 0) {
			dao.salvar(casadeshow);
		}else {
			dao.atualizar(casadeshow);
		}
		return "redirect:/casadeshow"; //redireciona de volta pra pagina
		
	}
	
	@RequestMapping("/deletar/{id}")
	public String deletar(@PathVariable(name="id") int id) {
		CasaDeShow casadeshow = dao.buscarPorId(CasaDeShow.class, id);		
		dao.deletar(casadeshow);
		return "redirect:/casadeshow";
	}
	
	@RequestMapping("/alterar/{id}")
	public String alterar(@PathVariable(name="id") int id, Model model) {
		model.addAttribute("casasdeshows", dao.buscarTodos(CasaDeShow.class));
		model.addAttribute("casadeshow", dao.buscarPorId(CasaDeShow.class, id));
		return "casadeshow";
	}
	
}
