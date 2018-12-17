package com.aironman.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "OutputEntity")
public class OutputEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOutputEntity", updatable = false, nullable = false)
	private Long idOutputEntity;
	
    @Size(min = 1, max = 50)
    @Column(name = "date", updatable = false, nullable = false)
	private String date;
	
    @Column(name = "winner1", updatable = false, nullable = false)
	private Integer winner1;
	
    @Column(name = "winner2", updatable = false, nullable = false)
	private Integer winner2;
	
    @Column(name = "winner3", updatable = false, nullable = false)
	private Integer winner3;
	
    @Column(name = "winner4", updatable = false, nullable = false)
	private Integer winner4;
	
    @Column(name = "winner5", updatable = false, nullable = false)
	private Integer winner5;
	
    @Column(name = "star1", updatable = false, nullable = false)
	private Integer star1;
	
    @Column(name = "star2", updatable = false, nullable = false)
	private Integer star2;
	
    @Column(name = "frequency", updatable = false, nullable = false)
	private Float frequency;

	
	public OutputEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OutputEntity(Long idOutputEntity, String date, Integer winner1, Integer winner2, Integer winner3,
			Integer winner4, Integer winner5, Integer star1, Integer star2, Float frequency) {
		super();
		this.idOutputEntity = idOutputEntity;
		this.date = date;
		this.winner1 = winner1;
		this.winner2 = winner2;
		this.winner3 = winner3;
		this.winner4 = winner4;
		this.winner5 = winner5;
		this.star1 = star1;
		this.star2 = star2;
		this.frequency = frequency;
	}

	public Long getIdOutputEntity() {
		return idOutputEntity;
	}

	public void setIdOutputEntity(Long idOutputEntity) {
		this.idOutputEntity = idOutputEntity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getWinner1() {
		return winner1;
	}

	public void setWinner1(Integer winner1) {
		this.winner1 = winner1;
	}

	public Integer getWinner2() {
		return winner2;
	}

	public void setWinner2(Integer winner2) {
		this.winner2 = winner2;
	}

	public Integer getWinner3() {
		return winner3;
	}

	public void setWinner3(Integer winner3) {
		this.winner3 = winner3;
	}

	public Integer getWinner4() {
		return winner4;
	}

	public void setWinner4(Integer winner4) {
		this.winner4 = winner4;
	}

	public Integer getWinner5() {
		return winner5;
	}

	public void setWinner5(Integer winner5) {
		this.winner5 = winner5;
	}

	public Integer getStar1() {
		return star1;
	}

	public void setStar1(Integer star1) {
		this.star1 = star1;
	}

	public Integer getStar2() {
		return star2;
	}

	public void setStar2(Integer star2) {
		this.star2 = star2;
	}

	public Float getFrequency() {
		return frequency;
	}

	public void setFrequency(Float frequency) {
		this.frequency = frequency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((frequency == null) ? 0 : frequency.hashCode());
		result = prime * result + ((idOutputEntity == null) ? 0 : idOutputEntity.hashCode());
		result = prime * result + ((star1 == null) ? 0 : star1.hashCode());
		result = prime * result + ((star2 == null) ? 0 : star2.hashCode());
		result = prime * result + ((winner1 == null) ? 0 : winner1.hashCode());
		result = prime * result + ((winner2 == null) ? 0 : winner2.hashCode());
		result = prime * result + ((winner3 == null) ? 0 : winner3.hashCode());
		result = prime * result + ((winner4 == null) ? 0 : winner4.hashCode());
		result = prime * result + ((winner5 == null) ? 0 : winner5.hashCode());
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
		OutputEntity other = (OutputEntity) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (frequency == null) {
			if (other.frequency != null)
				return false;
		} else if (!frequency.equals(other.frequency))
			return false;
		if (idOutputEntity == null) {
			if (other.idOutputEntity != null)
				return false;
		} else if (!idOutputEntity.equals(other.idOutputEntity))
			return false;
		if (star1 == null) {
			if (other.star1 != null)
				return false;
		} else if (!star1.equals(other.star1))
			return false;
		if (star2 == null) {
			if (other.star2 != null)
				return false;
		} else if (!star2.equals(other.star2))
			return false;
		if (winner1 == null) {
			if (other.winner1 != null)
				return false;
		} else if (!winner1.equals(other.winner1))
			return false;
		if (winner2 == null) {
			if (other.winner2 != null)
				return false;
		} else if (!winner2.equals(other.winner2))
			return false;
		if (winner3 == null) {
			if (other.winner3 != null)
				return false;
		} else if (!winner3.equals(other.winner3))
			return false;
		if (winner4 == null) {
			if (other.winner4 != null)
				return false;
		} else if (!winner4.equals(other.winner4))
			return false;
		if (winner5 == null) {
			if (other.winner5 != null)
				return false;
		} else if (!winner5.equals(other.winner5))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OutputEntity [idOutputEntity=" + idOutputEntity + ", date=" + date + ", winner1=" + winner1
				+ ", winner2=" + winner2 + ", winner3=" + winner3 + ", winner4=" + winner4 + ", winner5=" + winner5
				+ ", star1=" + star1 + ", star2=" + star2 + ", frequency=" + frequency + "]";
	}
	

}
