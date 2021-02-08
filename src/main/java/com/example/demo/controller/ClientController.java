package com.example.demo.controller;

import java.util.List;

import javax.validation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.ClientRequest;
import com.example.demo.dto.ClientResponse;
import com.example.demo.models.Client;

import com.example.demo.services.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

	private ClientService service;

	@Autowired
	public ClientController(ClientService service) {
		super();
		this.service = service;
	}

	// ADD A CLIENT
	@PostMapping
	public ClientResponse createClient(@Valid @RequestBody ClientRequest client) {
		return service.createClient(client);
	}

	// DISPLAY ALL CLIENTS
	@GetMapping
	public List<Client> getAll() {
		return service.getAllClients();
	}

	// DISPLAY CLIENT BY ID
	@GetMapping("/{id}")
	public ClientResponse getClientById(@PathVariable("id") int id) {
		return service.getClientById(id);
	}

	// Update CLIENT ???????
	@PutMapping("/{id}")
	public ClientResponse update(@PathVariable("id") int id,@Valid @RequestBody ClientRequest client) {
		return service.modifyClient(id, client);
	}

	// DELETE CLIENT by ID
	@DeleteMapping("/{id}")
	public String deleteClientById(@PathVariable("id") int id) {
		return service.deleteClientById(id);
	}

	// DELETE ALL CLIENTS
	@DeleteMapping()
	public String deleteClients() {
		return service.deleteClients();
	}

	@GetMapping("/fidele")
	public ClientResponse plusFidele() {
		return service.plusFidele();
	}

}
