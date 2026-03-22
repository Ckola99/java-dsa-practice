package com.christopher.dsa.LinkedLists;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		LinkedList<String> linkedlist = new LinkedList<String>();

		// linkedlist.push("A");
		// linkedlist.push("B");
		// linkedlist.push("C");
		// linkedlist.push("D");
		// linkedlist.push("F");
		// linkedlist.pop();

		linkedlist.offer("A");
		linkedlist.offer("B");
		linkedlist.offer("C");
		linkedlist.offer("D");
		linkedlist.offer("F");
		// linkedlist.poll();

		linkedlist.add(4, "E");

		System.out.println(linkedlist.peekFirst());
		System.out.println(linkedlist.peekLast());
		linkedlist.addFirst("0");
		linkedlist.addLast("G");

		System.out.println(linkedlist);
	}

	// advantages
	// 1. Dynamic Data Structure (allocates needed memory while running)
	// 2. Insertion and deletion is easy. O(1)
	// 3. No/Low memory waste

	// 1. Greater memory usage (additional pointer)
	// 2. No random access of elemnts (no index [i])
	// 3. Accessing searching elements is more time consuming. O(n)

	// uses
	// 1. implement Stacks/queues
	// 2. GPS navigation
	// 3. music playlist
}
