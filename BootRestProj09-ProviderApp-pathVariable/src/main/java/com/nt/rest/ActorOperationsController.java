package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Actor;

@RestController
@RequestMapping("/actor-api")
public class ActorOperationsController {

	@GetMapping("/wish/{id}/{name}")
	public ResponseEntity<String> displayWishMessage(@PathVariable String name,
			                                         @PathVariable Integer id){
		return new ResponseEntity<String>("Good Morning"+id+"....."+name, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerActor(@RequestBody Actor actor){
		return new ResponseEntity<String>("Actor Data::"+actor.toString(),HttpStatus.OK);
		
	}
	
	@GetMapping("/report")
	public ResponseEntity<Actor> showActorData(){
		Actor actor=new Actor(1001,"mahesh","hyd",34000);
		return new ResponseEntity<Actor>(actor, HttpStatus.OK);
		
	}
}
