package com.example.test4;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import android.view.View;
import android.view.View.OnClickListener;
import retrofit.Call;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddObjectAction implements OnClickListener {

	
	private static final String API_BASE_URL = "http://192.168.0.18:8080/";
	private static final OkHttpClient httpClient = new OkHttpClient();
	private static Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL);
	
	@Override
	public void onClick(View v) {
		Gson gson = new GsonBuilder().create();
        gson.toJson("Hello", System.out);
        String object = gson.toJson(new myObject());
       
        
        Retrofit retrofit = builder.client(httpClient).build();
    	try {
    
    		Objects objects = retrofit.create(Objects.class);
    		Response<String> response = objects.create().execute();
    	} catch (Exception e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        
//    	Call<String> s = service.create(myObject.class);
        
//	    try {
//	    	HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead 
//		    
//	    	HttpPost request = new HttpPost("http://couchdb:8080/couchdb/test/objects");
//	        StringEntity params =new StringEntity(object);
//	        request.addHeader("content-type", "application/x-www-form-urlencoded");
//	        request.setEntity(params);
//	        HttpResponse response = httpClient.execute(request);
//	        System.out.println(response.toString());
//
//	    }catch (Exception ex) {
//    		System.out.println("");
//	    }
	}

}
class myObject{

	public myObject() {
	// mandatory
	}
	private String name= "default name";
}

