package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.EntreeRequest;
import com.example.demo.dto.EntreeResponse;
import com.example.demo.models.Entree;

public interface EntreeService {

	EntreeResponse createEntree(EntreeRequest entity);

	List<Entree> getAllEntrees();

	EntreeResponse modifyEntree(String name, EntreeRequest newMet);

	EntreeResponse getEntreeById(String name);

	String deleteEntreeById(String id);

}
