package regular.classes;

import java.util.Date;

public class Driver {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.getMonth()+1);
		System.out.println(date.getDate());
		System.out.println(date.getYear()-100);
		
		User user = new User("Roho", "Mat", "Locoroho");
		System.out.println(user);
				
	}

}
