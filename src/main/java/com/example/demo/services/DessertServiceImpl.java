package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.converter.TicketConverter;
import com.example.demo.dto.DessertRequest;
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
import com.example.demo.repositories.DessertRepository;
import com.example.demo.repositories.EntreeRepository;
import com.example.demo.repositories.MetRepository;

@Service
@Validated
public class DessertServiceImpl implements DessertService {

	@Autowired
	private DessertRepository repos;
	private ModelMapper mapper;

	@Autowired
	public DessertServiceImpl(DessertRepository repos, ModelMapper mapper) {
		super();
		this.repos = repos;
		this.mapper = mapper;
	}

	@Override
	public DessertResponse createDessert(DessertRequest entity) {
		Dessert dessert = mapper.map(entity, Dessert.class);

		dessert = repos.save(dessert);

		return mapper.map(dessert, DessertResponse.class);

	}

	@Override
	public List<Dessert> getAllDesserts() {
		List<Dessert> desserts = repos.findAll();

		/*List<DessertResponse> dessertResponses = null;
		for (int i = 0; i < desserts.size(); i++) {
			dessertResponses.add(mapper.map(desserts.get(i), DessertResponse.class));
		}*/

		return desserts;
	}

	@Override
	public DessertResponse modifyDessert(String name, DessertRequest newDessert) {
		DessertResponse dessertResponse = this.getDessertById(name);
		if (newDessert.getPrix() != 0) {
			dessertResponse.setPrix(newDessert.getPrix());
		}
		Dessert dessert = mapper.map(dessertResponse, Dessert.class);
		repos.save(dessert);
		return dessertResponse;
	}

	@Override
	public DessertResponse getDessertById(String name) {
		Optional<Dessert> optional = repos.findById(name);
		Dessert dessert;
		if (optional.isPresent()) {
			dessert = optional.get();
		} else {
			throw new NoSuchElementException("Dessert with name not found");
		}
		return mapper.map(dessert, DessertResponse.class);
	}

	@Override
	public String deleteDessertById(String id) {
		Dessert dessert = new Dessert();
		this.getDessertById(id);
		repos.deleteById(id);
		return ("Dessert name " + id + " has been deleted ..");
	}	

}