//This class and it's included methods were created by Luke Mattfeld
//for CSCD300 at EWU
public class CDoublyLinkedList {

	private class Node {
		private Object data;   //Assume data implemented Comparable
		private Node next, prev;
		private Node(Object data, Node pref, Node next)
		{
			this.data = data;
			this.prev = pref;
			this.next = next;
		}
	}

	private Node head;
	private int size;

	public CDoublyLinkedList() {
		this.head = new Node(null, null, null );
		this.head.next = this.head;
		this.head.prev=this.head;
		this.size = 0;
	}

	public boolean isEmpty() {
		return this.head == this.head.next;
	} 
	
	// Add Object data to start of this LinkedList
	// Please DO NOT change this addFirst() method.
	// You must keep and include this provided addFirst() method
	//      in your source code.
	public void addFirst(Object data) {
		Node nn = new Node(data, this.head, this.head.next);
		this.head.next.prev = nn;
		this.head.next = nn;
		this.size ++;
	}

	// write a method void addLast(Object data) that will insert 
	// the piece of data at the end of the current list.
	// Note: this list is allowed to store null data element in its list node.
	public void addLast(Object data) {
		Node nn = new Node(data, this.head.prev, this.head);
		this.head.prev.next = nn;
		this.head.prev = nn;
		this.size++;
	}


	// Write the subListOfSmallerValues method.  
	// It should return a CDoublyLinkedList object 
	//     containing data that is smaller than the value passed to the method.
        // If a null data element in this list is encountered, you can skip it.
	public CDoublyLinkedList subListOfSmallerValues(Comparable data) {
		CDoublyLinkedList small = new CDoublyLinkedList();
		if (data == null) {
			return small;
		} else {
			Node cur = this.head.next;
			while (cur != this.head) {
				if (cur != null && ((Comparable)cur.data).compareTo(data) < 0) {
					small.addLast(cur.data);
				}
				cur = cur.next;
			}
		}
		return small;
	}
	
	// This method should remove the first occurrence of the data from the list, 
        //      starting at the *BACK* of the list. 
        // It scans the list from back to the front by following the prev links. 
	// The method should return true if successful, false otherwise. 
	// Note that list node may contain null data element. Please handle this edge case.
	public boolean removeStartingAtBack(Object dataToRemove) {
		Node cur = this.head.prev;
		boolean toRem = false;
		while (cur != this.head) {
			if (cur.data == null || dataToRemove == null) {
				if (cur.data == null && dataToRemove == null) {
					toRem = true;
				}
			} else if (cur.data.equals(dataToRemove)) {
				toRem = true;
			}
			if (toRem) {
				cur.prev.next = cur.next;
				cur.next.prev = cur.prev;
				this.size--;
				return true;
			}
			cur = cur.prev;
		}
	
		return false;//change this as needed.
	}
	
	// Returns the index of the last occurrence of the specified element in this list, 
	//     or -1 if this list does not contain the element. 
	// More formally, returns the highest index i 
	//     such that (o==null ? get(i)==null : o.equals(get(i))), 
	//     or -1 if there is no such index.
	// Note: a list node may store a null data element. Please handle this edge case.
	public int lastIndexOf(Object o) {
		Node cur = this.head.prev;
		int index = this.size - 1;
		while (cur != this.head) {
			if (cur.data == null && o == null) {
				return index;
			} else if (cur.data != null && o != null && cur.data.equals(o)) {
				return index;
			}
			cur = cur.prev;
			index--;
		}
		return -1; //change this as needed.
	}
	// Removes from this list all of its elements that 
	//    are NOT contained in the specified linkedlist other.
	// If any element has been removed from this list,
	//    returns true. Otherwise returns false.
	// If other list is null, throws NullPointerException.
        // Helper methods are allowed.
	public boolean retainAll(CDoublyLinkedList other) throws NullPointerException {
		if (other == null) {
			throw new NullPointerException("Input list is null");
		}
		boolean del = false;
		Node cur = this.head.next;
		while(cur != this.head) {
			if (!other.contains(cur.data)) {
				cur.prev.next = cur.next;
				cur.next.prev = cur.prev;
				if (del == false) {
					del = true;
				}
			}
			cur = cur.next;
		}
		return del;
	}

	//Helper method for retainAll
	private boolean contains(Object data) {
		Node cur = this.head.next;
		while(cur != this.head) {
			if(cur.data == null && data == null) {
				return true;
			} else if (cur.data != null && data != null && cur.data.equals(data)) {
				return true;
			}
			cur = cur.next;
		}	
		return false;
	}
	

        // Write this method to sort this list using insertion sort algorithm, 
        //      as we have learned in the classroom.
	public void insertionSort() {
		Node curBack = this.head.next, fUnsort = curBack.next, nn;
		while (fUnsort != this.head) {
			while (curBack != this.head && ((Comparable)curBack.data).compareTo(fUnsort.data) > 0) {
				curBack = curBack.prev;
			}
			if (curBack != fUnsort.prev) {
				nn = new Node(fUnsort.data, curBack, curBack.next);
				curBack.next.prev = nn;
				curBack.next = nn;
				fUnsort.prev.next = fUnsort.next;
				fUnsort.next.prev = fUnsort.prev;
			}
			fUnsort = fUnsort.next; curBack = fUnsort.prev;
		}
	}
	
	@Override
	public String toString() {
		String result = "{";
		for (Node node = this.head.next; node != this.head; node = node.next) {
			if(node.next != this.head) 
				result += node.data + "->"; 
			else
				result += node.data;
		}
		return result + "}";
	}
}
