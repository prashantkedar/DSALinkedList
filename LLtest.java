package javaFile;

import java.util.StringJoiner;

public class LLtest {

	public static void main(String[] args) {
		LinkedList<Integer> x = new LinkedList<>();
		x.add(10);
		x.add(20);
		x.add(50);
		x.add(30);
		x.add(40);
		System.out.println("Given Linked List Set: " + x); // 10,20,50,30,40
		int m = x.max();
		System.out.println("Maximum number in list: " + m); // 50
		x.delete(50);
		System.out.println("Delete 50 number: " + x); // 10,20,30,40
		x.delete(10);
		System.out.println("Delete 10 number: " + x); // 20,30,40
		x.addBeg(15);
		System.out.println("Add begining link list: " + x); // 15,20,30,40
		x.addBeg1(5);
		System.out.println("Add begining link list: " + x); // 5,15,20,30,40
		int n = x.count();
		System.out.println("No. of Nodes: " + n); // 5
		x.insertAt(25, 4);
		System.out.println("Insert new Node: " + x); // 2,15,20,25,30,40
		x.insertAt(2, 1);
		System.out.println("Insert New Node: " + x); // 2,5,15,20,25,30,40
		x.deleteAt(3);
		System.out.println("Delete node 3: " + x); // 2,5,20,25,30,40
		x.deleteAt(1);
		System.out.println("Delete node 1: " + x); // 5,20,25,30,40
		x.insertOrder(27);
		System.out.println("InsertOrder : " + x); // 5,20,25,27,30,40
		x.insertOrder(35);
		System.out.println("InsertOrder : " + x); // 5,20,25,27,30,35,40
		x.insertOrder(3);
		System.out.println("InsertOrder: " + x); // [3,5,20,25,27,30,35,40]

	}

}

class LinkedList<T> {
	private Node<T> First;

	public static class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	// add a new node
	public void add(T data) {
		Node<T> newNode = new Node<>(data);
		if (First == null) {
			First = newNode;
		} else {
			Node<T> current = First;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	// find the maximum value.
	public T max() {
		T max = First.data;
		Node<T> current = First.next;

		while (current != null) {
			if (((Integer) current.data).compareTo((Integer) max) > 0) {
				max = current.data;
			}
			current = current.next;
		}
		return max;
	}

	// delete a node
	public void delete(T value) {
		if (First == null) {
			return;
		}
		if (First.data.equals(value)) {
			First = First.next;
			return;
		}
		Node<T> current = First;
		while (current.next != null && !current.next.data.equals(value)) {
			current = current.next;
		}
		if (current.next != null) {
			current.next = current.next.next;
		}
	}

	// add a node at the beginning
	public void addBeg(T data) {
		Node<T> newNode = new Node<>(data);
		newNode.next = First;
		First = newNode;
	}

	public void addBeg1(T data) {
		Node<T> newNode = new Node<>(data);
		newNode.next = First;
		First = newNode;
	}

	// count the number of nodes
	public int count() {
		int count = 0;
		Node<T> current = First;

		while (current != null) {
			count++;
			current = current.next;
		}

		return count;
	}

	// insert a node
	public void insertAt(T data, int position) {

		Node<T> newNode = new Node<>(data);

		if (position == 1) {
			newNode.next = First;
			First = newNode;
			return;
		}

		Node<T> current = First;
		for (int i = 1; i < position - 1; i++) {
			current = current.next;
		}

		newNode.next = current.next;
		current.next = newNode;
	}

	// delete a node
	public void deleteAt(int position) {

		if (position == 1) {
			First = First.next;
			return;
		}

		Node<T> current = First;
		for (int i = 1; i < position - 1; i++) {
			current = current.next;
		}
		current.next = current.next.next;
	}

	// insert a node
	public void insertOrder(T data) {
		Node<T> newNode = new Node<>(data);

		if (First == null || (((Integer) First.data).compareTo((Integer) data) > 0)) {
			newNode.next = First;
			First = newNode;
			return;
		}
		Node<T> current = First;
		while (current.next != null && (((Integer) current.next.data).compareTo((Integer) data) < 0)) {
			current = current.next;
		}
		newNode.next = current.next;
		current.next = newNode;
	}

	public String toString() {
		StringJoiner joiner = new StringJoiner(", ");
		Node<T> current = First;

		while (current != null) {
			joiner.add(String.valueOf(current.data));
			current = current.next;
		}

		return joiner.toString();
	}
}
