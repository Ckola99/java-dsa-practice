package com.christopher.dsa.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		// Queue = FIFO data structure (a line of people)
		// Linear data structure, a collection designed for holding elements prior to processing
		// add = enqueue. offer()
		// remove = dequeue, poll()
		// offer poll and peek do not throw exceptions
		// Queue is actually an interface so we use LinkedLists


		// [head] - [] - [tail]

		Queue<String> queue = new LinkedList<String>();


		queue.offer("karen");
		queue.offer("Chad");
		queue.offer("Steve");
		queue.offer("Harold");

		// Queue extends collections so we can use collectio methods
		System.out.println(queue.isEmpty());
		System.out.println(queue.size());
		System.out.println(queue.contains("Harold"));

		// System.out.println(queue.peek()); lets us peek at the front of the queue

		System.out.println(queue);

		// Where are queues useful
		// 1. Keyboard Buffer (letters should apprear on the screen in the other they are pressed)
		// 2. Printer Queue (Print jobs should be completed in order)
		// 3. Used in LinkedLists, PriorityQueues, Braedth-first search
	}
}
