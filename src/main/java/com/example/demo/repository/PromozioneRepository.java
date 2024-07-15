package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Promozione;
@Repository
public interface PromozioneRepository extends JpaRepository<Promozione, Long> {

}
