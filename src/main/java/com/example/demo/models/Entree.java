package com.example.demo.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Entree")
public class Entree extends Met {

	public Entree(String nom, float prix) {
		super(nom, prix);
	}

	public Entree() {

	}

}
