Alexa Integrate with Spring REST Application 

 Technology used :
1.	Java 1.8
2.	Spring boot 2 (REST Server)
3.	Alexa Skill Kit Sdk – Java 
4.	Amazon Development Account (Free for one Year).


Example., 
Scenario 1: Positive scenario
User : Alexa, Open RedX Insurance
Alexa : Welcome to Redx Insurance. You want to check your policy Expiry Date?
User : Yes
Alexa: Please tell me your policy number 
User : A111
Alexa: Thank you. Please tell me your Date of Birth
User: 15 - dec -2017
Alexa: Policy going to expiry in 16-Nov-2018. Thankyou 

Sample Rest URL :

http://localhost:8080/api

http://localhost:8080/validatePolicy/A111

http://localhost:8080/getPolicyExpDate/A111/1999-09-09
