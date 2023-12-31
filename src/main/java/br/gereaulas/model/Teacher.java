package br.gereaulas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Teacher {
    public Teacher() {
		
	}

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEACHER_ID")
    @SequenceGenerator(name = "TEACHER_ID", sequenceName = "id_seq_teacher", allocationSize = 1)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((image_profile == null) ? 0 : image_profile.hashCode());
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
        Teacher other = (Teacher) obj;

        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;

        return true;
    }

    String name;
    String email;
    String image_profile;

    public Teacher(String name, String email, String image_profile) {
        this.name = name;
        this.email = email;
        this.image_profile = image_profile;
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

    public String getImageProfile() {
        return image_profile;
    }

    public void setImageProfile(String image_profile) {
        this.image_profile = image_profile;
    }

    @Override
    public String toString() {
        return "Professor [name=" + name + ", email=" + email + ", image_profile=" + image_profile + "]";
    }

}
