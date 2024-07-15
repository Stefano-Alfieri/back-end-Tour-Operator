package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Preventivo;
import com.example.demo.repository.PreventivoRepository;

@RestController
@RequestMapping
public class PreventivoController {

	@Autowired
	private PreventivoRepository preventivoRepository;
	
	@GetMapping
	public List<Preventivo> getAllPreventivo() {
		return preventivoRepository.findAll();
	}
}
