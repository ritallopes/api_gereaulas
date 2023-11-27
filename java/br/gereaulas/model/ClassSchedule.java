package br.gereaulas.model;

import org.hibernate.annotations.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class ClassSchedule {
    public ClassSchedule() {
	
	}

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "idTime")
    ReservedTime time;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "idStudent")
    Student student;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "idTeacher")
    Teacher teacher;
    boolean residential;
    double paymentAmount;
    String subject;
    String status;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLASS_ID")
    @SequenceGenerator(name = "CLASS_ID", sequenceName = "id_seq_class", allocationSize = 1)
    private Long id;

    public ClassSchedule(ReservedTime time, Student student, Teacher teacher, boolean residential, double paymentAmount,
            String subject, String status) {
        this.time = time;
        this.student = student;
        this.teacher = teacher;
        this.residential = residential;
        this.paymentAmount = paymentAmount;
        this.subject = subject;
        this.status = status;
    }

    public ReservedTime getTime() {
        return time;
    }

    public void setTime(ReservedTime time) {
        this.time = time;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public boolean isResidential() {
        return residential;
    }

    public void setResidential(boolean residential) {
        this.residential = residential;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((time == null) ? 0 : time.hashCode());
        result = prime * result + ((student == null) ? 0 : student.hashCode());
        result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
        result = prime * result + (residential ? 1231 : 1237);
        long temp;
        temp = Double.doubleToLongBits(paymentAmount);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        ClassSchedule other = (ClassSchedule) obj;
        if (time == null) {
            if (other.time != null)
                return false;
        } else if (!time.equals(other.time))
            return false;
        if (student == null) {
            if (other.student != null)
                return false;
        } else if (!student.equals(other.student))
            return false;
        if (teacher == null) {
            if (other.teacher != null)
                return false;
        } else if (!teacher.equals(other.teacher))
            return false;
        if (residential != other.residential)
            return false;
        if (Double.doubleToLongBits(paymentAmount) != Double.doubleToLongBits(other.paymentAmount))
            return false;
        return true;
    }
}
