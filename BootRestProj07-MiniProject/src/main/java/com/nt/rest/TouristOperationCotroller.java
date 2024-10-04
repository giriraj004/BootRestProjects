package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Tourist;
import com.nt.service.ITouristMgmtService;

@RestController
@RequestMapping("/tourist-api")
public class TouristOperationCotroller {

	@Autowired
	private ITouristMgmtService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist){
		//use try
		try {
			//use service
			String msg=service.registerTourist(tourist);
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/display")
	public ResponseEntity<?> fetchAllTourist(){
		//use try
		try {
			//use service
			List<Tourist> list = service.showAllTourist();
			return new ResponseEntity<List<Tourist>>(list,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/show/{city1}/{city2}/{city3}")
	public ResponseEntity<?> fetchTouristByCities(@PathVariable(required = false) String city1,
												  @PathVariable(required = false) String city2,
												  @PathVariable(required = false) String city3){
		//use try
		try {
			//use service
			List<Tourist> list = service.showAllTourist(city1, city2, city3);
			return new ResponseEntity<List<Tourist>>(list,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findTouristById(@PathVariable Integer id){
		try {
			//use Service
			Tourist tourist=service.findTouristById(id);
			return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> UpdateTourist(@RequestBody Tourist tourist){
		
		try {
		//use service
			String msg = service.updateTouristDetails(tourist);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/fetch/{name}")
	public ResponseEntity<?> findTouristByName(@PathVariable String name){
		
		try {
			List<Tourist> list = service.showTouristByName(name);
			return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
