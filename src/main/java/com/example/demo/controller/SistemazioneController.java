package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Sistemazione;
import com.example.demo.repository.SistemazioneRepository;

@RestController
@RequestMapping 
public class SistemazioneController {

	@Autowired
	private SistemazioneRepository sistemazioneRepository;
	
	@GetMapping
	public List<Sistemazione> getAllSistemazioni() {
		return sistemazioneRepository.findAll();
	}
}
