package com.example.demo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@Inheritance
@DiscriminatorColumn(name = "Met_Type")
@EqualsAndHashCode(exclude = "ticket")
public class Met {
	@Id
	private String nom;
	private float prix;

	@ManyToMany(mappedBy = "met",  cascade = CascadeType.REMOVE)
	private List<Ticket> ticket;
	
	public Met() {}
	
	public Met(String nom, float prix) {
		super();
		this.nom = nom;
		this.prix = prix;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}


}
