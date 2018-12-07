package com.aironman;

public class OutputFlatten {

	private String type;
	private String value;

	public void setType(String type) {
		this.type = type;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public OutputFlatten(String type, String value) {
		super();
		this.type = type;
		this.value = value;
	}

	public OutputFlatten() {
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

}
