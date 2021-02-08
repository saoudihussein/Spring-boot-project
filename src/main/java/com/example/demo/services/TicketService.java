package com.example.demo.services;

import java.util.Date;
import java.util.List;

import com.example.demo.dto.TicketRequest;
import com.example.demo.dto.TicketResponse;
import com.example.demo.models.Ticket;

public interface TicketService {

	TicketResponse createTicket(TicketRequest entity);

	List<Ticket> getAllTickets();

	TicketResponse getTicketById(int id);

	String deleteTicketById(int id);

	String deleteTickets();
	
	float Revenue(String date );
	
	public List clientPlusRees(int id) ;
	 List JourPLResParC(int id); 
}
