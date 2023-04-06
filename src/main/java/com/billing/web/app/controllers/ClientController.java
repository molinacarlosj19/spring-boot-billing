package com.billing.web.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.billing.web.app.models.dao.IClientDAO;
import com.billing.web.app.models.entity.Client;
import com.billing.web.app.models.service.IClientService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("client")
public class ClientController {
	
	@Autowired
	private IClientService clientService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String showClients(Model model) {
		model.addAttribute("title", "List of Clients");
		model.addAttribute("clients", clientService.findAll());
		return "list";
	}
	
	@RequestMapping(value="/form")
	public String create(Model model) {
		
		Client client = new Client();
		model.addAttribute("title", "Form Clients");
		model.addAttribute("client", client);
		return "form";
	}
	
	@RequestMapping(value="/form/{id}")
	public String edit(@PathVariable(value="id") Long id, Model model) {
		Client client = null;
		
		if(id>0) {
			client = clientService.findOne(id);
		}else {
			return "redirect:/list";
		}
		
		model.addAttribute("title", "Form Clients");
		model.addAttribute("client", client);
		return "form";
	}
	
	@RequestMapping(value="/form", method =RequestMethod.POST)
	public String save(@Valid Client client, BindingResult result, Model model, SessionStatus status) {
		
		if (result.hasErrors()) {
			model.addAttribute("title", "Form Client");
			return "form";
		}
		clientService.save(client);
		status.setComplete();
		return "redirect:list";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Long id) {
		
		if(id>0) {
			clientService.delete(id);
		}
		return "redirect:/list";
	}

}
 