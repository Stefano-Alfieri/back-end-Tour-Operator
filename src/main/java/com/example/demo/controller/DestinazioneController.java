package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Destinazione;
import com.example.demo.repository.DestinazioneRepository;


@RestController
@RequestMapping("/destinaizoni")
public class DestinazioneController {

	@Autowired
	private DestinazioneRepository destinazioneRepository;
	
	@GetMapping
	public List<Destinazione> getAllDestinazioni() {
		return destinazioneRepository.findAll();
	}
	
	
	
}
