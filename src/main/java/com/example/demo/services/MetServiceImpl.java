package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.converter.TicketConverter;
import com.example.demo.dto.MetRequest;
import com.example.demo.dto.MetResponse;
import com.example.demo.dto.TicketResponse;
import com.example.demo.models.Met;
import com.example.demo.repositories.MetRepository;

@Service
@Validated
public class MetServiceImpl implements MetService {

	@Autowired
	private MetRepository repos;
	private ModelMapper mapper;

	@Autowired
	public MetServiceImpl(MetRepository repos, ModelMapper mapper) {
		super();
		this.repos = repos;
		this.mapper = mapper;
	}

	@Override
	public MetResponse createMet(MetRequest request) {

		Met met = mapper.map(request, Met.class);

		met = repos.save(met);

		return mapper.map(met, MetResponse.class);
	}

	@Override
	public List<Met> getAllMets() {
		return repos.findAll();
	}

	@Override
	public MetResponse modifyMet(String nom, MetRequest newMet) {
		MetResponse metResponse = this.getMetById(nom);
		if (newMet.getPrix() != 0) {
			metResponse.setPrix(newMet.getPrix());
		}
		Met met = mapper.map(metResponse, Met.class);
		repos.save(met);
		return metResponse;
	}

	@Override
	public MetResponse getMetById(String nom) {
		Optional<Met> optional = repos.findById(nom);
		Met met;
		if (optional.isPresent()) {
			met = optional.get();
		} else {
			throw new NoSuchElementException("Met with name not found");
		}
		return mapper.map(met, MetResponse.class);
	}

	@Override
	public String deleteMetById(String name) {
		Met met = new Met();
		this.getMetById(name);
		System.out.print(this.getMetById(name));
		repos.deleteById(name);
		return ("Met name " + name + " has been deleted ..");
	}

	@Override
	public String deleteMets() {
		// TODO Auto-generated method stub
		return null;
	}

}