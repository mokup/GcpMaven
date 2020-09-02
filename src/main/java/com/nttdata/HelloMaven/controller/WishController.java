package com.nttdata.HelloMaven.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.HelloMaven.dao.WishDao;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WishController {
	
	@Resource
    WishDao showDao;

	@GetMapping("/welcome")
	public String greeting() {
		return "welcome at all";
	}   
	
	@GetMapping("/getData")
	public String getData() {
		return showDao.findAll().toString();
	}   

}