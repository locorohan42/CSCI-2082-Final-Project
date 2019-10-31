package regular.classes;
import java.util.Date;

public class User {
	private String id;
	private String password;
	private String email;
	private Date creationDate;
	
	public User(String id, String password, String email) {
		this.id = id;
		this.password = password;
		this.email = email;
		this.creationDate = getCreationDate();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreationDate() {
		Date creationDate = new Date();
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public String toString() {
		String info = "[User Id] " + getId() + " [User Password] " + getPassword() + " [User email] " + getEmail()
		+ " [User since] " + (getCreationDate().getMonth()+1) +"/"+ getCreationDate().getDate()+"/" +getCreationDate().getYear() ; 
		return info;
	}
	
}
