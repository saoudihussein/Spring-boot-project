package com.example.demo.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("Plat")
public class Plat extends Met{

	public Plat(String nom, float prix) {
		super(nom, prix);
	}
	
	public Plat() {
		super();
	}
	
	
	
	
	

}
