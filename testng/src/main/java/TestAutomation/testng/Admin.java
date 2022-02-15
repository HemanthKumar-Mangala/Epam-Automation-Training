package TestAutomation.testng;

import java.util.Iterator;

public class Admin {

	public Member member;
	public Library lib;
	public Catalogue c;
	
	
	public Admin(Library lib) {
		this.lib=lib;
		
	}


	void deactivateUser(int id) {
		int flag=0;
		for (Iterator iterator = lib.members.iterator(); iterator.hasNext();) {
			Member member = (Member) iterator.next();
			if (member.getId() == id) {
				flag=1;
				member.deactivate();
				
				System.out.println("User deactivated succesfully");
				
			}
		}
		if(flag==0)
		{
			System.out.println("User is not found");
		}
	}

	void activateUser(int id) {
		int flag=0;
		for (Iterator iterator = lib.members.iterator(); iterator.hasNext();) {
			Member member = (Member) iterator.next();
			if (member.getId() == id) {
				flag=1;
				member.activate();
				System.out.println("User activated succesfully");
			}
		}
		if(flag==0)
		{
			System.out.println("User is not found");
		}

	}

	void issueBookToMembers(int memberid, int bookid) {
		int flag1 = 0;
		int flag2 = 0;
		int flag3=0;
		for (Iterator iterator = lib.members.iterator(); iterator.hasNext();) {
			Member member = (Member) iterator.next();
			if (member.getId() == memberid) {
				flag1 = 1;
			if (member.getStatus().equals("Active")) {
					flag3 = 1;
					
					for (Iterator iterator1 = lib.getCatalouge().books.iterator(); iterator1.hasNext();) {
						Book book = (Book) iterator1.next();

						if (book.getId() == bookid) {
							flag2 = 1;
							member.issuedbooks.add(book);
							break;

						}
					}

				} 
			else {
					System.out.println("User is Inactive , we cant issue book to this user");

				}
			}
		}
		if (flag1 == 0) {
			System.out.println("Invalid Member Id ");
		} else if (flag1 == 1 && flag2 == 0 && flag3 == 1) {
			System.out.println("Invalid Book Id ");
		} else if (flag1 == 1 && flag2 == 1) {
			System.out.println("Book issued scuessfully");
		}
	}
}
