package com.shri.askalexa.redx.domain;


import java.io.Serializable;
import java.util.Date;


public class Policy implements Serializable {
 
	private static final long serialVersionUID = 1L;  
	 
	private String policynumber;
	 
	private Date dob;
	 
	private Date policyexpdt;


	public String getPolicynumber() {
		return policynumber;
	}

	public void setPolicynumber(String policynumber) {
		this.policynumber = policynumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getPolicyexpdt() {
		return policyexpdt;
	}

	public void setPolicyexpdt(Date policyexpdt) {
		this.policyexpdt = policyexpdt;
	}
		
	 
}
