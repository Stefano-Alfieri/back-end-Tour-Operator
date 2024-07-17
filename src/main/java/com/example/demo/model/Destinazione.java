package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Destinazione {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String titoloDestinazione;
	private String continente;
	private String descrizione;
	private Float prezzo;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitoloDestinazione() {
		return titoloDestinazione;
	}
	public void setTitoloDestinazione(String titoloDestinazione) {
		this.titoloDestinazione = titoloDestinazione;
	}
	public String getContinente() {
		return continente;
	}
	public void setContinente(String continente) {
		this.continente = continente;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}
}
