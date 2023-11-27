package br.gereaulas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Responsible {
    public Responsible() {
	
	}

	String name;
    String email;
    String contato;

    @Override
	public String toString() {
		return "Responsible [name=" + name + ", email=" + email + ", contato=" + contato + ", id=" + id + "]";
	}

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESPONSIBLE_ID")
    @SequenceGenerator(name = "RESPONSIBLE_ID", sequenceName = "id_seq_responsible", allocationSize = 1)
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Responsible(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Responsible(String name, String email, String contato) {
        this.name = name;
        this.email = email;
        this.contato = contato;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((contato == null) ? 0 : contato.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Responsible other = (Responsible) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (contato == null) {
            if (other.contato != null)
                return false;
        } else if (!contato.equals(other.contato))
            return false;
        return true;
    }
}
