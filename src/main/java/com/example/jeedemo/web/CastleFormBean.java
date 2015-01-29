package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Castle;
import com.example.jeedemo.service.CastleManager;

@SessionScoped
@Named("castleBean")
public class CastleFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Castle castle = new Castle();

	@Inject
	private CastleManager cm;

	public Castle getCastle() {
		return castle;
	}
	public void setBuilder(Castle castle) {
		this.castle= castle;
	}

	// Actions
	public String addCastle() {
		cm.addCastle(castle);
		return "sell";
		//return null;
	}

}
