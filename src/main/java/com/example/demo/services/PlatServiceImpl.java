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
import com.example.demo.dto.MetRequest;
import com.example.demo.dto.MetResponse;
import com.example.demo.dto.PlatRequest;
import com.example.demo.dto.PlatResponse;
import com.example.demo.dto.TicketResponse;
import com.example.demo.models.Dessert;
import com.example.demo.models.Met;
import com.example.demo.models.Plat;
import com.example.demo.repositories.MetRepository;
import com.example.demo.repositories.PlatRepository;

@Service
@Validated
public class PlatServiceImpl implements PlatService {

	@Autowired
	private PlatRepository repos;
	private ModelMapper mapper;

	@Autowired
	public PlatServiceImpl(PlatRepository repos, ModelMapper mapper) {
		super();
		this.repos = repos;
		this.mapper = mapper;
	}

	@Override
	public PlatResponse createPlat(PlatRequest entity) {
		Plat plat = mapper.map(entity, Plat.class);

		plat = repos.save(plat);

		return mapper.map(plat, PlatResponse.class);
	}

	@Override
	public List<Plat> getAllPlats() {
		return repos.findAll();
	}

	@Override
	public PlatResponse modifyPlat(String name, PlatRequest newPlat) {
		PlatResponse platResponse = this.getPlatById(name);
		if (platResponse.getPrix() != 0) {
			platResponse.setPrix(newPlat.getPrix());
		}
		Plat plat = mapper.map(platResponse, Plat.class);
		repos.save(plat);
		return platResponse;
	}

	@Override
	public PlatResponse getPlatById(String name) {
		Optional<Plat> optional = repos.findById(name);
		Plat plat;
		if (optional.isPresent()) {
			plat = optional.get();
		} else {
			throw new NoSuchElementException("Plat with name not found");
		}
		return mapper.map(plat, PlatResponse.class);
	}

	@Override
	public String deletePlatById(String id) {
		Dessert dessert = new Dessert();
		this.getPlatById(id);
		repos.deleteById(id);
		return ("Plat name " + id + " has been deleted ..");
	}
}