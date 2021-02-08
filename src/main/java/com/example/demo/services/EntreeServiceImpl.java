package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.converter.TicketConverter;
import com.example.demo.dto.DessertResponse;
import com.example.demo.dto.EntreeRequest;
import com.example.demo.dto.EntreeResponse;
import com.example.demo.dto.MetRequest;
import com.example.demo.dto.MetResponse;
import com.example.demo.dto.PlatRequest;
import com.example.demo.dto.PlatResponse;
import com.example.demo.dto.TicketResponse;
import com.example.demo.models.Dessert;
import com.example.demo.models.Entree;
import com.example.demo.models.Met;
import com.example.demo.models.Plat;
import com.example.demo.repositories.EntreeRepository;
import com.example.demo.repositories.MetRepository;

@Service
@Validated
public class EntreeServiceImpl implements EntreeService {

	@Autowired
	private EntreeRepository repos;
	private ModelMapper mapper;

	@Autowired
	public EntreeServiceImpl(EntreeRepository repos, ModelMapper mapper) {
		super();
		this.repos = repos;
		this.mapper = mapper;
	}

	@Override
	public EntreeResponse createEntree(EntreeRequest entity) {
		Entree entree  = mapper.map(entity, Entree.class);

		entree = repos.save(entree);

		return mapper.map(entree, EntreeResponse.class);
		
	}

	@Override
	public List<Entree> getAllEntrees(){
		return repos.findAll();
	}

	@Override
	public EntreeResponse modifyEntree(String name, EntreeRequest newEntree) {
		EntreeResponse entreeResponse = this.getEntreeById(name);
		if (newEntree.getPrix() != 0) {
			entreeResponse.setPrix(newEntree.getPrix());
		}
		Entree entree = mapper.map(entreeResponse, Entree.class);
		repos.save(entree);
		return entreeResponse;

	}

	@Override
	public EntreeResponse getEntreeById(String name) {
		Optional<Entree> optional = repos.findById(name);
		Entree entree;
		if (optional.isPresent()) {
			entree = optional.get();
		} else {
			throw new NoSuchElementException("Entree with name not found");
		}
		return mapper.map(entree, EntreeResponse.class);

	}

	@Override
	public String deleteEntreeById(String id) {
		repos.deleteById(id);
		return ("Entree name " + id + " has been deleted ..");
	}

	

}