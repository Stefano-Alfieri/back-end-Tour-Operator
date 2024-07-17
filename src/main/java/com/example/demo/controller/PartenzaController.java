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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Destinazione;
import com.example.demo.model.Partenza;
import com.example.demo.repository.PartenzaRepository;

@RestController
@RequestMapping("/partenze")
public class PartenzaController {

	@Autowired
	private PartenzaRepository partenzaRepository;

	// ottieni tutte le partenze
	@GetMapping
	public List<Partenza> getListaPartenze() {
		return partenzaRepository.findAll();
	}

	// ottieni singola partenza
	@GetMapping("{id}")
	public Partenza getPartenzaById(@PathVariable Long id) {
		return partenzaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id non trovato"));
	}

	// creazione
	@PostMapping
	public Partenza creaPartenza(@RequestBody Partenza partenza) {
		return partenzaRepository.save(partenza);
	}

	// ottieni partenza per nome
	@GetMapping("/searchByName")
	public List<Partenza> getPartenzaByNome(@RequestParam String nome) {
		return partenzaRepository.findByNome(nome);
	}

	// ottieni partenza per prezzo
	@GetMapping("/searchByPriceLess")
	public List<Partenza> getPartenzaByPrezzo(@RequestParam float prezzo) {
		return partenzaRepository.findByPrezzoLessThanEqual(prezzo);
	}

	// modifica ppartenza
	@PutMapping("/{id}")
	public Partenza modificaPartenza(@PathVariable Long id, @RequestBody Partenza partenzaDett) {
		Partenza partenza = partenzaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id non trovato"));
		partenza.setNome(partenzaDett.getNome());
		partenza.setPrezzo(partenzaDett.getPrezzo());
		return partenzaRepository.save(partenza);
	}
	
	//cancella partenza
	@DeleteMapping("/{id}")
	public void eliminaPartenza(@PathVariable Long id) {
		partenzaRepository.deleteById(id);
	}

}
