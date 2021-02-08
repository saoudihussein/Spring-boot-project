package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TicketRequest;
import com.example.demo.dto.TicketResponse;
import com.example.demo.models.Ticket;
import com.example.demo.services.TicketService;

@RestController
@RequestMapping("/api/tickets")

public class TicketController {

	private TicketService service;

	@Autowired
	public TicketController(TicketService service) {
		super();
		this.service = service;
	}

	// ADD A Ticket
	@PostMapping
	public TicketResponse createTicket(@Valid @RequestBody TicketRequest ticket) {
		return service.createTicket(ticket);
	}

	// DISPLAY TICKETSS
	@GetMapping
	public List<Ticket> getAllTickets() {
		return service.getAllTickets();
	}

	// DISPLAY Ticket BY ID
	@GetMapping("/{id}")
	public TicketResponse getTicketById(@PathVariable("id") int id) {
		return service.getTicketById(id);
	}

	// DELETE Ticket by ID
	@DeleteMapping("/{id}")
	public String deleteTicketById(@PathVariable("id") int id) {
		return service.deleteTicketById(id);
	}

	// DELETE ALL Tickets
	@DeleteMapping()
	public String deleteTickets() {
		return service.deleteTickets();
	}
	
	@GetMapping("/Revenue/{date}")
	public Float GetRevenue(@PathVariable("date") String date) {
		return service.Revenue(date);
	}
	
	
	
	@GetMapping("/RevenueParMD/{id}")
	public List clientJouPlusRes(@PathVariable("id") int id) {
		return service.clientPlusRees(id);
	}


	
// JOUR PLUS RESERVER PAR UN CLINET
	@GetMapping("/jourplusres/{id}")
	public List JoRePaCli(@PathVariable("id") int id) {
		return service.JourPLResParC(id);
	}

}
