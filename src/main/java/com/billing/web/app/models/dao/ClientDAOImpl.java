package com.billing.web.app.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.billing.web.app.models.entity.Client;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ClientDAOImpl implements IClientDAO {

	@PersistenceContext
	private EntityManager em;
	
	 
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Client> findAll() {
		
		return em.createQuery("from Client").getResultList();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Client findOne(Long id) {
		return em.find(Client.class, id);
	}

	@Override
	@Transactional
	public void save(Client client) {
		if(client.getId()!=null && client.getId()>0) {
			em.merge(client);
		}else {
			em.persist(client);
		}
	}

	@Override
	@Transactional
	public void delete(Long id) {
		em.remove(findOne(id));
	}
}
