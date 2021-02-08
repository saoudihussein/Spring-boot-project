package com.example.demo.dto;


import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class TableRequest {
	

	
	private int numero;
	
	
	private int nbCouvert;
	
	@NotBlank(message = "Type must not Empty")
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