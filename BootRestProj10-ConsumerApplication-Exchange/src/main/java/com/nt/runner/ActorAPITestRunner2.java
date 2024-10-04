package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorAPITestRunner2 implements CommandLineRunner {

	@Override
	
	public void run(String... args) throws Exception {
		

		//create Rest templete class object
		RestTemplate templete=new RestTemplate();
		//prepare Service url
		String serviceURl="http://localhost:8080/BootRestProj10-ProviderApp-Exchange/actor-api/report";
		
		ResponseEntity<String> response=templete.exchange(serviceURl, HttpMethod.GET, null, String.class);
		System.out.println("Response body(output)::"+response.getBody());
		System.out.println("Response Status Code::"+response.getStatusCodeValue());
		System.out.println("Response Status Code name::"+response.getStatusCode());
		
		
	}

}
