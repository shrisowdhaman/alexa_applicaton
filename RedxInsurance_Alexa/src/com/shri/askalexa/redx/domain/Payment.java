package com.shri.askalexa.redx.domain;

import java.util.Date;

public class Payment {

	private int id;
	private String icnumber;
	private String vehiclenumber;
	private String make;
	private String vehicleclass;
	private String model;
	private Date purchasedate;
	private double suminsured;
	private double payableamount;
	private double capacity;
	private int yearofmake;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getVehicleclass() {
		return vehicleclass;
	}

	public void setVehicleclass(String vehicleclass) {
		this.vehicleclass = vehicleclass;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getPurchasedate() {
		return purchasedate;
	}

	public void setPurchasedate(Date purchasedate) {
		this.purchasedate = purchasedate;
	}

	public double getSuminsured() {
		return suminsured;
	}

	public void setSuminsured(double suminsured) {
		this.suminsured = suminsured;
	}

	public double getPayableamount() {
		return payableamount;
	}

	public void setPayableamount(double payableamount) {
		this.payableamount = payableamount;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public int getYearofmake() {
		return yearofmake;
	}

	public void setYearofmake(int yearofmake) {
		this.yearofmake = yearofmake;
	}

}
