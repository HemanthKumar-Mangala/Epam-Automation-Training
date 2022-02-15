package TestAutomation.testng;
import java.lang.*;
import java.util.*;
public class Member {

	private int id;
	private String first_name;
	private String last_name;
	private String city;
	private int  age;
	public String  status="Active";
	public ArrayList<Book>issuedbooks;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void activate()
	{
		this.status="Active";
	}
	
	public void deactivate()
	{
		this.status="Inactive";
	}

	
	Member(int id, String first_name, String last_name,String city , int  age)
	{
		this.id=id;
		this.first_name=first_name;
		this.last_name=last_name;
		this.city= city;
		this.age=age;
		this.issuedbooks=new ArrayList<Book>();
		
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getlast_name() {
		return last_name;
	}
	public void setlast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMembersIssuedBookSize()
	{
		return issuedbooks.size();
	}
}
