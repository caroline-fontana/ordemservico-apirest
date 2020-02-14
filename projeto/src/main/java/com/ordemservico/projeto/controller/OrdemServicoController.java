package com.ordemservico.projeto.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ordemservico.projeto.models.OrdemServico;
import com.ordemservico.projeto.service.OrdemServicoService;

@Controller
public class OrdemServicoController {
	
	/* Ponto de Injeção da classe OrdemServicoService*/
	@Autowired
	OrdemServicoService ordemServicoService;
	
	@RequestMapping(value="/os", method=RequestMethod.GET)
	public ModelAndView getOrdens() {
		ModelAndView modelAndView = new ModelAndView("ordemservico");
		List<OrdemServico> ordemservico = ordemServicoService.listarOrdensServico();
		modelAndView.addObject("ordemservico", ordemservico);
        return modelAndView;
	}
	
	@RequestMapping(value="/cadastrarordem", method=RequestMethod.GET)
    public String getOrdemForm(){
        return "/cadastrarordem";
    }
	
	@RequestMapping(value="/cadastrarordem", method=RequestMethod.POST)
    public String salvarOS(@Valid OrdemServico ordemservico, BindingResult result, RedirectAttributes attributes){
		
        ordemServicoService.salvarOrdem(ordemservico);
        attributes.addFlashAttribute("mensagem", "Ordem Serviço cadastrada com sucesso!");
        return "redirect:/os";
    } 
    
	
	@RequestMapping("/")
    public String index(){
        return "index";
    }
}