package com.example.demo.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Dessert")
public class Dessert extends Met {

	public Dessert(String nom, float prix) {
		super(nom, prix);
	}
	
	public Dessert() {
	}

}
