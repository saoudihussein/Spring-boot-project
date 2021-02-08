package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ClientResponse;
import com.example.demo.dto.TableRequest;
import com.example.demo.dto.TableResponse;
import com.example.demo.models.Client;
import com.example.demo.models.Tablee;
import com.example.demo.services.TableService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/tables")

public class TableController {

	private TableService service;

	@Autowired
	public TableController(TableService service) {
		super();
		this.service = service;
	}

	// ADD A Table
	@PostMapping
	public TableResponse createtable(@Valid @RequestBody TableRequest table) {
		return service.createTable(table);
	}

	@GetMapping
	public List<Tablee> getAllTables() {
		return service.getAllTables();
	}

	// DISPLAY Table BY ID
	@GetMapping("/{id}")
	public TableResponse getTableById(@PathVariable("id") int id) {
		return service.getTableById(id);
	}

	// DELETE TABLE by ID
	@DeleteMapping("/{id}")
	public String deleteTableById(@PathVariable("id") int id) {
		return service.deleteTableById(id);
	}

	// Modify
	@PutMapping("/{id}")
	private TableResponse modifyTable(@PathVariable("id") int id,@Valid @RequestBody TableRequest newTable) {
		return service.modifyTable(id, newTable);

	}

	// DELETE ALL CLIENTS
	@DeleteMapping()
	public String deleteTables() {
		return service.deleteTables();
	}

	// Most Reserved
	@GetMapping("/plusReserve")
	public TableResponse plusReserve() {
		return service.plusReserve();
	}

}