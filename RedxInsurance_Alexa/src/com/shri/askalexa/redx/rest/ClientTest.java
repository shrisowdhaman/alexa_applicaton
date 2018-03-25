package com.shri.askalexa.redx.rest;


public class ClientTest{
	
	public static void main(String args[]) {
		
		System.out.println(">>>>>>>>>>>>>>>>>>");
		RedXInsuranceRest rest = new RedXInsuranceRest();
		rest.validatePolicy("A111");
	}
}