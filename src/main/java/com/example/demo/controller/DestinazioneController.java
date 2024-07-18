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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Destinazione;
import com.example.demo.model.Sistemazione;
import com.example.demo.repository.DestinazioneRepository;

@CrossOrigin
@RestController
@RequestMapping("/destinazioni")
public class DestinazioneController {

	@Autowired
	private DestinazioneRepository destinazioneRepository;
	
	//ottieni tutte le destinazioni
	@GetMapping
	public List<Destinazione> getAllDestinazioni() {
		return destinazioneRepository.findAll();
	}
	//ottieni destinazione per id
	@GetMapping("/{id}")
	public Destinazione getDestinazioneById(@PathVariable Long id) {
		return destinazioneRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Id non trovato"));
	}
	//ottieni destinazione per nome
	@GetMapping("/searchByName")
	public List<Destinazione> getDestinazioneByName(@RequestParam String titoloDestinazione){
		return destinazioneRepository.findByTitoloDestinazioneEquals(titoloDestinazione);
	}
	//crea destinazione
	@PostMapping
	public Destinazione creaDestinazione(@RequestBody Destinazione destinazione){
		return destinazioneRepository.save(destinazione);
	}
	//cancella destinazione
	@DeleteMapping("/{id}")
	public void eliminaDestinazione(@PathVariable Long id) {
		destinazioneRepository.deleteById(id);
	}
	//filtra per continetne
	@GetMapping("/searchByContinente")
	public List<Destinazione> getDestinazioniByContinente(@RequestParam String continente){
		return destinazioneRepository.findByContinenteEquals(continente);
	}
	//filtra per prezzo
	@GetMapping("/FilterByPriceLessThan")
	public List<Destinazione> getDestinazioneByPrice(@RequestParam Float prezzo) {
		return destinazioneRepository.findByPrezzoLessThanEqual(prezzo);
	}
	
	//modifica destinazione
	@PutMapping("/{id}")
	public Destinazione modificaDestinazione(@PathVariable Long id, @RequestBody Destinazione destinazioneDett) {
		Destinazione destinazione = destinazioneRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id non trovato"));
		destinazione.setTitoloDestinazione(destinazioneDett.getTitoloDestinazione());
		destinazione.setPrezzo(destinazioneDett.getPrezzo());
		destinazione.setContinente(destinazioneDett.getContinente());
		destinazione.setDescrizione(destinazioneDett.getDescrizione());
		return destinazioneRepository.save(destinazione);
	}

	
	
}
