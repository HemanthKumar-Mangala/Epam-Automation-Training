package TestAutomation.restassured;

import static org.testng.Assert.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

import java.util.ArrayList;

import org.testng.annotations.*;

import groovyjarjarantlr.collections.List;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;
import java.util.Iterator;

import java.util.Random;
import static  io.restassured.RestAssured.*;


public class TestObject {
	
String token;
	
	int id;

	double random1;
	double random2;
	Users1 data;
	
	

	@BeforeTest
	
	public void login()
	{
		Random random = new Random();
		random1= random.nextDouble();
		random2 = random.nextDouble();
		JSONObject jsonobj=new JSONObject()
				           .put("email","hemanthhemanthhemanth1234567@gmail.com")
				           .put("password","123456789");
		RestAssured.baseURI="http://restapi.adequateshop.com/api/";
		
		System.out.println(jsonobj);
		


		String url="authaccount/login";
		
		given().body(jsonobj.toString()).and().header("Content-type","application/json").when().post(url).prettyPrint();
//		.when().post(url).
		token=	given().body(jsonobj.toString()).and().header("Content-type","application/json")
				.when().post(url).then().statusCode(200).extract().jsonPath().getString("data.Token");
		System.out.println(token);
		
		 data =new Users1(247,"SureshRaina123456789","Suresh48031978767826"+random1+random2+"@gmail.com","\"http://m/Media/Images/a97579ae-86ec-41db-8810-018ffd7dba3c.png","New Delhi ","2020-05-05T07:25:56.5590666");
		
		
	}

	@Test(priority=1)
	public void testapiPOST_OnPost() {
		
	
		UserReceiver UserRecieve=new UserReceiver();
		Gson gson=new GsonBuilder().create();

		
		Response response= given().header("Authorization", "Bearer " + token).and().header("Content-type", "application/json")
		                  .body(data).when().post("/users")
				          .then().assertThat().statusCode(201)
				           .extract()
				           .response();
		 UserRecieve=gson.fromJson(response.prettyPrint(),UserReceiver.class);
		 
		data.setId(UserRecieve.getId());
		
		id=UserRecieve.getId();
		
		 assertEquals(data.getId(),UserRecieve.getId());
		 assertEquals(data.getEmail(),UserRecieve.getEmail());
		 assertEquals(data.getName(),UserRecieve.getName());
		 
				
			
		
	}
	
	@Test (priority=2)
	public void testapiGET_OnPOst()
	{
		
		UserReceiver UserRecieve=new UserReceiver();
		Gson gson=new GsonBuilder().create();
		
		Response response=given().header("Authorization", "Bearer " + token).and()
				.when().get("/users/" + id).then()
				.assertThat().statusCode(200)
				.extract().response();
		
		 UserRecieve=gson.fromJson(response.prettyPrint(),UserReceiver.class);
		 
		 assertEquals(data.getId(),UserRecieve.getId());
		 assertEquals(data.getEmail(),UserRecieve.getEmail());
		 assertEquals(data.getName(),UserRecieve.getName());
		 
		

		
	}
}
