package regular.classes;

import java.util.Date;

public class Video {
	private int videoNumber;
	private Date datePosted;
	private String videoPath;
	private int videoIncrement;
	
	public Video(int videoNumber, String videoPath) {
		this.videoNumber = 1 + videoIncrement;
		this.videoPath = videoPath;
		this.datePosted = getDatePosted();
		videoIncrement++;
	}

	public int getVideoNumber() {
		return videoNumber;
	}

	public void setVideoNumber(int videoNumber) {
		this.videoNumber = videoNumber;
	}

	public Date getDatePosted() {
		Date datePosted = new Date();
		return datePosted;
	}

	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public int getVideoIncrement() {
		return videoIncrement;
	}

	public void setVideoIncrement(int videoIncrement) {
		this.videoIncrement = videoIncrement;
	}
	
	public String toString() {
		String info = "[Video Number]: " + getVideoNumber() + "[Date Posted]: " 
	+ (getDatePosted().getMonth()+1) +"/"+ getDatePosted().getDate()+"/" +getDatePosted().getYear();
		return info;
	}
}
