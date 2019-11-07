package collection.classes;

import regular.classes.Photo;

public class Photos implements Cloneable {
	// Instance variables
	private PhotoNode head;
	private int manyNodes;

	// Constructor
	public Photos() {
		head = null;
		manyNodes = 0;
	}

	/*
	 * Description: Search for a Course in the collection
	 * Params: Parameter is a String that refers to a Course subject or Id that is being looked for
	 * Preconditon: Parameter must be a String not a Course
	 * Postcondition: Will let admin know if target found 
	 * Throws list:  Doesn't throw anything
	 */
	public void searchForCourse(String target) {
		PhotoNode cursor;
		
		cursor = PhotoNode.listSearch(head, target);
		while (cursor != null) {
			//Add extra target maybe?
			if (target == cursor.getData().getImagePath()) {
				
				System.out.println(cursor.getData().getImagePath() + " is in the system");	
				
			} 
			cursor = cursor.getLink();
			cursor = PhotoNode.listSearch(cursor, target);
			
		}
		
		
	}

	/*
	 * Description: Adds a new Course
	 * Params: Takes a Course
	 * Preconditon: Parameter must be a Course
	 * Postcondition: New course will be added to the collection 
	 * Throws list:  Doesn't throw anything
	 */
	public void add(Photo element) {
		head = new PhotoNode(element, head);
		manyNodes++;
	}

	/*
	 * Description: Adds a collection of Courses to the prexisting collection
	 * Params: Takes a CourseCollection linked list of Course
	 * Preconditon: Must be a CourseCollection
	 * Postcondition: An entire collection will be appended to the exitisting one 
	 * Throws list:  Throws Excepiton if the CourseCollection being added is null
	 */
	public void addAll(Photos addend) {
		PhotoNode[] copyInfo;

		if (addend == null) {
			
			throw new IllegalArgumentException("addend is null.");
			
		}
			
		if (addend.manyNodes > 0) {
			
			copyInfo = PhotoNode.listCopyWithTail(addend.head);
			copyInfo[1].setLink(head);
			head = copyInfo[0];
			manyNodes += addend.manyNodes;
			
		}
	}

	/*
	 * Description: Can add many Courses at once to the collection
	 * Params: Takes Course objects
	 * Preconditon: Must be Course objects being added
	 * Postcondition: Many courses will be added at once 
	 * Throws list: Doesn't throw anything
	 */
	public void addMany(Photo... elements) {
		for (Photo i : elements) {
			add(i);
		}
	}

	/*
	 * Description: Clones the Course collection
	 * Params: Doesn't take in anything
	 * Preconditon: What's being copied must be a CourseCollection
	 * Postcondition: Returns a cloned CourseCollection
	 * Throws list: Throws error if class doesn't implement cloneable
	 */
	public Photos clone() {
		Photos answer;
		try {
			answer = (Photos) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("This class does not implement Cloneable");
		}
		answer.head = PhotoNode.listCopy(head);

		return answer;
	}

	/*
	 * Description: Count the amount of times a Course is found in the collection
	 * Params: Takes in a Course
	 * Preconditon: Parameter must be a Course
	 * Postcondition: Returns an int value that represents how many times the target was hit
	 * Throws list: Doesn't throw anything
	 */
	public int countOccurences(Photo target) {
		int answer;
		PhotoNode cursor;

		answer = 0;
		cursor = PhotoNode.listSearch(head, target);
		while (cursor != null) {
			answer++;
			cursor = cursor.getLink();
			cursor = PhotoNode.listSearch(cursor, target);
		}
		return answer;
	}

	/*
	 * Description: Removes a Course from the collection
	 * Params: Takes in a Course
	 * Preconditon: Parameter must be a Course
	 * Postcondition: Returns true if removed, false if not removed
	 * Throws list: Doesn't throw anything
	 */
	public boolean remove(Photo target) {
		PhotoNode targetNode;

		targetNode = PhotoNode.listSearch(head, target);
		if (targetNode == null) {
			return false;
		} else {
			targetNode.setData(head.getData());
			head = head.getLink();
			manyNodes--;
			return true;
		}
	}

	/*
	 * Description: Calculates the size of the collection
	 * Params: Takes nothing
	 * Preconditon: Can always be called
	 * Postcondition: Returns the length of the array
	 * Throws list: Doesn't throw anything
	 */
	public int size() {
		return manyNodes;
	}

	/*
	 * Description: Joins two collections of courses
	 * Params: Takes in two Course collections
	 * Preconditon: Lists must be of Courses
	 * Postcondition: Returns the new list that combines the previous two
	 * Throws list: DThrows exception if one or both of the parameters are null
	 */
	public static Photos union(Photos c1, Photos c2) {
		if (c1 == null) {
			throw new IllegalArgumentException("c1 is null.");
		}
		if (c2 == null) {
			throw new IllegalArgumentException("c2 is null.");
		}

		Photos answer = new Photos();

		answer.addAll(c1);
		answer.addAll(c2);
		return answer;
	}

	// toString method
	public String toString() {

		String listInfo = "{";

		PhotoNode cursor = head;
		while (cursor != null) {
			if (cursor.getLink() != null)
				listInfo += cursor.getData() + " \n ";
			else
				listInfo += cursor.getData();
			cursor = cursor.getLink();

		}
		listInfo += " }";
		return listInfo;
	}

}
