package com.aironman.pojo;

public class OutputEntity {

	private Long id;

	private String fecha;

	private Integer winner1;

	private Integer winner2;

	private Integer winner3;

	private Integer winner4;

	private Integer winner5;

	private Integer star1;

	private Integer star2;

	private Float frequency;

	public OutputEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OutputEntity(Long idOutputEntity, String fecha, Integer winner1, Integer winner2, Integer winner3,
			Integer winner4, Integer winner5, Integer star1, Integer star2, Float frequency) {
		super();
		this.id = idOutputEntity;
		this.fecha = fecha;
		this.winner1 = winner1;
		this.winner2 = winner2;
		this.winner3 = winner3;
		this.winner4 = winner4;
		this.winner5 = winner5;
		this.star1 = star1;
		this.star2 = star2;
		this.frequency = frequency;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
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
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((frequency == null) ? 0 : frequency.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (frequency == null) {
			if (other.frequency != null)
				return false;
		} else if (!frequency.equals(other.frequency))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "OutputEntity [id=" + id + ", fecha=" + fecha + ", winner1=" + winner1 + ", winner2=" + winner2
				+ ", winner3=" + winner3 + ", winner4=" + winner4 + ", winner5=" + winner5 + ", star1=" + star1
				+ ", star2=" + star2 + ", frequency=" + frequency + "]";
	}

	
}
