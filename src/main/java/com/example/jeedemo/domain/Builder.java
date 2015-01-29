package com.example.jeedemo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "builder.all", query = "Select b from Builder b")
})
public class Builder {

	private Long builderId;

	private String firstName = "nonamer";
	private int wiek = 5;
	private Date registrationDate = new Date();

	private List<Castle> Castles = new ArrayList<Castle>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return builderId;
	}
	public void setId(Long id) {
		this.builderId = id;
	}
	
	@Size(min = 2, max = 20)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Min(1)
	@Max(115)
	public int getWiek() {
		return wiek;
	}
	public void setWiek(int wiek) {
		this.wiek = wiek;
	}

	@Temporal(TemporalType.DATE)
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	// Be careful here, both with lazy and eager fetch type
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Castle> getCastles() {
		return Castles;
	}
	public void setCastles(List<Castle> Castles) {
		this.Castles = Castles;
	}
}
