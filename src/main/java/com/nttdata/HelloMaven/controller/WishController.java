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
import com.google.cloud.datastore.KeyFactory;
import com.google.common.collect.ImmutableList;
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
		 KeyFactory keyFactory= datastore.newKeyFactory().setKind("prova");
		 Key taskKey1 = keyFactory.newKey("prova1");
		 Entity task1 = Entity.newBuilder(taskKey1)
			        .set("category", "Personal")
			        .set("done", false)
			        .set("priority", 4)
			        .set("description", "Learn Cloud Datastore")
			        .build();
			  
			    datastore.put(task1);
			    return "OK";
		    
		   
		    
//		    String keyName = "test id:5634161670881280";
//		 Key key = datastore.newKeyFactory().setKind("test").newKey(keyName);
//		 Entity entity = datastore.get(key);
//		 return entity.toString();
	}   

}