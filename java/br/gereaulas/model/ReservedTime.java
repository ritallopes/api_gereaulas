package br.gereaulas.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIME_ID")
    @SequenceGenerator(name = "TIME_ID", sequenceName = "id_seq_reservedtime", allocationSize = 1)
    private Long id;

    public ReservedTime(LocalDateTime start, LocalDateTime endTime) {
        this.start = start;
        this.endTime = endTime;
    }

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((start == null) ? 0 : start.hashCode());
        result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
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
        ReservedTime other = (ReservedTime) obj;
        if (start == null) {
            if (other.start != null)
                return false;
        } else if (!start.equals(other.start))
            return false;
        if (endTime == null) {
            if (other.endTime != null)
                return false;
        } else if (!endTime.equals(other.endTime))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ReservedTime [start=" + start + ", endTime=" + endTime + "]";
    }

}
