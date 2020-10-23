package com.nttdata.HelloMaven.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.nttdata.HelloMaven.dao.WishDao;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WishController {
	
	private static final Logger logger = LoggerFactory.getLogger(WishController.class);
	
	@Resource
    WishDao showDao;
	

	@GetMapping("/welcome")
	public String greeting() {
		return "welcome at all 2";
	}   
	
	@GetMapping("/getData")
	public String getData() {
		
		    
		    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
		    String keyName = "5634161670881280";
		 Key key = datastore.newKeyFactory().setKind("test").newKey(keyName);
		 Entity entity = datastore.get(key);
		 return entity.toString();
	}   

}