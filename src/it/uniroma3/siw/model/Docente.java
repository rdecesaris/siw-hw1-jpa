package it.uniroma3.siw.model;
import javax.persistence.*;
import java.time.*;
import java.util.*;

@Entity
public class Docente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	private String luogoNascita;
	@Column(unique = true, nullable = false)
	private String partitaIVA;
	
	@OneToMany(mappedBy = "docente")
	private List<Corso> corsi;
	
	public Docente() {
		this.corsi = new ArrayList<Corso>();
	}
	
	public Docente(String nome, String cognome, LocalDate dataNascita, String luogoNascita, String partitaIVA) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.luogoNascita = luogoNascita;
		this.partitaIVA = partitaIVA;
		this.corsi = new ArrayList<Corso>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public String getPartitaIVA() {
		return partitaIVA;
	}

	public void setPartitaIVA(String partitaIVA) {
		this.partitaIVA = partitaIVA;
	}
	
	public List<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}

	@Override
	public int hashCode() {
		return this.getPartitaIVA().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Docente that = (Docente) obj;
		return this.getPartitaIVA().equals(that.getPartitaIVA());
	}
}