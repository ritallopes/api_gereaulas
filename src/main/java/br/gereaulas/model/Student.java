package br.gereaulas.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Student {
    public Student() {
		
	}

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_ID")
    @SequenceGenerator(name = "STUDENT_ID", sequenceName = "id_seq_student", allocationSize = 1)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    String email;
    String name;
    String contato;
    LocalDate dateBirth;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "idResponsible")
    Responsible responsible;
    String address;

    public Student(String email, String name, String contato, LocalDate dateBirth, Responsible responsible,
            String address) {
        this.email = email;
        this.name = name;
        this.contato = contato;
        this.dateBirth = dateBirth;
        this.responsible = responsible;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Responsible getResponsible() {
        return responsible;
    }

    public void setResponsible(Responsible responsible) {
        this.responsible = responsible;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((contato == null) ? 0 : contato.hashCode());
        result = prime * result + ((dateBirth == null) ? 0 : dateBirth.hashCode());
        result = prime * result + ((responsible == null) ? 0 : responsible.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
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
        Student other = (Student) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (contato == null) {
            if (other.contato != null)
                return false;
        } else if (!contato.equals(other.contato))
            return false;
        if (dateBirth == null) {
            if (other.dateBirth != null)
                return false;
        } else if (!dateBirth.equals(other.dateBirth))
            return false;
        if (responsible == null) {
            if (other.responsible != null)
                return false;
        } else if (!responsible.equals(other.responsible))
            return false;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Student [email=" + email + ", name=" + name + ", contato=" + contato + ", dateBirth=" + dateBirth
                + ", responsible= [" + responsible.toString() + "], address=" + address + "]";
    }

}
