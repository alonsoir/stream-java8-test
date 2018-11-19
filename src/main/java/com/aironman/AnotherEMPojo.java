package com.aironman;

public class AnotherEMPojo {

	private String dateContest;
	private int winer1;
	private int winer2;
	private int winer3;
	private int winer4;
	private int winer5;
	private int star1;
	private int star2;
	
	public AnotherEMPojo() {
		
	}

	public AnotherEMPojo(String dateContest, int winer1, int winer2, int winer3, int winer4, int winer5, int star1,
			int star2) {
		super();
		this.dateContest = dateContest;
		this.winer1 = winer1;
		this.winer2 = winer2;
		this.winer3 = winer3;
		this.winer4 = winer4;
		this.winer5 = winer5;
		this.star1 = star1;
		this.star2 = star2;
	}

	public String getDateContest() {
		return dateContest;
	}

	public void setDateContest(String dateContest) {
		this.dateContest = dateContest;
	}

	public int getWiner1() {
		return winer1;
	}

	public void setWiner1(int winer1) {
		this.winer1 = winer1;
	}

	public int getWiner2() {
		return winer2;
	}

	public void setWiner2(int winer2) {
		this.winer2 = winer2;
	}

	public int getWiner3() {
		return winer3;
	}

	public void setWiner3(int winer3) {
		this.winer3 = winer3;
	}

	public int getWiner4() {
		return winer4;
	}

	public void setWiner4(int winer4) {
		this.winer4 = winer4;
	}

	public int getWiner5() {
		return winer5;
	}

	public void setWiner5(int winer5) {
		this.winer5 = winer5;
	}

	public int getStar1() {
		return star1;
	}

	public void setStar1(int star1) {
		this.star1 = star1;
	}

	public int getStar2() {
		return star2;
	}

	public void setStar2(int star2) {
		this.star2 = star2;
	}

	@Override
	public String toString() {
		return "AnotherEMPojo [dateContest=" + dateContest + ", winer1=" + winer1 + ", winer2=" + winer2 + ", winer3="
				+ winer3 + ", winer4=" + winer4 + ", winer5=" + winer5 + ", star1=" + star1 + ", star2=" + star2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateContest == null) ? 0 : dateContest.hashCode());
		result = prime * result + star1;
		result = prime * result + star2;
		result = prime * result + winer1;
		result = prime * result + winer2;
		result = prime * result + winer3;
		result = prime * result + winer4;
		result = prime * result + winer5;
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
		AnotherEMPojo other = (AnotherEMPojo) obj;
		if (dateContest == null) {
			if (other.dateContest != null)
				return false;
		} else if (!dateContest.equals(other.dateContest))
			return false;
		if (star1 != other.star1)
			return false;
		if (star2 != other.star2)
			return false;
		if (winer1 != other.winer1)
			return false;
		if (winer2 != other.winer2)
			return false;
		if (winer3 != other.winer3)
			return false;
		if (winer4 != other.winer4)
			return false;
		if (winer5 != other.winer5)
			return false;
		return true;
	}
	
	
}
