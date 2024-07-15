package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Promozione;
import com.example.demo.repository.PromozioneRepository;

@RestController
@RequestMapping("/promozioni")
public class PromozioneController {
	
	@Autowired
	private PromozioneRepository promozioneRepository;
	
	@GetMapping
	public List<Promozione> getAllPromozioni(){
		return promozioneRepository.findAll();
	}
	
	@GetMapping("/{id}")
    public Promozione getPromozioneById(@PathVariable Long id) {
        return promozioneRepository.getReferenceById(id);
    }

}
