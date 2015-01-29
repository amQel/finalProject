package com.example.jeedemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Castle;
import com.example.jeedemo.domain.Builder;
import com.example.jeedemo.service.BuilderManager;
import com.example.jeedemo.service.SellingCastleManager;

@SessionScoped
@Named("saleCastleBean")
public class SaleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SellingCastleManager scm;

	@Inject
	private BuilderManager bm;

	private Long castleId;
	private Long builderId;
	
	public Long getBuilderId() {
		return builderId;
	}
	public void setBuilderId(Long builderId) {
		this.builderId = builderId;
	}
	public Long getCastleId() {
		return castleId;
	}
	public void setCastleId(Long carId) {
		this.castleId = carId;
	}
	
	public List<Castle> getAvailableCastles() {
		return scm.getAvailableCastles();
	}

	public List<Builder> getAllBuilders() {
		return bm.getAllBuilder();
	}

	public String sellCastle() {
		scm.sellCastle(builderId, castleId);
		return null;
	}
}
