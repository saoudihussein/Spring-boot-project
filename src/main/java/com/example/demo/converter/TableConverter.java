package com.example.demo.converter;


import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.TableRequest;
import com.example.demo.dto.TableResponse;
import com.example.demo.models.Tablee;

@Component
public class TableConverter {
	
	
	//Table Response from entity to DTO 
	public TableResponse entityToDto(Tablee table)
	{
		TableResponse Tdto=new TableResponse();
		Tdto.setNumero(table.getNumero());
		Tdto.setNbCouvert(table.getNbCouvert());
		Tdto.setSupplement(table.getSupplement());
		Tdto.setType(table.getType());
	
		return Tdto;
	}
	
	// Table Entity to DTO For display
	public  List<TableResponse> entityToDto(List<Tablee> table) {
		
		return	table.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
		
	}
	
	//Table Request from DTO to entity for adding 
	public Tablee DtoToEntity(TableRequest dto)
	{
		Tablee Edto=new Tablee();
		Edto.setNumero(dto.getNumero());
		Edto.setNbCouvert(dto.getNbCouvert());
		Edto.setSupplement(dto.getSupplement());
		Edto.setType(dto.getType());
		return Edto;
	}	
	
	//Table Request from DTO to entity for adding 
		public Tablee DtoToEntity(Tablee dto)
		{
			Tablee Edto=new Tablee();
			Edto.setNumero(dto.getNumero());
			Edto.setNbCouvert(dto.getNbCouvert());
			Edto.setSupplement(dto.getSupplement());
			Edto.setType(dto.getType());
			return Edto;
		}

	
	
}
