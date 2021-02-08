package com.example.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.converter.TicketConverter;
import com.example.demo.dto.MetRequest;
import com.example.demo.dto.TicketRequest;
import com.example.demo.dto.TicketResponse;
import com.example.demo.models.Met;
import com.example.demo.models.Ticket;
import com.example.demo.repositories.TicketRepository;

@Service
@Validated
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository repos;
	private ModelMapper mapper;
	@Autowired
	private TicketConverter converter;

	@Autowired
	public TicketServiceImpl(TicketRepository repos, ModelMapper mapper) {
		super();
		this.repos = repos;
		this.mapper = mapper;
	}

	@Override
	public TicketResponse createTicket(TicketRequest request) {

		Ticket ticket = converter.DtoToEntity(request);
		
		ticket = repos.save(ticket);

		return mapper.map(converter.entityToDto(ticket), TicketResponse.class);
	}

	@Override
	public List<Ticket> getAllTickets() {
		/*
		 * List<Ticket> tickets = repos.findAll(); List<TicketResponse> responses = new
		 * ArrayList<>(); for (int i = 0; i < tickets.size(); i++) {
		 * responses.add(mapper.map(tickets.get(i), TicketResponse.class)); }
		 */
		return repos.findAll();
	}

	@Override
	public TicketResponse getTicketById(int id) {
		Ticket entity;
		Optional<Ticket> opt = repos.findById(id);
		if (opt.isPresent())
			entity = opt.get();
		else
			throw new NoSuchElementException("Ticket with this id is not found");

		return mapper.map(entity, TicketResponse.class);
		// return converter.entityToDto(entity);
	}

	@Override
	public String deleteTicketById(int id) {
		Ticket entity = new Ticket();
		this.getTicketById(id);
		repos.deleteById(id);
		return ("Ticket number " + id + " has been deleted ..");
	}

	@Override
	public String deleteTickets() {
		Ticket entity = new Ticket();
		this.getAllTickets();
		repos.deleteAll();
		return ("All Tickets has been deleted..");
	}

	@Override
	public float Revenue(String date) {
	Float s;
		s=repos.RvParPeriode(date);
		return s;
	}
	
	@Override
	public List clientPlusRees(int id) {
	
		
		return repos.jourplusRes(id);
	}

	@Override
	public List JourPLResParC(int id) {
		
	return repos.JourPLResParC(id);
		 
	}


	
}
