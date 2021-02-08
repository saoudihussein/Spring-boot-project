package com.example.demo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(exclude = "ticket")

public class Tablee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int numero ;
	private int nbCouvert;
	private String type;
	private float supplement;
	
	
	@OneToMany(mappedBy = "tablee",cascade = CascadeType.REMOVE)
	private List<Ticket> ticket;


	public Tablee(int numero, int nbCouvert, String type, float supplement, List<Ticket> ticket) {
		super();
		this.numero = numero;
		this.nbCouvert = nbCouvert;
		this.type = type;
		this.supplement = supplement;
		this.ticket = ticket;
	}
	
	public Tablee() {}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNbCouvert() {
		return nbCouvert;
	}

	public void setNbCouvert(int nbCouvert) {
		this.nbCouvert = nbCouvert;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getSupplement() {
		return supplement;
	}

	public void setSupplement(float supplement) {
		this.supplement = supplement;
	}

	public List<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(List<Ticket> ticket) {
		this.ticket = ticket;
	}
	
	
	
	
}
