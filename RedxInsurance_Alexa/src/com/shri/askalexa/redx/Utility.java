package com.shri.askalexa.redx;

public class Utility {

	//ALEXA KEY
	public final static String ALEXA_API_KEY = "amzn1.ask.skill.f177239";
	
	//Validate Policy URL need to append the Policy number 
	public final static String REDX_REST_VALIDATE_POLICY_URL = "http://localhost:8080/validatePolicy/";
	
	//Fetch Policy expiry date based on Policy number and Date Of Birth
	public final static String REDX_REST_POLICY_VALIDATE_UEL="http://localhost:8080/getPolicyExpDate/";
	
	
}
