package TestAutomation.selinium.RestAssuredAPIProject;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import java.net.MalformedURLException;
import java.util.LinkedHashMap;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class RestAPITesting {
	String punchinId;
	String token;
	String cookie;
	String punchIntime;
	String punchOuttime;
	String total;
	String totaltimeafterpunchout;
	String totalafterdelete;
	int timebeforpunchin;
	int timeafterpunchin;
	@BeforeClass
	public void setup(ITestContext context) throws MalformedURLException{
		this.token=context.getCurrentXmlTest().getParameter("Token");
		this.cookie=context.getCurrentXmlTest().getParameter("cookie");
		RestAssured.baseURI="https://prasoonr-trials73.orangehrmlive.com";
	}
	
	@Test(priority=1)
	public void testAttendancesheet() {
	String id=given()
	.header("Authorization","Bearer "+token).and()
	.header("Cookie",cookie).and()
	.header("Content-type","application/x-www-form-urlencoded")
	.when()
	.get("/api/attendanceSheet")
	.then()
	.statusCode(200).extract().jsonPath().get("data.latestSheetId");
	assertNotNull(id);
	System.out.println("Data id is "+id);
	}
	
	@Test(priority=2,enabled=true)
	public void testAttendancesheetIdGET() {
	String data="id=653";
	total=given()
	.header("Authorization","Bearer "+token).and()
	.header("Cookie",cookie)
	.header("Content-type","application/x-www-form-urlencoded")
	.body(data)
	.when()
	.get("/api/attendanceSheet")
	.then()
	.statusCode(200).extract().jsonPath().getString("meta.totals.T.duration");
	System.out.println(total);
	}
	
	@Test(priority=3,enabled=true)
	public void testPunchInOut() {
	given()
	.header("Authorization","Bearer "+token).and()
	.header("Cookie",cookie).and().header("Content-type","application/x-www-form-urlencoded")
	.when()
	.get("/api/attendance/config")
	.then().statusCode(200);
	}

	@Test(priority=4,enabled=true)
	public void testattendanceRecordsPunchIN() {
	String data="{\"empNumber\":\"13\",\"date\":\"2022-03-18\",\"time\":\"12:10\",\"timezoneOffset\":\"5.5\",\"forcePunchIn\":false}";
	LinkedHashMap response=given()
	.header("Authorization","Bearer "+token).and()
	.header("Cookie",cookie).and().header("Content-type","application/json")
	.body(data)
	.when()
	.post("/api/attendanceRecords")
	.then()
	.statusCode(201)
	.extract().jsonPath().get("data");
	System.out.println((String)response.get("id"));
	punchIntime=(String)response.get("punchInUserTime");
	System.out.println("Punch in time is "+punchIntime);
	punchinId=(String)response.get("id");
	}
	
	@Test(priority=5,enabled=true)
	public void testPunchInafterpunchIn() {
	String data="{\"empNumber\":\"13\",\"date\":\"2022-03-18\",\"time\":\"12:10\",\"timezoneOffset\":\"5.5\",\"forcePunchIn\":false}";
	given()
	.header("Authorization","Bearer "+token).and()
	.header("Cookie",cookie).and().header("Content-type","application/json")
	.body(data)
	.when()
	.post("/api/attendanceRecords")
	.then()
	.statusCode(403);
	}

	@Test(priority=6,enabled=true)
	public void testattendanceRecordsPunchOUT() {
	String data="{\"empNumber\":\"13\",\"date\":\"2022-03-18\",\"time\":\"16:18\",\"timezoneOffset\":\"5.5\"}";
	LinkedHashMap res=given().pathParam("punchinId", punchinId )
	.header("Authorization","Bearer "+token).and()
	.header("Cookie",cookie).and().header("Content-type","application/json")
	.body(data)
	.when()
	.patch("/api/attendanceRecord/{punchinId}")
	.then()
	.statusCode(200)
	.extract().jsonPath().get("data");
	punchOuttime=(String)res.get("punchOutUserTime");
	System.out.println("Punc out time is "+punchOuttime);
	}
	
	@Test(priority=7,enabled=true)
	public void testPunchOutafterPunchOut() {
	String data="{\"empNumber\":\"13\",\"date\":\"2022-03-18\",\"time\":\"16:18\",\"timezoneOffset\":\"5.5\"}";
	given().pathParam("punchinId", punchinId )
	.header("Authorization","Bearer "+token).and()
	.header("Cookie",cookie).and().header("Content-type","application/json")
	.body(data)
	.when()
	.patch("/api/attendanceRecord/{punchinId}")
	.then()
	.statusCode(403);
	}
	
	@Test(priority=8,enabled=true)
	public void testAttendancesheetIdGETafterPunchout() {
	String data="id=653";
	totaltimeafterpunchout=given()
	.header("Authorization","Bearer "+token).and()
	.header("Cookie",cookie)
	.header("Content-type","application/x-www-form-urlencoded")
	.body(data)
	.when()
	.get("/api/attendanceSheet")
	.then()
	.statusCode(200).extract().jsonPath().getString("meta.totals.T.duration");
	System.out.println(totaltimeafterpunchout);
	}
	
	@Test(priority=9,enabled=true)
	public void testconversionoftimetominutes() {
	int res1=TotalTime.converttominutes(punchIntime);
	int res2=TotalTime.converttominutes(punchOuttime);
	System.out.println("Res is "+res1);
	System.out.println("Res2 is "+res2);
	int res=TotalTime.converttominutes2(total);
	System.out.println("Res is "+res);
	timebeforpunchin=res+(res2-res1);
	System.out.println("Res3 is "+timebeforpunchin);
	timeafterpunchin=TotalTime.converttominutes2(totaltimeafterpunchout);
	System.out.println("Res4 is "+timeafterpunchin);
	}
	
	@Test(priority=10)
	public void testtimeduration() {
	assertEquals(timebeforpunchin,timeafterpunchin);
	}
	
	@Test(priority=11,enabled=true)
	public void testDelete() {
	String data="{\"ids\":["+punchinId+"]}";
	String res=given()
	.header("Authorization","Bearer "+token).and()
	.header("Cookie",cookie).and()
	.header("Content-type","application/json")
	.body(data)
	.when()
	.delete("/api/attendanceRecords")
	.then()
	.statusCode(200)
	.extract().jsonPath().getString("messages.success");
	System.out.println("message is "+res);
	assertEquals(res,"Successfully Deleted");
	}
	
	@Test(priority=12,enabled=true)
	public void testInvalidTimeFormat() {
	String data="{\"empNumber\":\"13\",\"mode\":\"checkPunchInOverlappingRecords\",\"punchInDate\":\"2022-03-08\",\"punchInTime\":\"18:7\",\"punchInTimezoneOffset\":\"5.5\"}";
	String title=given()
	.header("Authorization","Bearer "+token).and()
	.header("Cookie",cookie).and().
	header("Content-type","application/json")
	.body(data)
	.when()
	.post("/api/attendanceRecords")
	.then()
	.statusCode(400)
	.extract().jsonPath().getString("title");
	System.out.println("Title is"+title);
	assertEquals(title,"Invalid data");
	}
	
	@Test(priority=13,enabled=true)
	public void overlappingRecords() {
	String data="{\"empNumber\":\"13\",\"date\":\"2022-01-04\",\"time\":\"12:00\",\"timezoneOffset\":\"5.5\",\"forcePunchIn\":false}";
	String errormessage=given()
	.header("Authorization","Bearer "+token).and()
	.header("Cookie",cookie).and().header("Content-type","application/json")
	.body(data)
	.when().post("/api/attendanceRecords")
	.then()
	.statusCode(201)
	.extract().jsonPath().getString("messages.error");
	System.out.println("Error message is "+errormessage);
	assertEquals(errormessage,"Overlapping Records Found");
	}
}
