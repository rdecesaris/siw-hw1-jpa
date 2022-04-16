package it.uniroma3.siw.model;
import javax.persistence.*;
import java.time.*;
import java.util.*;

@Entity
public class Allievo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	private String luogoNascita;
	private String email;
	private String matricola;
	
	@ManyToOne(cascade = {CascadeType.PERSIST})
	/* Se rendiamo persistente un Allievo renderemo persistente anche la Società a cui è associato 
	 * Questo ragionamento non vale per la rimozione dal DB, perchè una Società potrebbe essere associata a più Allievi */
	private Società società;
	
	@ManyToMany(mappedBy = "allievi")
	private List<Corso> corsi;
	
	protected Allievo() {}
	
	public Allievo(String nome, String cognome, LocalDate dataNascita, String luogoNascita, String email,
			String matricola) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.luogoNascita = luogoNascita;
		this.email = email;
		this.matricola = matricola;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public Società getSocietà() {
		return società;
	}

	public void setSocietà(Società società) {
		this.società = società;
	}

	public List<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}

	@Override
	public int hashCode() {
		return this.getMatricola().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Allievo that = (Allievo) obj;
		return this.getMatricola().equals(that.getMatricola());
	}

}
