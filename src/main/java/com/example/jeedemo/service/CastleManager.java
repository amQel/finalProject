package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Castle;

@Stateless
public class CastleManager {

	@PersistenceContext
	EntityManager em;

	public void addCastle(Castle castle) {
		castle.setId(null);
		em.persist(castle);
	}

	@SuppressWarnings("unchecked")
	public List<Castle> getAllCastle() {
		return em.createNamedQuery("castle.unsold").getResultList();
	}


}
