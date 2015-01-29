package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Castle;
import com.example.jeedemo.domain.Builder;


/* 
 * This is a Stateless EJB Bean
 * All its methods are transactional
 */
@Stateless
public class SellingCastleManager {

	@PersistenceContext
	EntityManager em;

	public void sellCastle(Long builderId, Long castleId) {

		Builder builder = em.find(Builder.class, builderId);
		Castle castle = em.find(Castle.class, castleId);
		castle.setSold(true);

		builder.getCastles().add(castle);
	}

	@SuppressWarnings("unchecked")
	public List<Castle> getAvailableCastles() {
		return em.createNamedQuery("castle.unsold").getResultList();
	}

	public void disposeCastle(Builder builder, Castle castle) {

		builder = em.find(Builder.class, builder.getId());
		castle = em.find(Castle.class, castle.getId());

		Castle toRemove = null;
		// lazy loading here (person.getCars)
		for (Castle aCastle : builder.getCastles())
			if (aCastle.getId().compareTo(castle.getId()) == 0) {
				toRemove = aCastle;
				break;
			}

		if (toRemove != null)
			builder.getCastles().remove(toRemove);
		
		castle.setSold(false);
	}
}
