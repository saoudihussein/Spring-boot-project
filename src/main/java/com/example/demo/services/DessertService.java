package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.DessertRequest;
import com.example.demo.dto.DessertResponse;
import com.example.demo.models.Dessert;

public interface DessertService {

	DessertResponse createDessert(DessertRequest entity);

	List<Dessert> getAllDesserts();

	DessertResponse modifyDessert(String name, DessertRequest newMet);

	DessertResponse getDessertById(String name);

	String deleteDessertById(String id);

}
