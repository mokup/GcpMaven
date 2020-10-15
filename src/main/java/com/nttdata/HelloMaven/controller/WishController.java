package com.nttdata.HelloMaven.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.HelloMaven.dao.WishDao;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WishController {
	
	private static final Logger logger = LoggerFactory.getLogger(WishController.class);
	
	@Resource
    WishDao showDao;

	@GetMapping("/welcome")
	public String greeting() {
		return "welcome at all ";
	}   
	
	@GetMapping("/getData")
	public String getData() {
		try {
			logger.info("Logging getData - Start");
		    String toret=showDao.findAll().toString();
		    logger.info("Logging getData - End");
			return toret;
		}
		catch(Exception ex) {
			logger.error("Logging getData - END",ex);
			return null;
		}
	}   

}