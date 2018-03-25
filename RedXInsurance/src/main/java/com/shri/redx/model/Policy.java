package com.shri.redx.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name = "policy")
public class Policy implements Serializable {

 
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "policyNumber")
	private String policynumber;
	
	@Column(name ="dob")
	private Date dob;
	
	//Policy ExpiryDate
	@Column(name = "policyExpDt")
	private Date policyexpdt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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
