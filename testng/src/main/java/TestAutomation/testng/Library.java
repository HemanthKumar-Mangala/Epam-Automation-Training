package TestAutomation.testng;

import java.util.ArrayList;

public class Library {

	private Catalogue catalouge;
	private Admin admin;
	public ArrayList<Member> members;
	
	
	Library()
	{
		this.members=new ArrayList<Member>();
	}
	
	
	public int getMembersListSize()
	{
		return members.size();
	}
	
	
	
	void addnewMembers(Member member)
	{
	   this.members.add(member);
	}
	public Catalogue getCatalouge() {
		return catalouge;
	}
	public void setCatalouge(Catalogue catalouge) {
		this.catalouge = catalouge;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public ArrayList<Member> getMembers() {
		return members;
	}
	public void setMembers(ArrayList<Member> members) {
		this.members = members;
	}
	
	
	
}
