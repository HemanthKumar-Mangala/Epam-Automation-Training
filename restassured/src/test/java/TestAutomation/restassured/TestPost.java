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


public class TestPost {

	@Test
	public static void testPostObjectGETResponse()
	{
		given().when().get("https://jsonplaceholder.typicode.com/posts").then().statusCode(200);
		
	}
	
	@Test
	public static void testPostObjectGETResponseWithID()
	{
		given().pathParam("id","1").when().get("https://jsonplaceholder.typicode.com/posts/{id}")
		.then().statusCode(200).body("userId", equalTo(1));
	}
	
	@Test
	public static void testPOstObjID()
	{
		given().pathParam("id","1").when()
		.get("https://jsonplaceholder.typicode.com/posts/{id}").then().statusCode(200);
		}
	
	@Test
	public static void testPOstObjID1PrettyPrint()
	{
		given().pathParam("id","1").when().get("https://jsonplaceholder.typicode.com/posts/{id}").prettyPrint();
		}
	
	@Test (dataProvider="POStid")
	public static void queryparam(String s)
	{
		int a=Integer.parseInt(s);
		given().queryParam("userId", s).when()
		.get("https://jsonplaceholder.typicode.com/posts").
		then().statusCode(200).body("[0].userId",equalTo(a));
	}
	
////	@Test
//	public static void queryparam1()
//	{
//		
//		Response response =given().queryParam("id", "1").when().get("https://jsonplaceholder.typicode.com/posts");
//		String body =response.getBody();
//		
//		JsonPath jsonPathEvaluator = response.jsonPath();
//		
//		List posts = jsonPathEvaluator.getList("Posts");
//
//	
//			
//	}
	
	@DataProvider(name="POStid")
	public Object[][] postids()
	{
		return new Object[][]{{"1"},{"2"},{"3"}};
	}
	
	
	@Test
	public static void testPostObjectPOSTResponse() {

	String postRequestBody="{\r\n"
	+ " \"userId\":7,\r\n"
	+ " \"title\":\"Sample request for rest assured\",\r\n"
	+ " \"body\":\"Sample request for rest assured using postman\"\r\n"
	+ "}";
	given()
	.header("Cotent-type","application/json")
	.and()
	.body(postRequestBody)

	.when()
	.post("/posts")
	.then()
	.statusCode(201);

	}
	
	@Test
	public static void testPostObjectPUTResponse() 
	{
		String putrequest="{\r\n"
				
				+ " \"title\":\"Sample request for rest assured\",\r\n"
				+ " \"body\":\"Sample request for rest assured using postman\"\r\n"
				+ "}";
		given()
		.body(putrequest)
		.when()
		.put( "/post/"+1)
		.then()
		.statusCode(200).body("tittle",equalTo("Sample request for rest assured"));
	}
	
	@Test
	public static void testPostObjectPATCHResponse() 
	{
		String putrequest="{\r\n"
				
				+ " \"title\":\"Sample request for rest assured\",\r\n"
				+ " \"body\":\"Sample request for rest assured using postman\"\r\n"
				+ "}";
		given()
		.body(putrequest)
		.when()
		.patch( "/post/"+1)
		.then()
		.statusCode(200).body("tittle",equalTo("Sample request for rest assured"));
	}
	

	
	
	
		@BeforeClass
		public static void setUp() {
			RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		}
	
}
