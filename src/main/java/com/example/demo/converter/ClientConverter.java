package com.example.demo.converter;


import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;


import com.example.demo.dto.ClientRequest;
import com.example.demo.dto.ClientResponse;
import com.example.demo.models.Client;

@Component
public class ClientConverter {
	
	
	//Client Response from entity to DTO 
	public ClientResponse entityToDto(Client client)
	{
		ClientResponse Cdto=new ClientResponse();
		Cdto.setID(client.getID());
		Cdto.setNom(client.getNom());
		Cdto.setPrenom(client.getPrenom());
		Cdto.setDateDeNaissance(client.getDateDeNaissance());
		Cdto.setCourriel(client.getCourriel());
		Cdto.setTelephone(client.getTelephone());
		return Cdto;
	}
	
	// Client Entity to DTO For display
	public  List<ClientResponse> entityToDto(List<Client> student) {
		
		return	student.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
		
	}
	
	//Client Request from DTO to entity for adding 
	public Client DtoToEntity(ClientRequest dto)
	{
		Client Edto=new Client();
		Edto.setNom(dto.getNom());
		Edto.setPrenom(dto.getPrenom());
		Edto.setDateDeNaissance(dto.getDateDeNaissance());
		Edto.setCourriel(dto.getCourriel());;
		Edto.setTelephone(dto.getTelephone());
		return Edto;
	}	
	
	//Client Request from DTO to entity for adding 
		public Client DtoToEntity(Client dto)
		{
			Client Edto=new Client();
			Edto.setNom(dto.getNom());
			Edto.setPrenom(dto.getPrenom());
			Edto.setDateDeNaissance(dto.getDateDeNaissance());
			Edto.setCourriel(dto.getCourriel());;
			Edto.setTelephone(dto.getTelephone());
			return Edto;
		}

	
	
}
