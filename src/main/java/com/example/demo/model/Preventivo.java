package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Preventivo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private int nViaggiatori;
	private boolean minore;
	private int nGiorni;
	
	@OneToOne
	@JoinColumn(name="destinazione_id")
	private Destinazione destinazione;
	
	@JoinColumn(name="partenza_id")
	private Partenza partenza;
	
	@JoinColumn(name="sistemazione_id")
	private Sistemazione sistemazione;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getnViaggiatori() {
		return nViaggiatori;
	}

	public void setnViaggiatori(int nViaggiatori) {
		this.nViaggiatori = nViaggiatori;
	}

	public boolean isMinore() {
		return minore;
	}

	public void setMinore(boolean minore) {
		this.minore = minore;
	}

	public int getnGiorni() {
		return nGiorni;
	}

	public void setnGiorni(int nGiorni) {
		this.nGiorni = nGiorni;
	}

	public Destinazione getDestinazione() {
		return destinazione;
	}

	public void setDestinazione(Destinazione destinazione) {
		this.destinazione = destinazione;
	}

	public Partenza getPartenza() {
		return partenza;
	}

	public void setPartenza(Partenza partenza) {
		this.partenza = partenza;
	}

	public Sistemazione getSistemazione() {
		return sistemazione;
	}

	public void setSistemazione(Sistemazione sistemazione) {
		this.sistemazione = sistemazione;
	}
	
	
}
