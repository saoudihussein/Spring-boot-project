package com.example.demo.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@Getter
@Entity
@EqualsAndHashCode(exclude = "ticket")

public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID ;
	private String nom;
	private String prenom;
	private Date dateDeNaissance ;
	private String courriel ;
	private String telephone;
	
	@OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
	private List<Ticket> ticket;

	public Client() {
		
	}

	
	
	
	}
