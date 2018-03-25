package com.shri.askalexa.redx.rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shri.askalexa.redx.Utility;
import com.shri.askalexa.redx.domain.Details;

public class RedXInsuranceRest {

	private static final Logger log = LoggerFactory.getLogger(RedXInsuranceRest.class);

	static Details details = new Details();
	
	public static HttpURLConnection connection = null;
	
	public static BufferedReader response = null;
	
	public static URL resetEndpoint = null;
	
	//Validate the policy based on user input
	public static boolean validatePolicy(String policyNumber) {
		
		boolean validPolicy = false;
		
		try {
			//Policy Number Rest call 
			resetEndpoint = new URL(Utility.REDX_REST_VALIDATE_POLICY_URL.concat(policyNumber));
			
			connection = (HttpURLConnection) resetEndpoint.openConnection();
			
			// Set request method to GET as required from the API
			connection.setRequestMethod("GET");
			
			// Read the Response
			response = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			
			//Convert string to Boolean
			validPolicy = Boolean.parseBoolean(response.readLine());
			
			log.info(">>>>>>>>>>>>> " + validPolicy);
		
		} catch (Exception err) {
			
			log.debug(err.toString());
		}
		
		return validPolicy;
	} 
	
	//Validate the policy based on user input
	public static String getExpiryDate(String policyNumber, String dob) {
			
		 String validPolicy = null;
			
			try {
				//Policy Number Rest call 
				resetEndpoint = new URL(Utility.REDX_REST_VALIDATE_POLICY_URL.concat(policyNumber));
				
				connection = (HttpURLConnection) resetEndpoint.openConnection();
				
				// Set request method to GET as required from the API
				connection.setRequestMethod("GET");
				
				// Read the Response
				response = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
				
				validPolicy = response.readLine();
				
				log.info(">>>>>>>>>>>>> " + validPolicy);
			
			} catch (Exception err) {
				
				log.debug(err.toString());
			}
			
			return validPolicy;
		} 
		
		 


}
