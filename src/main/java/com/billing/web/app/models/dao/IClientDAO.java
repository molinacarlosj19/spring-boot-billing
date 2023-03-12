package com.billing.web.app.models.dao;

import java.util.List;

import com.billing.web.app.models.entity.Client;

public interface IClientDAO {
	
	public List<Client> findAll();
	

}
