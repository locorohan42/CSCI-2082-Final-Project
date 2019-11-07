package collection.classes;

import regular.classes.Photo;

public class PhotoNode {
	// Instance Variables
	private Photo data;
	private PhotoNode link;

	// Constructor
	public PhotoNode(Photo initialData, PhotoNode initialLink) {
		data = initialData;
		link = initialLink;
	}

	// Setters and Getters
	public Photo getData() {
		return data;
	}

	public PhotoNode getLink() {
		return link;
	}

	public void setData(Photo newData) {
		data = newData;
	}

	public void setLink(PhotoNode newLink) {
		link = newLink;
	}

	/*
	 * Description: Method adds a new node after the current node
	 * Params:Takes in an element that will be the new node
	 * Preconditon: Must take in a course
	 * Postcondition: New node has been put after the current node
	 * Throws list:  Doesn't throw anything
	 */
	public void addNodeAfter(Photo element) {
		link = new PhotoNode(element, link);
	}

	/*
	 * Description: Copies a list and returns the head and tail references
	 * Params:Takes a Course Node that is going to be the head of the list to be copied
	 * Preconditon: Method must be working with a Course Node
	 * Postcondition: Method returns an array containg the head and tail
	 * Throws list:  Doesn't throw anything
	 */
	public static PhotoNode[] listCopyWithTail(PhotoNode source) {
		PhotoNode copyHead;
		PhotoNode copyTail;
		PhotoNode[] answer = new PhotoNode[2];

		if (source == null) {
			return answer;
		}

		copyHead = new PhotoNode(source.data, null);
		copyTail = copyHead;

		while (source.link != null) {
			
			source = source.link;
			copyTail.addNodeAfter(source.data);
			copyTail = copyTail.link;
			
		}

		answer[0] = copyHead;
		answer[1] = copyTail;
		return answer;
	}

	/*
	 * Description: Copies a list
	 * Params:Takes in the head reference of a list
	 * Preconditon:  Method must be working with a CourseNode
	 * Postcondition: Method returns a copied list
	 * Throws list:  Doesn't throw anything
	 */
	public static PhotoNode listCopy(PhotoNode source) {
		PhotoNode copyHead;
		PhotoNode copyTail;

		if (source == null) {
			return null;
		}

		copyHead = new PhotoNode(source.data, null);
		copyTail = copyHead;

		while (source.link != null) {
			
			source = source.link;
			copyTail.addNodeAfter(source.data);
			copyTail = copyTail.link;
			
		}
		return copyHead;
	}

	/*
	 * Description: Method searches for an element in a list
	 * Params:Takes in the head of a list and a desired data in the list
	 * Preconditon: The list can be empty, but it must be a coursenode
	 * Postcondition: Returns a reference to the node that was searched for if found or null 
	 * Throws list:  Doesn't throw anything
	 */
	public static PhotoNode listSearch(PhotoNode head, Photo target) {
		PhotoNode cursor;

		for (cursor = head; cursor != null; cursor = cursor.link) {
			
			if (target == cursor.data) {
				
				return cursor;
				
			}
		}
		return null;
	}
	
	/*
	 * Description: Similar to above, helper method for method that finds a course for the admin
	 * Params:Takes in the head of a list and a desired data in the list
	 * Preconditon: Must be searching for a string
	 * Postcondition: Returns a reference to the string that was searched for if found or null 
	 * Throws list:  Doesn't throw anything
	 */
	public static PhotoNode listSearch(PhotoNode head, String target) {
		PhotoNode cursor;

		for (cursor = head; cursor != null; cursor = cursor.link) {
			
//			Maybe add another thing to search for. Maybe title of photo?
			if (target == cursor.data.getImagePath()) {
				
				return cursor;
				
			}
		}
		return null;
	}
}
