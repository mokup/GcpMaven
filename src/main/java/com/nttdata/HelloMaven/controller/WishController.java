package com.nttdata.HelloMaven.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.EntityQuery;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.Value;
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
	
	@GetMapping("/storeData")
	public String storeData() {
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
	
	@GetMapping("/getData")
	public String getData() {
		String string = "";
		EntityQuery.Builder queryBuilder = Query.newEntityQueryBuilder().setKind("prova");
		 Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
			QueryResults<Entity> tasks = datastore.run(queryBuilder.build());
			while (tasks.hasNext()) {
			  Entity task = tasks.next();
			  // do something with the task
			  string+=task.getKey().getName()+",";
			}
		    return string;
		   
		    
//		    String keyName = "test id:5634161670881280";
//		 Key key = datastore.newKeyFactory().setKind("test").newKey(keyName);
//		 Entity entity = datastore.get(key);
//		 return entity.toString();
	}   
	
	@GetMapping("/getDataByKeyName")
	public String getDataByKeyName() {
		String string = "";
//		EntityQuery.Builder queryBuilder = Query.newEntityQueryBuilder().setKind("prova");
		 Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
		 Key key = datastore.newKeyFactory().setKind("prova").newKey("prova1");
//		 Map<String, Value<?>> map=datastore.get(key).getProperties();
//		 Iterator<String> it=map.keySet().iterator();
//		 while (it.hasNext()) {
//			 String k=(String) it.next();
//			string += k+"="+map.get(k)
//			
//		}
		 
		 return datastore.get(key).getValue("category").toString();
		   
		    
//		    String keyName = "test id:5634161670881280";
//		 Key key = datastore.newKeyFactory().setKind("test").newKey(keyName);
//		 Entity entity = datastore.get(key);
//		 return entity.toString();
	}   

}