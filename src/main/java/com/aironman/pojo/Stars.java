package com.aironman.pojo;

import org.springframework.data.annotation.Id;

public class Stars {

	@Id
	private Long id;
	private Integer star;
	private Float frequency;
	public Stars(Long id, Integer star, Float frequency) {
		super();
		this.id = id;
		this.star = star;
		this.frequency = frequency;
	}
	public Stars() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getStar() {
		return star;
	}
	public void setStar(Integer star) {
		this.star = star;
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
		result = prime * result + ((frequency == null) ? 0 : frequency.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((star == null) ? 0 : star.hashCode());
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
		Stars other = (Stars) obj;
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
		if (star == null) {
			if (other.star != null)
				return false;
		} else if (!star.equals(other.star))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Stars [star=" + star + ", frequency=" + frequency + "]";
	}
	
	
}
