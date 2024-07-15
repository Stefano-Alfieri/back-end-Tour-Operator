package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Partenza;
import com.example.demo.repository.PartenzaRepository;

@RestController
@RequestMapping("/partenze")
public class PartenzaController {

	@Autowired
	private PartenzaRepository partenzaRepository;

	@GetMapping
	public List<Partenza> getListaPartenze() {
		return partenzaRepository.findAll();
	}

	
}
