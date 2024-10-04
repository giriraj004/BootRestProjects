package com.nt.runner;

import java.net.URI;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorAPITestRunner1 implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
	
		//create Rest templete class object
		RestTemplate templete=new RestTemplate();
		//prepare Service url
		String serviceURl="http://localhost:8080/BootRestProj10-ProviderApp-Exchange/actor-api/register";
		//prepare JSON data request body
		String json_body="{\"aid\":1001,\"name\":\"suresh\",\"addrs\":\"Hyderabad\",\"remunaretion\":230000}";
		
		//prepare headers
		HttpHeaders header=new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		//prepare HTTPREQ as Http entity object having headers and body
		HttpEntity<String> request=new HttpEntity<String>(json_body, header);
		//make http request in post mode 
		ResponseEntity<String> response = templete.exchange(serviceURl, HttpMethod.POST, request,String.class, header);
		
		System.out.println("Response Body(output)::"+response.getBody());
		System.out.println("REsponse Headers::"+response.getHeaders().toString());
		System.out.println("REsponse Status Code::"+response.getStatusCodeValue());
		System.out.println("REsponse Status Code name::"+response.getStatusCode());
		
		
	}

}
