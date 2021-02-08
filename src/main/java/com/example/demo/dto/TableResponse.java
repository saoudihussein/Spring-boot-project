package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableResponse {


	private int numero;
	private int nbCouvert;
	private String type;
	private float supplement;
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


	
	
}
