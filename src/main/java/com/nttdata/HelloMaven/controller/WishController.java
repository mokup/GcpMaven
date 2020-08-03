package com.nttdata.HelloMaven.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WishController {

	@GetMapping("/welcome")
	public String greeting() {
		return "welcome at all";
	}   

}