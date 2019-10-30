package Doctor_Patient;

public class Doctor {
	
	private String name;
	private int yearsExperience;
	private int age;
	private String department;
	private String phoneNumber;
	
	public Doctor(String name, int yearsExperience, int age, String department, String phoneNumber) {
		this.name = name;
		this.yearsExperience = yearsExperience;
		this.age = age;
		this.department = department;
		this.phoneNumber = phoneNumber;
	}
	
	public String getName() {
		return this.name;
	}
	public int getYearsExperience() {
		return this.yearsExperience;
	}
	public int getAge() {
		return this.age;
	}
	public String getDepartment() {
		return this.department;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setYearsExperience(int yearsExperience) {
		this.yearsExperience = yearsExperience;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String toString() {
		String DoctorInfo = "Name: " + name + "\nYears of Experience: " + yearsExperience + "\nAge: " + age
		+ "\nDepartment: " + department + "\nPhone Number: " + phoneNumber;	
		return DoctorInfo;
		
	}

}
