package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Destinazione;
@Repository 
public interface DestinazioneRepository extends JpaRepository<Destinazione, Long> {
	//trova per nome dest
	List<Destinazione> findByTitoloDestinazioneEquals(String titoloDestinazione);
	//trova per continente
	List<Destinazione> findByContinenteEquals(String continente);
	//filtra per prezzo
	List<Destinazione> findByPrezzoLessThanEqual(Float prezzo);
}
