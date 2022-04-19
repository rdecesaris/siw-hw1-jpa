package it.uniroma3.siw.model;
import java.util.*;

import javax.persistence.*;

@Entity
public class Società {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String ragioneSociale;
	private int numeroTelefono;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	/* L'Indirizzo dipende direttamente dalla Società: se rendiamo persistente una Società renderemo persistente anche il suo Indirizzo
	 * Questo ragionamento non vale per la rimozione dal DB perchè Indirizzo potrebbe essere associato a più Società */
	private Indirizzo indirizzo;
	
	protected Società() {}
	
	public Società(String ragioneSociale, int numeroTelefono) {
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
		Società that = (Società) obj;
		return this.getRagioneSociale().equals(that.getRagioneSociale());
	}
}
