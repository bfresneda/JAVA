package com.qintess.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qintess.eventos.DAO.DAO;
import com.qintess.eventos.model.Evento;

@Controller
@RequestMapping("/evento")
public class EventoController {
	
	@Autowired
	private DAO dao;
	
	@RequestMapping("")
	public String carregar(Model model) {
		model.addAttribute("eventos",dao.buscarTodos(Evento.class));
		model.addAttribute("evento", new Evento());
		
//		List<CasaDeShow> ListaCasasDeShows = dao.buscarTodos(CasaDeShow.class);
//		model.addAttribute("ListaCasasDeShows",ListaCasasDeShows);
		return "evento";
	}

	
	@RequestMapping("/salvar")
	public String salvar(@ModelAttribute Evento evento,
						 @RequestParam(required = false,value="Cancelar") String Cancelar,
//						 @RequestParam(required = false,value="imagemEvento") MultipartFile imagemEvento,
//						 @RequestParam(required = false,value="idCasaDeShow")@PathVariable Long idCasaDeShow,
						 RedirectAttributes redirectAtt	) {
//		byte [] bImagem;
		try {
			
//			CasaDeShow casaDeShow = dao.buscarPorId(CasaDeShow.class,idCasaDeShow);
//			evento.setCasaDeShow(casaDeShow);

			if(Cancelar != null) {
				return "redirect:/evento";
			}
//			if(imagemEvento != null && imagemEvento.getSize() > 0) {
//				bImagem = imagemEvento.getBytes();
//				evento.setImagemEvento(bImagem);
//			}
			if(evento.getId() == 0) {
				dao.salvar(evento);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Evento cadastrado com sucesso!");
			}else {
				dao.atualizar(evento);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Evento alterado com sucesso!");
			}
			return "redirect:/evento"; //redireciona de volta pra pagina
			
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "ERRO GRAVE: " + e.getMessage());
		}
		return "redirect:/evento";
	}
	
	@RequestMapping("/alterar/{id}")
	public String alterar(@PathVariable(name="id") Long id, Model model,
			RedirectAttributes redirectAtt) {
		
		try {
			Evento evento = dao.buscarPorId(Evento.class, id);
//			byte[] encodeBase64 = Base64.getEncoder().encode(evento.getImagemEvento());
//			String base64Encoded = new String(encodeBase64, "UTF-8");
			
			model.addAttribute("eventos", dao.buscarTodos(Evento.class));
			model.addAttribute("evento", evento);
//			model.addAttribute("imagemEvento", base64Encoded);
			
//		} catch (UnsupportedEncodingException e) {
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro","ERRO GRAVE: " + e.getMessage());
		}
		return "evento";
	}
	
	@RequestMapping("/deletar/{id}")
	public String deletar(@PathVariable(name="id") Long id,
						  RedirectAttributes redirectAtt) {
		Evento evento = dao.buscarPorId(Evento.class, id);		
		dao.deletar(evento);
		redirectAtt.addFlashAttribute("mensagemSucesso", "Evento deletado com sucesso!");
		return "redirect:/evento";
	}
	
}
