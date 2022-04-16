package it.uniroma3.siw.model;
import java.util.*;
import javax.persistence.*;

@Entity
public class Indirizzo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nomeVia;
	private int numeroCivico;
	private String comune;
	private int cap;
	private String provincia;
	
	protected Indirizzo() {}
	
	public Indirizzo(String nomeVia, int numeroCivico, String comune, int cap, String provicia) {
		super();
		this.nomeVia = nomeVia;
		this.numeroCivico = numeroCivico;
		this.comune = comune;
		this.cap = cap;
		this.provincia = provicia;
	}

	public String getNomeVia() {
		return nomeVia;
	}

	public void setNomeVia(String nomeVia) {
		this.nomeVia = nomeVia;
	}

	public int getNumeroCivico() {
		return numeroCivico;
	}

	public void setNumeroCivico(int numeroCivico) {
		this.numeroCivico = numeroCivico;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public int hashCode() {
		return this.getCap() + this.getNumeroCivico() + this.getNomeVia().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Indirizzo that = (Indirizzo) obj;
		return this.cap == that.getCap() && this.getNomeVia().equals(that.getNomeVia()) && this.numeroCivico == that.getNumeroCivico();
	}
}