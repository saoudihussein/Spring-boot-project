package com.example.demo.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.example.demo.models.Client;
import com.example.demo.models.Met;
import com.example.demo.models.Tablee;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class TicketRequest {
	
	
	private int numero ;
	
	@NotNull(message = "Date must not null")
	private Date datee = new Date();
	
	@NotNull(message = "nbCouvert  must not null")
	private int nbCouvert;
	
	@NotNull(message = "Addition  must not null")
	private float addition;
	
	@NotNull(message = "Table  must not null")
	private Tablee tablee;
	
	@NotNull(message = "Client  must not null")
	private Client client;
	
	@NotNull(message = "Met  must not null")
	private List<Met> met ;
	
	
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
