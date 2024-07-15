package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Promozione {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String titoloPromo;
	private String descrizionePromo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitoloPromo() {
		return titoloPromo;
	}
	public void setTitoloPromo(String titoloPromo) {
		this.titoloPromo = titoloPromo;
	}
	public String getDescrizionePromo() {
		return descrizionePromo;
	}
	public void setDescrizionePromo(String descrizionePromo) {
		this.descrizionePromo = descrizionePromo;
	}
	
	
	
}
