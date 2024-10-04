package com.nt.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CustomerOperationController {
	@GetMapping("/report/{cno}/{cname}")
	public String showReport(@PathVariable(name="cno",required = false) Integer no,
			                 @PathVariable(required = false) String cname) {
		
		return "from showData";
	}
	@GetMapping("/report/cno/cname")
	public String showReport1(@PathVariable(name="cno",required = false) Integer no,
			                 @PathVariable(required = false) String cname) {
		return "from showData1";
	}
	@GetMapping("/report/cno/{cname}")
	public String showReport2(@PathVariable(name="cno",required = false) Integer no,
			                 @PathVariable(required = false) String cname) {
		return "from showData2";
	}
	@GetMapping("/report/{cno}/cname")
	public String showReport3(@PathVariable(name="cno",required = false) Integer no,
			                 @PathVariable(required = false) String cname) {
		return "from showData3";
	}
	
}
