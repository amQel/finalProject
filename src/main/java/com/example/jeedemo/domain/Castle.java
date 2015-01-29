package com.example.jeedemo.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "castle.unsold", query = "Select c from Castle c where c.sold = false")
public class Castle {
	
	private Long castleId;
	private String castleType;
	private String condition;
	private Boolean sold = false;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return castleId;
	}
	public void setId(Long id) {
		this.castleId = id;
	}
	public String getCastleType() {
		return castleType;
	}
	public void setCastleType(String castleType) {
		this.castleType = castleType;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public Boolean getSold() {
		return sold;
	}
	public void setSold(Boolean sold) {
		this.sold = sold;
	}
}
