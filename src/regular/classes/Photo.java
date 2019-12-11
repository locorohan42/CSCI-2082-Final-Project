package regular.classes;
import java.util.Date;

public class Photo {
	private int photoNumber;
	private Date datePosted;
	private String imagePath;
	private int photoIncrement;
	
	public Photo(int photoNumber, String imagePath) {
		this.photoNumber = 1 + photoIncrement;
		this.imagePath = imagePath;
		this.datePosted = getDatePosted();
		photoIncrement++;
	}
	
	public Photo(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getPhotoNumber() {
		return photoNumber;
	}

	public void setPhotoNumber(int photoNumber) {
		this.photoNumber = photoNumber;
	}

	public Date getDatePosted() {
		Date datePosted = new Date();
		return datePosted;
	}

	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getPhotoIncrement() {
		return photoIncrement;
	}

	public void setPhotoIncrement(int photoIncrement) {
		this.photoIncrement = photoIncrement;
	}
	
	public String toString() {
		String info = "[Photo Number]: " + getPhotoNumber() + "[Date Posted]: " 
	+ (getDatePosted().getMonth()+1) +"/"+ getDatePosted().getDate()+"/" +getDatePosted().getYear();
		return info;
	}

}
