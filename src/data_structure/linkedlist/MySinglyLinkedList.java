package data_structure.linkedlist;

public class MySinglyLinkedList {
	
	private Node head;
	private Node tail;
	int length;
	
	
	public MySinglyLinkedList(int value) {
		Node node = new Node(value);
		head = node;
		tail = node;
		length = 1;
	}
	
	public void append(int value) {
		Node node = new Node(value);
		tail.setNext(node);
		tail = node;
		length++;
	}
	
	public void prepend(int value) {
		Node node = new Node(value);
		node.setNext(head);
		head = node;
		length++;
	}
	
	public void insert(int index, int value) {
		if (index == 0) {
			prepend(value);
			return;
		}
		if (index == length) {
			append(value);
			return;
		}
		
		Node pre = head;
		for (int i = 0; i < index-1; i++) {
			pre = pre.getNext();
		}
		Node node = new Node(value);
		node.setNext(pre.getNext());
		pre.setNext(node);
		if (node.getNext() == null) {
			tail = node;
		}
		length++;
	}
	
	public void printAll() {
		Node pre = head;
		while (pre != null) {
			System.out.print(pre.getValue() + ",");
			pre = pre.getNext();
		}
		if (null != head) {
			System.out.println("Head-" + head.getValue());
		}
		if (null != tail) {
			System.out.println("Tail-" + tail.getValue());
		}
		System.out.println("length-" + length);
		System.out.println("-------------------");
	}
	
	public void remove(int index) {
		Node pre = head;
		if (index == 0) {
			pre = head.getNext();
			if (pre == null) {
				head = null;
				length--;
				return;
			} else {
				head.setNext(null);
				head = pre;
				length--;
				return;
			}
		}
		for (int i = 0; i < index-1; i++) {
			pre = pre.getNext();
		}
		
		if (index == length - 1) {
			pre.setNext(null);
			tail = pre;
			length--;
			return;
		}
		Node nextNode = pre.getNext().getNext();
		pre.getNext().setNext(null);
		pre.setNext(nextNode);
		
		length--;
	}
	
	public MySinglyLinkedList reverse(MySinglyLinkedList mySinglyLinkedList) {
		
		MySinglyLinkedList newList = new MySinglyLinkedList(mySinglyLinkedList.head.getValue());
		Node currentNode = mySinglyLinkedList.head;
		newList.tail = currentNode;
		Node nextNode = mySinglyLinkedList.head;
		while (nextNode.getNext() != null) {
			Node newValue = new Node(nextNode.getNext().getValue());
			newValue.setNext(newList.head);
			newList.head = newValue;
			newList.length = newList.length + 1;
			nextNode = nextNode.getNext();
		}
		return newList;
	}
	
	public static void main(String[] args) {
		MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList(1);
		mySinglyLinkedList.printAll();
		
		mySinglyLinkedList.insert(0, 11);
		mySinglyLinkedList.printAll();
		mySinglyLinkedList.insert(1, 22);
		mySinglyLinkedList.printAll();
		mySinglyLinkedList.insert(2, 44);
		mySinglyLinkedList.printAll();
		mySinglyLinkedList.insert(4, 55);
		
		mySinglyLinkedList.printAll();
		mySinglyLinkedList.append(3);
		mySinglyLinkedList.printAll();
		mySinglyLinkedList.prepend(5);
		mySinglyLinkedList.printAll();
		
		mySinglyLinkedList.remove(0);		
		mySinglyLinkedList.printAll();
		
		mySinglyLinkedList.remove(5);
		mySinglyLinkedList.printAll();
		
		mySinglyLinkedList.prepend(5);
		mySinglyLinkedList.printAll();
		mySinglyLinkedList.insert(0, 4);
		mySinglyLinkedList.printAll();
		
		mySinglyLinkedList.reverse(mySinglyLinkedList).printAll();
	}

}
