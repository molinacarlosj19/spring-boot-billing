package com.billing.web.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.billing.web.app.models.dao.IClientDAO;

@Controller
public class ClientController {
	
	@Autowired
	private IClientDAO clientDAO;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String showClients(Model model) {
		model.addAttribute("title", "List of Clients");
		model.addAttribute("clients", clientDAO.findAll());
		return "show";
	}

}
 