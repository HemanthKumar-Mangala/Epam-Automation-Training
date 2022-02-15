package TestAutomation.testng;

import static org.testng.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;

import org.testng.annotations.*;






public class TestLibrary {
	Library lib;
	
	@BeforeMethod
	public void initializeMembers() {
		lib = new Library();
		lib.setCatalouge(new Catalogue());
		lib.setAdmin(new Admin(lib));

		

		System.out.println("Initializing Members!!!!!");

		lib.addnewMembers(new Member(1, "Hemanth", "Kumar", "Hyderabad", 21));
		lib.addnewMembers(new Member(2, "Suresh", "Raina", "Gaziabad", 35));
		lib.addnewMembers(new Member(3, "Gracia", "Raina", "Gaziabad", 5));
		lib.addnewMembers(new Member(4, "Abdul", "Kalam", "Kanyakumari", 91));

		//lib.setCatalouge(new Catalogue());

		System.out.println("Initializing Library!!!!");

		lib.getCatalouge().addBook(new Book(1, "Harry Potter", "JK Rowling"));
		lib.getCatalouge().addBook(new Book(7, "wings of Fire", "APJ Kalam"));
		lib.getCatalouge().addBook(new Book(9, "Psycology of Money", "Morgan"));
		lib.getCatalouge().addBook(new Book(4, "My Experiment with Truth", "Mahatma Gandhi"));
		lib.getCatalouge().addBook(new Book(5, "You can win", "Shiv Khera"));

	}
	
	
	@Test
	public void testaddMembers() {
		int initialSize = lib.getMembers().size();
		lib.addnewMembers(new Member(5, "Kalyan", "Kumar", "Hyderabad", 13));

		assertEquals(lib.getMembers().size(), initialSize + 1);
	}

	@DataProvider(name = "MembersDetails")
	public Object[][] membernames() {
		BufferedReader br = null;
		BufferedReader br1 = null;
		String str = null;
		String header[] = null;
		int row = 0;
		try {
			br1 = new BufferedReader(new FileReader("src/test/resources/Test.csv"));
			while ((str = br1.readLine()) != null) {
				row++;
			}
		} catch (Exception e) {

		}

		int count = 0;
		Object[][] arr = new Object[row - 1][5];
		int index = 0;
		try {
			br = new BufferedReader(new FileReader("src/test/resources/Test.csv"));
			while ((str = br.readLine()) != null) {
				if (count == 0) {
					header = str.split(",");
				} else {

					Object a[] = str.split(",");
					arr[index] = a;
					index++;
				}
				count++;
			}
		} catch (Exception e) {

		}
		return arr;
	}

//	
	@Test(dataProvider = "MembersDetails")
	public void testLibraryaddmember(String id, String fname, String lname, String city, String age) 
	{
		int id1 = Integer.parseInt(id);
		int age1 = Integer.parseInt(age);

		System.out.println("Calling test add Member for : " + fname);
		int initialSize = lib.getMembersListSize();
		lib.addnewMembers(new Member(id1, fname, lname, city, age1));
		assertEquals(lib.getMembersListSize(), initialSize + 1);

	}

	
	@Test
	public void testIssueBook() {
		//mem = new Members();
		int initialsize = 0;
		int afterissue = 0;
		for (Iterator iterator = lib.members.iterator(); iterator.hasNext();) {
			Member members = (Member) iterator.next();
			if (members.getId() == 3) {
				initialsize = members.getMembersIssuedBookSize();
			}

		}
		lib.getAdmin().issueBookToMembers(3,7);
		for (Iterator iterator = lib.members.iterator(); iterator.hasNext();) {
			Member members = (Member) iterator.next();
			if (members.getId() == 3) {
				afterissue = members.getMembersIssuedBookSize();
			}

		}
		
		assertEquals(afterissue, initialsize + 1);

	}
	
	@Test
	public void testDeactivateuser()
	{
		String s=null;
		lib.getAdmin().deactivateUser(3);
		for (Iterator iterator = lib.members.iterator(); iterator.hasNext();) {
			Member members = (Member) iterator.next();
			if (members.getId() == 3) {
				s=members.getStatus();
				break;
			}
		}
		
		assertEquals(s,"Inactive");
	}
	
	@Test
	public void testActivateuser()
	{
		String s=null;
		lib.getAdmin().activateUser(3);
		for (Iterator iterator = lib.members.iterator(); iterator.hasNext();) {
			Member members = (Member) iterator.next();
			if (members.getId() == 3) {
				s=members.getStatus();
				break;
			}
		}
		
		assertEquals("Active",s);
	}
}
