package com.remotebash.api.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiRestController {
	

	@GetMapping(value = "/api/remotebash")
	public String api() {
		return "Welcome to RemoteBash API REST";
	}

}
