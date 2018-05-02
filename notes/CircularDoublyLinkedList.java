import java.util.NoSuchElementException;

public class CircularDoublyLinkedList {
	private class Node {
		private Object data;
		private Node next, prev;
		private Node(Object d, Node p, Node n) {
			this.data = d;
			this.prev = p;
			this.next = n;
		}
	}
	private Node head;
	private int size;
	public CircularDoublyLinkedList() {
		this.head = new Node(null, null, null);
		this.head.next = this.head;
		this.head.prev = this.head;
		this.size = 0;
	}

	public void addFirst(Object data) {
		Node nn = new Node(data, this.head, this.head.next);
		this.head.next.prev = nn;
		this.head.next = nn;
		this.size++;
	}

	public void addLast(Object data) {
		Node nn = new Node(data, this.head.prev, this.head);
		this.head.prev.next = nn;
		this.head.prev = nn;
		this.size++;
	}

	//Unfinished
	public Object removeFirst() {
		if (this.size == 0) {
			throw new NoSuchElementException("List is empty");
		}
		Object data;
		Node cur = this.head.next;
		data = cur.data;
		this.head.next = cur.next;
		cur.next.prev = this.head;
		this.size--;
		return data;
	}

	public Object removeLast() {
		if (this.size == 0) {
			throw new NoSuchElementException("List is empty");
		}
		Object data;
		Node cur = this.head.prev;
		data = cur.data;
		cur.prev.next = this.head;
		this.head.prev = cur.prev;
		this.size--;
		return data;
	}

	public void clear() {
		this.head = new Node(null, null, null);
		this.head.next = this.head;
		this.head.prev = this.head;
		this.size = 0;
	}

	public void add(Object data, int index) {
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException("List length is: " + this.size);
		}	
		Node cur = this.head;
		for (int ix = 0; ix < index; ix++) {
			cur = cur.next;
		}
		Node nn = new Node(data, cur, cur.next);
		cur.next.prev = nn;
		cur.next = nn;
		this.size++;
	}

	public String toString() {
		String temp = "CDLL: ";
		Node walk = this.head.next;
		while(walk != this.head){
			temp += walk.data + ", ";
			walk = walk.next;
		}
		return temp;
	}
		//for (int ix = 0; ix < this.size; ix++) {



	public static void main(String[] args) {
		CircularDoublyLinkedList ls = new CircularDoublyLinkedList();
		ls.addFirst("A");
		ls.addFirst("B");
		ls.addFirst("C");
		System.out.println(ls);
		ls.addLast("A");
		ls.addLast("B");
		ls.addLast("C");
		ls.add("Woow", 3);
		System.out.println(ls);
		for (int ix = 0; ix < 3; ix++) {
			System.out.println("removeFirst: " + ls.removeFirst());
		}
		System.out.println(ls);
		for (int ix = 0; ix < 3; ix++) {
			System.out.println("removeLast: " + ls.removeLast());
		}
		System.out.println(ls);
	}
}
				
