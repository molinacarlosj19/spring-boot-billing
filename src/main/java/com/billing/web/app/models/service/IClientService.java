package com.billing.web.app.models.service;

import java.util.List;

import com.billing.web.app.models.entity.Client;

public interface IClientService {
	
	public List<Client> findAll();
	
	public void save(Client client);
	
	public Client findOne(Long id);
	
	public void delete(Long id);
}
