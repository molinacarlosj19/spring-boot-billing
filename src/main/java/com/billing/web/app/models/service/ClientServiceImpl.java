package com.billing.web.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.billing.web.app.models.dao.IClientDAO;
import com.billing.web.app.models.entity.Client;

@Service
public class ClientServiceImpl implements IClientService {
	
	@Autowired
	private IClientDAO clientDAO;

	@Override
	@Transactional(readOnly=true)
	public List<Client> findAll() {
		
		return clientDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Client client) {
		clientDAO.save(client);
	}

	@Override
	@Transactional(readOnly=true)
	public Client findOne(Long id) {
		return clientDAO.findOne(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clientDAO.delete(id);
	}
}
