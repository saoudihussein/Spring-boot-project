package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.MetRequest;
import com.example.demo.dto.MetResponse;
import com.example.demo.dto.PlatRequest;
import com.example.demo.dto.PlatResponse;
import com.example.demo.models.Met;
import com.example.demo.models.Plat;

public interface PlatService {

	PlatResponse createPlat(PlatRequest entity);

	List<Plat> getAllPlats();

	PlatResponse modifyPlat(String name, PlatRequest newMet);

	PlatResponse getPlatById(String name);

	String deletePlatById(String id);

}
