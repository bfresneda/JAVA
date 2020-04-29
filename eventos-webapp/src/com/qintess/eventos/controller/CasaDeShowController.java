package com.qintess.eventos.controller;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String salvar(@ModelAttribute CasaDeShow casadeshow,
						 @RequestParam(required = false,value="Cancelar") String Cancelar,
						 @RequestParam(required = false,value="imagemCasaDeShow") MultipartFile imagemcasadeshow,
						 RedirectAttributes redirectAtt) {
		byte[] bImagem;
		System.out.println(casadeshow.toString());
		
		try {
 			if(Cancelar != null) {
				return "redirect:/casadeshow";
			}
 			if(imagemcasadeshow != null && imagemcasadeshow.getSize() > 0) {
 				bImagem = imagemcasadeshow.getBytes();
 				casadeshow.setImagemCasadeShow(bImagem);
 			}
			if(casadeshow.getId() == 0) {
				dao.salvar(casadeshow);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Casa de show cadastrada com sucesso!");
			}else {
				dao.atualizar(casadeshow);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Casa de show alterada com sucesso!");
			}
			return "redirect:/casadeshow"; //redireciona de volta pra pagina
		} catch (Exception e) {
			//mensagem de erro que vai retorna
			redirectAtt.addFlashAttribute("mensagemErro", "ERRO GRAVE: " + e.getMessage());
		}
		return "redirect:/casadeshow";
	}
	
	
	@RequestMapping("/alterar/{id}")
	public String alterar(@PathVariable(name="id") int id, Model model,
			RedirectAttributes redirectAtt) {
		
		try {
			CasaDeShow casadeshow = dao.buscarPorId(CasaDeShow.class, id);
			byte[] encodeBase64 = Base64.getEncoder().encode(casadeshow.getImagemCasadeShow());
			String base64Encoded = new String(encodeBase64, "UTF-8");
			
			model.addAttribute("casasdeshow", dao.buscarTodos(CasaDeShow.class));
			model.addAttribute("casadeshow", casadeshow);
			model.addAttribute("imagemCasaDeShow", base64Encoded);
			
		} catch (UnsupportedEncodingException e) {
			redirectAtt.addFlashAttribute("mensagemErro","ERRO GRAVE: " + e.getMessage());
		}
		return "casadeshow";
	}

	@RequestMapping("/deletar/{id}")
	public String deletar(@PathVariable(name="id") int id,
						  RedirectAttributes redirectAtt) {
		CasaDeShow casadeshow = dao.buscarPorId(CasaDeShow.class, id);		
		dao.deletar(casadeshow);
		redirectAtt.addFlashAttribute("mensagemSucesso", "Casa de show deletada com sucesso!");
		return "redirect:/casadeshow";
	}
	

}