package com.example.demo.dto;

import java.sql.Date;
import java.util.List;

import com.example.demo.models.Client;
import com.example.demo.models.Met;
import com.example.demo.models.Tablee;
import com.example.demo.models.Ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetResponse {

	private String nom;
	private float prix;
	private List<Ticket> ticket;
	
}
