package com.example.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dto.TicketRequest;
import com.example.demo.dto.TicketResponse;
import com.example.demo.models.Ticket;


@Component
public class TicketConverter {
	
		public TicketResponse entityToDto(Ticket ticket)
		{
			TicketResponse Tdto=new TicketResponse();
			Tdto.setNumero(ticket.getNumero());
			Tdto.setAddition(ticket.getAddition());
			Tdto.setDatee(ticket.getDatee());
			Tdto.setNbCouvert(ticket.getNbCouvert());
			Tdto.setClient(ticket.getClient());
			Tdto.setTablee(ticket.getTablee());
			Tdto.setMet(ticket.getMet());
			
			return Tdto;
		}
		
		// Ticket Entity to DTO For display
		public  List<TicketResponse> entityToDtolist(List<Ticket> ticket) {
			
			return	ticket.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
			
		}
		

		//Ticket Request from DTO to entity for adding 
		public Ticket DtoToEntity(TicketRequest dto)
		{
			Ticket Tdto=new Ticket();
			Tdto.setNumero(dto.getNumero());
			Tdto.setAddition(dto.getAddition());
			Tdto.setDatee(dto.getDatee());
			Tdto.setNbCouvert(dto.getNbCouvert());
			Tdto.setClient(dto.getClient());
			Tdto.setTablee(dto.getTablee());
			Tdto.setMet(dto.getMet());
			return Tdto;
		}	
		

		
		//Ticket Request from DTO to entity for adding 
				public Ticket DtoToEntity(Ticket dto)
				{
					Ticket Tdto=new Ticket();
					Tdto.setNumero(dto.getNumero());
					Tdto.setAddition(dto.getAddition());
					Tdto.setDatee(dto.getDatee());
					Tdto.setNbCouvert(dto.getNbCouvert());
					Tdto.setClient(dto.getClient());
					Tdto.setTablee(dto.getTablee());
					Tdto.setMet(dto.getMet());
					return Tdto;
				}

}
