package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.converter.ClientConverter;
import com.example.demo.converter.TableConverter;
import com.example.demo.dto.ClientResponse;
import com.example.demo.dto.TableRequest;
import com.example.demo.dto.TableResponse;
import com.example.demo.models.Client;
import com.example.demo.models.Tablee;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.TableRepository;

@Service
@Validated
public class TableServiceimpl implements TableService {

	@Autowired
	private TableRepository repos;
	private ModelMapper mapper;
	@Autowired
	private TableConverter converter;

	@Autowired
	public TableServiceimpl(TableRepository repos, ModelMapper mapper) {
		super();
		this.repos = repos;
		this.mapper = mapper;
	}

	@Override
	public TableResponse createTable(TableRequest request) {
		Tablee table = converter.DtoToEntity(request);

		table = repos.save(table);

		return mapper.map(converter.entityToDto(table), TableResponse.class);
	}

	@Override
	public List<Tablee> getAllTables() {
		// TODO Auto-generated method stub
		return repos.findAll();
	}

	@Override
	public TableResponse getTableById(int id) {
		Tablee entity;
		Optional<Tablee> opt = repos.findById(id);
		if (opt.isPresent())
			entity = opt.get();
		else
			throw new NoSuchElementException("Table with this id is not found");

		return converter.entityToDto(entity);
	}

	// DELETE BY ID
	@Override
	public String deleteTableById(int id) {
		Tablee entity = new Tablee();
		this.getTableById(id);
		repos.deleteById(id);
		return ("Table number " + id + " has been deleted ..");
	}

	// DELETE ALL TABLES
	@Override
	public String deleteTables() {
		Tablee entity = new Tablee();
		this.getAllTables();
		repos.deleteAll();
		;
		return ("All Tables has been deleted..");
	}

	@Override
	public TableResponse modifyTable(int id, TableRequest newTable) {

		TableResponse tableResponse = this.getTableById(id);

		if (newTable.getType() != null) {
			tableResponse.setType(newTable.getType());
		}

		if (newTable.getSupplement() >= 0) {
			tableResponse.setSupplement(newTable.getSupplement());
		}

		Tablee tablee = mapper.map(tableResponse, Tablee.class);
		repos.save(tablee);
		return tableResponse;

	}
	
	@Override
	public TableResponse plusReserve() {
		Tablee tablee = this.getAllTables().get(0);
		for (int i = 1; i < this.getAllTables().size(); i++) {
			if (tablee.getTicket().size() < this.getAllTables().get(i).getTicket().size()) {
				tablee = this.getAllTables().get(i);
			}
		}
		TableResponse response = mapper.map(tablee, TableResponse.class);
		return response;
	}


}