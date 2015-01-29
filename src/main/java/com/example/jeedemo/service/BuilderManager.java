package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Castle;
import com.example.jeedemo.domain.Builder;

@Stateless
public class BuilderManager {

	@PersistenceContext
	EntityManager em;

	public void addBuilder(Builder builder) {
		builder.setId(null);
		em.persist(builder);
	}

	public void deleteBuilder(Builder builder) {
		builder = em.find(Builder.class, builder.getId());
		em.remove(builder);
	}

	@SuppressWarnings("unchecked")
	public List<Builder> getAllBuilder() {
		return em.createNamedQuery("builder.all").getResultList();
	}

	public List<Castle> getOwnedCastles(Builder builder) {
		builder = em.find(Builder.class, builder.getId());
		// lazy loading here - try this code without this (shallow) copying
		List<Castle> castles = new ArrayList<Castle>(builder.getCastles());
		return castles;
	}

}
