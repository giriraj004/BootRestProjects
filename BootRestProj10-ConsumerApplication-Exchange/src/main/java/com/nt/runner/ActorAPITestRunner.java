package com.nt.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorAPITestRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		//create Rest templete class object
		RestTemplate templete=new RestTemplate();
		//prepare service url
		String serviceURl="http://localhost:8080/BootRestProj10-ProviderApp-Exchange/actor-api/wish/{id}/{name}";
		//Generate HTTPReq eith get mode req to consume the service api
		ResponseEntity<String> response = templete.exchange(serviceURl, HttpMethod.GET, null,String.class,1001,"Giriraj" );
		
		System.out.println("REsponse Body(output)::"+response.getBody());
		System.out.println("REsponse Status Code::"+response.getStatusCodeValue());
		System.out.println("REsponse Status Code name::"+response.getStatusCode());
	
		
		
		
	}

}
