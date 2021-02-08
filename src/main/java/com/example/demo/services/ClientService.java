package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.ClientRequest;
import com.example.demo.dto.ClientResponse;
import com.example.demo.models.Client;

public interface ClientService {
	
	
	ClientResponse createClient(ClientRequest entity);
	List<Client> getAllClients();
	ClientResponse getClientById(int id);
	String  deleteClientById(int id);
	String  deleteClients();
	ClientResponse modifyClient(int id, ClientRequest client);
	ClientResponse plusFidele();

}
