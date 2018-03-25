 package com.shri.askalexa.redx;

import java.util.HashSet;
import java.util.Set;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

 
public class SpeechletRequestHandler extends SpeechletRequestStreamHandler {
	
    private static final Set<String> supportedApplicationIds;

    static {
        /*
         * Application ids for Alexa Application
         * https://developer.amazon.com/edw/home.html#/ 
         * Alexa Skill and put the relevant Application Id..
         */
        supportedApplicationIds = new HashSet<String>();
        supportedApplicationIds.add(Utility.ALEXA_API_KEY);
    }

    public SpeechletRequestHandler() {
    	
        super(new Speechlet(), supportedApplicationIds);
    }
}
