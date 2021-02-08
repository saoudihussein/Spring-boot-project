package com.example.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.converter.ClientConverter;
import com.example.demo.dto.ClientRequest;
import com.example.demo.dto.ClientResponse;
import com.example.demo.models.Client;
import com.example.demo.models.Ticket;
import com.example.demo.repositories.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository repos;
	private ModelMapper mapper;
	@Autowired
	private ClientConverter converter;

	@Autowired
	public ClientServiceImpl(ClientRepository repos, ModelMapper mapper) {
		super();
		this.repos = repos;
		this.mapper = mapper;
	}

	public ClientResponse createClient(ClientRequest request) {

		Client client = converter.DtoToEntity(request);
		// Client entity = mapper.map(request, Client.class);

		// saving client

		client = repos.save(client);

		return mapper.map(converter.entityToDto(client), ClientResponse.class);
	}

	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return repos.findAll();
	}

	@Override
	public ClientResponse getClientById(int id) {
		Client entity;
		Optional<Client> opt = repos.findById(id);
		if (opt.isPresent())
			entity = opt.get();
		else
			// Return 404
			return null;

		return converter.entityToDto(entity);
	}

//DELETE CLIENT BY ID
	@Override
	public String deleteClientById(int id) {
		Client entity = new Client();
		this.getClientById(id);
		repos.deleteById(id);
		return ("Client number " + id + " has been deleted ..");
	}

	// DELETE ALL CLIENTs
	@Override
	public String deleteClients() {
		Client entity = new Client();
		this.getAllClients();
		repos.deleteAll();
		;
		return ("All clients has been deleted..");
	}

	@Override
	public ClientResponse modifyClient(int id, ClientRequest client) {

		ClientResponse clientResponse = this.getClientById(id);

		if (client.getNom() != null) {
			clientResponse.setNom(client.getNom());
		}

		if (client.getPrenom() != null) {
			clientResponse.setPrenom(client.getPrenom());
		}

		if (client.getDateDeNaissance() != null) {
			clientResponse.setDateDeNaissance(client.getDateDeNaissance());
		}

		if (client.getCourriel() != null) {
			clientResponse.setCourriel(client.getCourriel());
		}

		if (client.getTelephone() != null) {
			clientResponse.setTelephone(client.getTelephone());
		}

		Client client2 = mapper.map(clientResponse, Client.class);
		repos.save(client2);
		return clientResponse;

	}

	@Override
	public ClientResponse plusFidele() {

		List<Client> responses = this.getAllClients();

		Client client = responses.get(0);

		for (int i = 1; i < responses.size(); i++) {
			if (client.getTicket().size() < responses.get(i).getTicket().size()) {

				client = responses.get(i);
			}
		}
		ClientResponse clientResponse = mapper.map(client, ClientResponse.class);
		return clientResponse;
	}

}