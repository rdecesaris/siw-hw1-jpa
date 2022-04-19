package it.uniroma3.siw.model;
import javax.persistence.*;
import java.time.*;
import java.util.*;

@Entity
public class Corso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private LocalDate dataInizio;
	private int durataInMesi;
	
	@ManyToMany
	private List<Allievo> allievi;
	
	@ManyToOne(cascade = {CascadeType.PERSIST})
	/* Il Docente dipende direttamente dal Corso: se aggiungiamo un Corso aggiungiamo anche il suo Docente
	 * Questo ragionamento non vale per la rimozione dal DB perch� un Docente potrebbe essere associato a pi� Corsi */
	private Docente docente;
	
	protected Corso() {}
	
	public Corso(String nome, LocalDate dataInizio, int durataInMesi) {
		super();
		this.nome = nome;
		this.dataInizio = dataInizio;
		this.durataInMesi = durataInMesi;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public int getDurataInMesi() {
		return durataInMesi;
	}

	public void setDurataInMesi(int durataInMesi) {
		this.durataInMesi = durataInMesi;
	}
	
	public List<Allievo> getAllievi() {
		return allievi;
	}

	public void setAllievi(List<Allievo> allievi) {
		this.allievi = allievi;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Corso that = (Corso) obj;
		return this.getNome().equals(that.getNome()) && this.getDataInizio().equals(that.getDataInizio());
	}
}