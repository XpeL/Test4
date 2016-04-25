package com.example.test4;


import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

public interface Objects {
	
  @GET("couchdb/test/objects/")
  Call<String> create();
  
}