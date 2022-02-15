package TestAutomation.restassured;

public class Users {
	int id;
	String name;
	String email;
	String profilepicture;
	String location;
	String createdat;
	
	Users(int id,String name,String email,String profilepicture,String location ,String createdat)
	{
		this.id=id;
		this.name=name;
		this.email=email;
		this.profilepicture=profilepicture;
		this.location=location;
		this.createdat=createdat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfilepicture() {
		return profilepicture;
	}

	public void setProfilepicture(String profilepicture) {
		this.profilepicture = profilepicture;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCreatedat() {
		return createdat;
	}

	public void setCreatedat(String createdat) {
		this.createdat = createdat;
	}

	 
				
}
