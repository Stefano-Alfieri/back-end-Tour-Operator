package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Sistemazione;
import com.example.demo.repository.SistemazioneRepository;

@RestController
@RequestMapping("/sistemazioni")
public class SistemazioneController {

	@Autowired
	private SistemazioneRepository sistemazioneRepository;

	// ottieni sistemazioni
	@GetMapping
	public List<Sistemazione> getAllSistemazioni() {
		return sistemazioneRepository.findAll();
	}

	// ottieni sistemazione per id
	@GetMapping("/{id}")
	public Sistemazione getSistemazioneById(@PathVariable Long id) {
		return sistemazioneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id non trovato"));
	}

	// crea sistemazione
	@PostMapping
	public Sistemazione creaSistemazione(@RequestBody Sistemazione sistemazione) {
		return sistemazioneRepository.save(sistemazione);
	}

	// modifica sistemaizone
	@PutMapping("/{id}")
	public Sistemazione modificaSistemazione(@PathVariable Long id, @RequestBody Sistemazione sistemazioneDett) {
		Sistemazione sistemazione = sistemazioneRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id non trovato"));
		sistemazione.setTipo(sistemazioneDett.getTipo());
		sistemazione.setPrezzo(sistemazioneDett.getPrezzo());
		return sistemazioneRepository.save(sistemazione);
	}

	// cancella sistemazione
	@DeleteMapping("/{id}")
	public void eliminaSistemazione(@PathVariable Long id) {
		sistemazioneRepository.deleteById(id);
	}

}
