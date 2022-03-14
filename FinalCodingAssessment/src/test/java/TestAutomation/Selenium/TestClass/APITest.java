package TestAutomation.Selenium.TestClass;
import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import  io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

@Listeners(TestAutomation.Selenium.Listeners.IReporterClass.class)
public class APITest {
	Connection con;
	Statement stmt;
	ResultSet  result;
	public  int speakerId;
	public String speakerName;
	String name;
	@BeforeClass
	public void setup(ITestContext context) throws SQLException {
	con=DriverManager.getConnection("jdbc:mysql://EPINHYDW0087:3306/programs","qa","qa123");
	RestAssured.baseURI="http://epinhydw0087:9090";
	name=context.getCurrentXmlTest().getParameter("spearkerName");
	}

	@Test
	public void extractSpeakerId() throws SQLException {
	stmt = con.createStatement();
	result = stmt.executeQuery("select * from programs.speaker_info where speaker_name = \""+name+"\"");
	while(result.next()) {
	speakerId =result.getInt("id");
	System.out.println("Speaker ID: " + speakerId);
	speakerName = result.getString("speaker_name");
	System.out.println("Speaker Name: " + speakerName);
	
	}
	}
	
	

	@Test(dependsOnMethods= {"extractSpeakerId"})
	public  void testGeSpeaker() {
	String details = given()
	.pathParam("speakerId", speakerId)
	.when()
	.get("/programs/speaker/{speakerId}")
	.then()
	.statusCode(200)
	.extract().jsonPath().getString("speakerName");
	System.out.println("Speaker Name: " + details);
	assertEquals(details,speakerName);
	}
	
}
