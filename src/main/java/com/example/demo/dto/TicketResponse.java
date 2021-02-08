package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import com.example.demo.models.Client;
import com.example.demo.models.Met;
import com.example.demo.models.Tablee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponse {

	private int numero;
	private Date datee;
	private int nbCouvert;
	private float addition;
	private Tablee tablee;
	private Client client;
	private List<Met> met;

}
