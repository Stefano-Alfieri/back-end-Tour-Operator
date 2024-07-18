package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Promozione;
import com.example.demo.repository.PromozioneRepository;

@CrossOrigin
@RestController
@RequestMapping("/promozioni")
public class PromozioneController {

	@Autowired
	private PromozioneRepository promozioneRepository;
	//ottenimento lista prmozioni
	@GetMapping
	public List<Promozione> getAllPromozioni() {
		return promozioneRepository.findAll();
	}
	//ricerca promozione per id
	@GetMapping("/{id}")
	public Promozione getPromozioneById(@PathVariable Long id) {
		return promozioneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id non trovato"));
	}
	//creazione promozione
	@PostMapping
	public Promozione createPromozione(@RequestBody Promozione promozione) {
		return promozioneRepository.save(promozione);
	}
	//modifica promozione
	@PutMapping("/{id}")
	public Promozione modificaPromozione(@PathVariable Long id, @RequestBody Promozione promozioneDett) {
		Promozione promozione = promozioneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id non trovato"));
		promozione.setTitoloPromo(promozioneDett.getTitoloPromo());
		promozione.setDescrizionePromo(promozioneDett.getDescrizionePromo());
		return promozioneRepository.save(promozione);
	}
	//elimina promozione
	@DeleteMapping("/{id}")
	public void eliminaPromo(@PathVariable Long id) {
		promozioneRepository.deleteById(id);
	}
}
