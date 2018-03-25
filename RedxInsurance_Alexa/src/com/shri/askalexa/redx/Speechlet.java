package com.shri.askalexa.redx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.speechlet.SpeechletV2;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import com.shri.askalexa.redx.domain.Payment;
import com.shri.askalexa.redx.rest.RedXInsuranceRest;


public class Speechlet implements SpeechletV2 {
	
	private static final Logger log = LoggerFactory.getLogger(Speechlet.class);

	//Check the policy expiry date
	String policyExpiryDate = null;
	
	//Used to check the valid Policy 
	boolean validPolicy = false;
	
	String policyNumber = null; 
	
	String speechText, repromptText;
	
	String expiryDate;
	
	boolean isAskResponse = false;
	
	//Rest Application Client 
	RedXInsuranceRest restClient;
	
	Payment payment=new Payment();
	
	private static final String POLICY_NUMBER = "policy number"; 
	
	private static final String DATE_OF_BIRTH = "Date Of Birth";

	@Override
	public void onSessionStarted(SpeechletRequestEnvelope<SessionStartedRequest> requestEnvelope) {
		
		log.info("onSessionStarted requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
				requestEnvelope.getSession().getSessionId());
	}

	//OnLaunch the application, alexa need to provide welcome message 
	@Override
	public SpeechletResponse onLaunch(SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {
		
		log.info("onLaunch requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
				requestEnvelope.getSession().getSessionId());
		
		return getWelcomeMessage();
	}

	
	//The specifies list of intents that can be sent to the skill.
	@Override
	public SpeechletResponse onIntent(SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
		
		IntentRequest request = requestEnvelope.getRequest();
		
		Session session = requestEnvelope.getSession();
		
		log.info("onIntent requestId={}, sessionId={}", request.getRequestId(), session);

		// Get intent from the request object.
		Intent intent = request.getIntent();
		String intentName = (intent != null) ? intent.getName() : null;
		
		// If the session is started with an intent, no welcome message will be rendered;
		// rather, the intent specific response will be returned.
		// Build in Amazon intent 
		// https://developer.amazon.com/docs/custom-skills/standard-built-in-intents.html
		
		if ("WelcomeInfoIntent".equals(intentName)) {
			return getPolicyNumber(intent, session);			
		} else if ("Policy Expiry Date".equals(intentName)) {
			return getPolicyExpiryDate(intent, session);
		} else if ("AMAZON.HelpIntent".equals(intent.getName())) { // help, help me, can you help me
			return getHelpIntentResponse(intent, session);
		} else if ("AMAZON.CancelIntent".equals(intent.getName())) { // Cancel Intent (cancel/ forget it/ never mind 
			return getExitIntentResponse(intent, session);
		} else if ("AMAZON.StopIntent".equals(intent.getName())) { //Stop off shut up
			return getExitIntentResponse(intent, session);
		} else {
			String errorSpeech = "Sorry, Please try something else.";
			return getSpeechletResponse(errorSpeech, errorSpeech, true);
		}
	}

	//End of session
	@Override
	public void onSessionEnded(SpeechletRequestEnvelope<SessionEndedRequest> requestEnvelope) {
		log.info("onSessionEnded requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
				requestEnvelope.getSession().getSessionId());		
	}
 
	//Welcome Alexa Message
	private SpeechletResponse getWelcomeMessage() {
		 
		 speechText = "Welcome to Redx Insurance. You want to check your policy Expiry Date?";
		 repromptText = "Welcome to Redx Insurance. You want to check your policy Expiry Date?";

		return getSpeechletResponse(speechText, repromptText, true);
	}

    // Policy Number
	@SuppressWarnings("static-access")
	private SpeechletResponse getPolicyNumber(final Intent intent, final Session session) {
		
		// Get the slots from the intent.
		policyNumber = intent.getSlot(POLICY_NUMBER).getValue();
		
		//If policy number is null / empty
		if(policyNumber.isEmpty()) {
			
			speechText = String.format("Please, tell me your valid policy number.");
			repromptText = String.format("Please, tell me your valid policy number.");
			
		} else {
			
			//Validate the policy based on user input
			validPolicy = restClient.validatePolicy(policyNumber);
			
			if(validPolicy) {
				
				speechText = String.format("Thanks you! Your policy number is valid");
				repromptText = "Thanks you! Your policy number is valid";
				isAskResponse = true;
				
			}else {
				speechText = String.format("Given policy number is Not valid");
				repromptText = "Given policy number is Not valid";
				isAskResponse = false;
			}
		}
		
		return getSpeechletResponse(speechText, repromptText, isAskResponse);
	}

	// Policy Expiry Date
	@SuppressWarnings("static-access")
	private SpeechletResponse getPolicyExpiryDate(final Intent intent, final Session session) {
			
			// Get the slots from the intent.
			String dob  = intent.getSlot(DATE_OF_BIRTH).getValue();
			 

			//If policy number is null / empty
			if(policyNumber.isEmpty()) {				
				speechText = String.format("Please, tell me your valid policy number.");
				repromptText = String.format("Please, tell me your valid policy number.");
				
			} else {
				
				//Validate the policy based on user input
				expiryDate =  restClient.getExpiryDate(policyNumber,dob);
				
				if(expiryDate != null) {					
					speechText = String.format("Your policy Expiry Date "+expiryDate);
					repromptText = "Your policy Expiry Date \"+expiryDate";
					isAskResponse = true;					
				}else {
					speechText = String.format("Given Date of birth against policy number "+ policyNumber +" is Not valid");
					repromptText = "Given Date of birth against policy number \"+ policyNumber +\" is Not valid";
					isAskResponse = false;
				}
			}
			
			return getSpeechletResponse(speechText, repromptText, isAskResponse);
		}


	 

	public SpeechletResponse getHelpIntentResponse(Intent intent,Session session) {

		speechText = String.format("How can I help you,Please tell me your policy number to proceed");

		repromptText = "Kindly, Tell me your Policy number";

		return getSpeechletResponse(speechText, repromptText, true);
	}

	public SpeechletResponse getExitIntentResponse(Intent intent, Session session) {
		 
		speechText = String.format("Goodbye");

		return getSpeechletResponse(speechText, speechText, isAskResponse);
	}

	/**
	 * Based user voice message, it Returns a Speechlet response for a speech and reprompt text.
	 */
	private SpeechletResponse getSpeechletResponse(String speechText, String repromptText, boolean isAskResponse) {
		
		// Create the Simple card content.
		SimpleCard card = new SimpleCard();
		
		card.setTitle("RedxInsurance");
		card.setContent(speechText);

		// Create the plain text output.
		PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText(speechText);

		if (isAskResponse) {
			
			// Create reprompt
			PlainTextOutputSpeech repromptSpeech = new PlainTextOutputSpeech();
			repromptSpeech.setText(repromptText);
			
			Reprompt reprompt = new Reprompt();
			reprompt.setOutputSpeech(repromptSpeech);

			return SpeechletResponse.newAskResponse(speech, reprompt, card);

		} else {
			return SpeechletResponse.newTellResponse(speech, card);
		}
	}

 
}
