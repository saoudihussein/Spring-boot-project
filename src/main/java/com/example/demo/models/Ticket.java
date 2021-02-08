package com.example.demo.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(exclude = {"tablee","client","met"})


public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int numero ;
	private Date datee;
	private int nbCouvert;
	private float addition;
	
	
	@ManyToOne
	@JoinColumn(name = "tablee_numero")
    @JsonIgnore
	private Tablee tablee;
	
    @ManyToOne
	@JoinColumn(name = "client_id")
	@JsonIgnore
	private Client client;
	
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "compose",
        joinColumns = @JoinColumn(name = "numero", referencedColumnName = "numero"),
        inverseJoinColumns = @JoinColumn(name = "nom", referencedColumnName = "nom"))
    @JsonIgnore
	private List<Met> met ;

	public Ticket(int numero, Date datee, int nbCouvert, float addition, Tablee tablee, Client client, List<Met> met) {
		super();
		this.numero = numero;
		this.datee = datee;
		this.nbCouvert = nbCouvert;
		this.addition = addition;
		this.tablee = tablee;
		this.client = client;
		this.met = met;
	}
	
	public Ticket(){}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getDatee() {
		return datee;
	}

	public void setDatee(Date datee) {
		this.datee = datee;
	}

	public int getNbCouvert() {
		return nbCouvert;
	}

	public void setNbCouvert(int nbCouvert) {
		this.nbCouvert = nbCouvert;
	}

	public float getAddition() {
		return addition;
	}

	public void setAddition(float addition) {
		this.addition = addition;
	}

	public Tablee getTablee() {
		return tablee;
	}

	public void setTablee(Tablee tablee) {
		this.tablee = tablee;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Met> getMet() {
		return met;
	}

	public void setMet(List<Met> met) {
		this.met = met;
	}


	
	
}
