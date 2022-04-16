package it.uniroma3.siw.model;
import java.util.*;

import javax.persistence.*;

@Entity
public class Societ� {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String ragioneSociale;
	private int numeroTelefono;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	/* L'Indirizzo dipende direttamente dalla Societ�: se rendiamo persistente una Societ� renderemo persistente anche il suo Indirizzo
	 * Questo ragionamento non vale per la rimozione dal DB perch� Indirizzo potrebbe essere associato a pi� Societ� */
	private Indirizzo indirizzo;
	
	protected Societ�() {}
	
	public Societ�(String ragioneSociale, int numeroTelefono) {
		super();
		this.ragioneSociale = ragioneSociale;
		this.numeroTelefono = numeroTelefono;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public int getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	
	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	@Override
	public int hashCode() {
		return this.getRagioneSociale().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Societ� that = (Societ�) obj;
		return this.getRagioneSociale().equals(that.getRagioneSociale());
	}
}