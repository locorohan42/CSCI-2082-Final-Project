package Doctor_Patient;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Prescription {
	
	private long rxNumber;
	private String name;
	private int dosage;
	private int amount;
	private Date dateFilled;
	private Date dateExpired;
	
	public Prescription(String name, int dosage, int amount) {
		this.rxNumber = genRxNumber();
		this.name = name;
		this.dosage = dosage;
		this.amount = amount;
		this.dateFilled = new Date();
		this.dateExpired = genDateExpired();
	}
	
	public long genRxNumber() {
		int max = 99999999;
		int min = 10000000;
		int random = (int) (Math.random() * (max - min)) + min;
		this.rxNumber = (long)random;
		return rxNumber;
	}
	
	public Date genDateExpired() {
		return dateExpired;
		//Stub
	}
	
	
	
	public long getRxNumber() {
		return rxNumber;
	}
	public String getName() {
		return name;
	}
	public int getDosage() {
		return dosage;
	}
	public int getAmount() {
		return amount;
	}
	
	public void setRxNumber(int rxNumber) {
		this.rxNumber = rxNumber;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDosage(int dosage) {
		this.dosage = dosage;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String date1 = sdf.format(dateFilled);
		
		String prescriptionInfo = "Rx Number: " + rxNumber + "\nName: " + name + "\nDosage: " + dosage
		+ " mg" + "\nAmount: " + amount + " pills" + "\nDate Filled: " + date1 + "\nDate Expired: "
		 + dateExpired;
		return prescriptionInfo;
	}
	
	

}
