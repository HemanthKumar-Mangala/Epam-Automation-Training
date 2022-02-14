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

import static io.restassured.RestAssured.*;
public class restapiadequate {
  String token;

	public void register()
	{
		String postRequestBody="{\r\n"
				+ " \"name\":\"Hemanth\",\r\n"
				+ " \"email\":\"hemanthhemanthhemanth1234567@gmail.com\",\r\n"
				+ " \"password\":\"123456789\"\r\n"
				+ "}";
		
		String url="http://restapi.adequateshop.com/api/authaccount/registration";
		given().body(postRequestBody).and().header("Content-type","application/json").when().post(url).prettyPrint();
	}
	
	
	@BeforeClass
	public void login()
	{
		RestAssured.baseURI="http://restapi.adequateshop.com/api/";
		String postRequestBody="{\r\n"
				+ " \"email\":\"hemanthhemanthhemanth1234567@gmail.com\",\r\n"
				+ " \"password\":\"123456789\",\r\n"+ "}";
		String url="authaccount/login";
		 token =given().body(postRequestBody).and().header("Content-type","application/json")
				.when().post(url).then().statusCode(200).extract().jsonPath().getString("data.Token");
		System.out.println("Token :"+token);
		
	}
	
	@Test
	public void testGet()
	{
		String url="users/38";
//		given().and().header("Authorization","Bearer "+token)
//		.when().get(url).prettyPrint();
		given().and().header("Authorization","Bearer "+token)
		.when().get(url).then().statusCode(200);
	}
	
	public void testpost()
	{
		String url="users/38";
		given().and().header("Authorization","Bearer "+token)
		.when().get(url).then().statusCode(200);
		
	}
	
	
	
	
}
