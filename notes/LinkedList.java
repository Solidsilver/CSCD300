//
public class LinkedList {
	Node head;
	int size;
	private class Node {
		Object data;
		Node next;
		private Node(Object d, Node n) {
			this.data = d;
			this.next = n;
		}
	}

	public LinkedList() {
		this.head = new Node(null, null);//Dummy Head Node
		this.size = 0;
	}
	
	public boolean remove(Object o)  { // delete the first occurance of o
		for (Node prev = this.head, cur = this.head.next; cur != null; prev = cur, cur = cur.next) {
			if (cur.data.equals(o)) {
				prev.next = cur.next;
				this.size--;
				return true;
			}	
		}
		return false;
	}

	public void addOrdered(Object dataToAdd) {
		// Pre-condidtion before  you call addOrdered
		//is: the current list has been sorted/ordered
		//in ascending order
		// After insertion of data, the list is still ordered
		Node prev, cur;
	for (prev = this.head, cur = this.head.next; cur != null && ((Comparable)cur.data).compareTo(dataToAdd) < 0 ; prev = cur, cur = cur.next) {
		}//Empty loop body
		prev.next = new Node(dataToAdd, cur);
		this.size++;
	}
	
	public void sort() {
		Node cur;
		LinkedList newList = new LinkedList();
		for (cur = this.head.next; cur != null; cur = cur.next) {
			newList.addOrdered(cur.data);
		}	
		this.head.next = newList.head.next;
	}

	public void selectionSort() {
		// Go through (size-1) passes
		// in each pass, we will find the smallest
		// object in the range from start loc. o
		// Then swap/switch the elements if there is one smaller
		if (this.size <= 1) return;
		Node cur, start = this.head.next, small;
		Comparable temp;
		for (start = this.head.next; start.next != null; start = start.next) {
			small = start;
			for (cur = start; cur != null; cur = cur.next) {
				if (((Comparable)cur.data).compareTo(small.data) < 0) {
					small = cur;
				}
			}
			temp = (Comparable)start.data;
			start.data = small.data;
			small.data = temp;
			// swap
		}
		
	}



	public void addFirst(Object comp) {
		Node cur = this.head.next;
		this.head.next = new Node(comp, cur);
	}
	
	@Override
	public String toString() {
		String temp = "List: ";
		for (Node cur = this.head.next; cur != null; cur = cur.next) {
			temp += cur.data + ", ";
		}

		return temp;
	}

	public static void main(String[] args) {
		LinkedList wow = new LinkedList();
		wow.addFirst("Hello world");
		wow.addFirst("Bazinga");
		wow.addFirst("Norwall");
		wow.addFirst("Diggity Dawg");

		System.out.println(wow);
		wow.sort();
		System.out.println(wow);
	}
}
