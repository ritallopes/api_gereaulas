package br.gereaulas.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class ReservedTime {
    public ReservedTime() {

	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	LocalDateTime start;
    LocalDateTime endTime;
    boolean isOccupied;
    public ReservedTime(LocalDateTime start, LocalDateTime endTime) {
		super();
		this.start = start;
		this.endTime = endTime;
		this.isOccupied = false;
	}

	@Override
	public String toString() {
		return "ReservedTime [start=" + start + ", endTime=" + endTime + ", isOccupied=" + isOccupied + ", teacher="
				+ teacher + ", id=" + id + "]";
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public int hashCode() {
		return Objects.hash(endTime, id, start, teacher);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservedTime other = (ReservedTime) obj;
		return Objects.equals(endTime, other.endTime) && Objects.equals(id, other.id)
				&& Objects.equals(start, other.start) && Objects.equals(teacher, other.teacher);
	}

	public ReservedTime(LocalDateTime start, LocalDateTime endTime, boolean isOccupied, Teacher teacher, Long id) {
		super();
		this.start = start;
		this.endTime = endTime;
		this.isOccupied = isOccupied;
		this.teacher = teacher;
		this.id = id;
	}

	@ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "idTeacher")
	Teacher teacher;
    

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIME_ID")
    @SequenceGenerator(name = "TIME_ID", sequenceName = "id_seq_reservedtime", allocationSize = 1)
    private Long id;


    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return endTime;
    }

    public void setEnd(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    

}
