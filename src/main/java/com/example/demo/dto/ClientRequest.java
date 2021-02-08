package com.example.demo.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {

	private int id;
	@NotBlank(message = "Nom must contain characters")
	@Pattern(regexp = "[a-zA-Z ]+", message =  "Nom must contain only characters")
	private String nom;

	@NotBlank(message = "Prenom must contain characters")
	@Pattern(regexp = "[a-zA-Z ]+", message =  "Prenom must contain only characters")
	private String prenom;

	
	@Past
	private Date dateDeNaissance;
	
	@NotBlank(message = "Courriel must contain characters")
	private String courriel;
	
	@NotBlank(message = "telephone must contain characters")
	private String telephone;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

}
