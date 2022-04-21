package it.uniroma3.siw.model;
import java.util.*;
import javax.persistence.*;

@Entity
public class Indirizzo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nomeVia;
	private String numeroCivico;
	private String comune;
	private String cap;
	private String provincia;
	
	public Indirizzo() {}
	
	public Indirizzo(String nomeVia, String numeroCivico, String comune, String cap, String provicia) {
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

	public String getNumeroCivico() {
		return numeroCivico;
	}

	public void setNumeroCivico(String numeroCivico) {
		this.numeroCivico = numeroCivico;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
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
		return this.getCap().hashCode() + this.getNumeroCivico().hashCode() + this.getNomeVia().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Indirizzo that = (Indirizzo) obj;
		return this.cap.equals(that.getCap()) && this.getNomeVia().equals(that.getNomeVia()) && this.numeroCivico.equals(that.getNumeroCivico());
	}
}