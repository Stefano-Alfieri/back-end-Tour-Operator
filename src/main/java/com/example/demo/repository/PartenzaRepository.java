package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Partenza;

@Repository
public interface PartenzaRepository extends JpaRepository<Partenza , Long> {
	//saearch by name
	List<Partenza> findByNome(String nome);
	//search by price less
	List<Partenza> findByPrezzoLessThanEqual(float prezzo);
}
