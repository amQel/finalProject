package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Castle;
import com.example.jeedemo.domain.Builder;
import com.example.jeedemo.service.BuilderManager;
import com.example.jeedemo.service.SellingCastleManager;

@SessionScoped
@Named("builderBean")
public class BuilderFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Builder builder = new Builder();
	private ListDataModel<Builder> builders = new ListDataModel<Builder>();
	
	private Builder builderToShow = new Builder();
	private ListDataModel<Castle> ownedCastles = new ListDataModel<Castle>();


	@Inject
	private BuilderManager bm;
	
	@Inject
	private SellingCastleManager scm;

	public Builder getBuilder() {
		return builder;
	}
	public void setBuilder(Builder builder) {
		this.builder = builder;
	}
	
	public ListDataModel<Builder> getAllBuilders() {
		builders.setWrappedData(bm.getAllBuilder());
		return builders;
	}

	public ListDataModel<Castle> getOwnedCastles() {
		ownedCastles.setWrappedData(bm.getOwnedCastles(builderToShow));
		return ownedCastles;
	}
	
	// Actions
	public String addBuilder() {
		bm.addBuilder(builder);
		return "showBuilders";
		//return null;
	}

	public String deleteBuilder() {
		Builder builderToDelete = builders.getRowData();
		bm.deleteBuilder(builderToDelete);
		return null;
	}
	
	public String showDetails() {
		builderToShow = builders.getRowData();
		return "details";
	}
	
	public String disposeCastle(){
		Castle castleToDispose = ownedCastles.getRowData();
		scm.disposeCastle(builderToShow, castleToDispose);
		return null;
	}
}
