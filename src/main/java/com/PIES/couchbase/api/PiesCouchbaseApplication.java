package com.PIES.couchbase.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;

import com.couchbase.client.java.*;
import com.couchbase.client.java.kv.*;
import com.couchbase.client.java.json.*;
import com.couchbase.client.java.query.*;

@SpringBootApplication
public class PiesCouchbaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiesCouchbaseApplication.class, args);
		
		/*
		Establish Cluster connection
		Username and Password will be what you establish as- 
			your own local connection to Couchbase server
		*/
		Cluster cluster = Cluster.connect("localhost", "username", "password");
		//Get Bucket reference
		Bucket pies = cluster.bucket("PIES");
		
		//Get defined Collection -- Syntax goes: bucket.scope.collection
		//Both scope and collection are _default
		Scope scope = pies.scope("_default");
		Collection collection = scope.collection("_default");
		
		
		//Get Document from specified Bucket
		GetResult getResult = collection.get("1");
		String name  = getResult.contentAsObject().getString("name");
		System.out.println(name);
	}

}
