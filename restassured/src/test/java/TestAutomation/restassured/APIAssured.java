package TestAutomation.restassured;

import static org.testng.Assert.*;

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

public class APIAssured {
	String token;
	int id;

	double random1;
	double random2;
	
	

	@BeforeTest
	
	public void login()
	{
		Random random = new Random();
		random1= random.nextDouble();
		random2 = random.nextDouble();
		RestAssured.baseURI="http://restapi.adequateshop.com/api/";
		String postRequestBody="{\r\n"
				+ " \"email\":\"hemanthhemanthhemanth1234567@gmail.com\",\r\n"
				+ " \"password\":\"123456789\",\r\n"+ "}";
		String url="authaccount/login";
		 token =given().body(postRequestBody).and().header("Content-type","application/json")
				.when().post(url).then().statusCode(200).extract().jsonPath().getString("data.Token");
		
		
	}

	@Test(dependsOnMethods= {"testapiPOST"})
	public void testApiGET() {
		given().header("Authorization", "Bearer " + token).and().when().get("/users/" + id).then().statusCode(200);
	}

	
	@Test
	public void testapiPOST() {
		String data = "{\r\n"
				+ "\"id\":927,\r\n" 
				+ " \"name\": \"SureshKumar48\",\r\n"
				+ " \"email\": \"Sureshraina123456789978765" + random1+ random2 + "@gmail.com\",\r\n"
				+ " \"profilepicture\": \"http://restapi.adequateshop.com/Media/Images/a97579ae-86ec-41db-8810-018ffd7dba3c.png\",\r\n"
				+ " \"location\": \"New Delhi, Delhi, India\",\r\n"
				+ " \"createdat\": \"2020-05-05T07:25:56.5590666\"\r\n" + "}";
		 id=given().header("Authorization", "Bearer " + token).and().header("Content-type", "application/json")
				.body(data).when().post("/users").then().extract().jsonPath().getInt("id");
		
	}

	@Test(dependsOnMethods= {"testApiGET"})
	public void testapiPUT() {
		String data = "{\r\n" + " \"id\":" + id + ",\r\n"
				+ " \"name\": \"HemanthKumar3033\",\r\n"
				+ " \"email\": \"Hemanth1256789@gmail.com\",\r\n"
				+ " \"profilepicture\": \"http://restapi.adequateshop.com/Media/Images/a97579ae-86ec-41db-8810-018ffd7dba3c.png\",\r\n"
				+ " \"location\": \"New Delhi, Delhi, India\",\r\n"
				+ " \"createdat\": \"2020-05-05T07:25:56.5590666\"\r\n" + "}";
		given().pathParam("id", id).header("Authorization", "Bearer " + token).and()
				.header("Content-type", "application/json").body(data).when().put("/users/{id}").then().statusCode(200);
	}

	@Test(dependsOnMethods= {"testapiPUT"})
	public void testapiDELETE() { 
		
		given().pathParam("id", id).header("Authorization", "Bearer " + token).and()
				.header("Content-type", "application/json").when().delete("/users/{id}").then().statusCode(200);
	}

}
