package com.shri.askalexa.redx.domain;

import java.util.List;

public class Details {

	List<String> pol_list;
	int size;
	String icnumber;
	String vehiclenumber;

	public List<String> getPol_list() {
		return pol_list;
	}

	public void setPol_list(List<String> pol_list) {
		this.pol_list = pol_list;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getIcnumber() {
		return icnumber;
	}

	public void setIcnumber(String icnumber) {
		this.icnumber = icnumber;
	}

	public String getVehiclenumber() {
		return vehiclenumber;
	}

	public void setVehiclenumber(String vehiclenumber) {
		this.vehiclenumber = vehiclenumber;
	}

}
