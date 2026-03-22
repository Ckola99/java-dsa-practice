package com.christopher.dsa.PriorityQueue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {

		// Priority Queue = A FIFO data structure that serves elements
		// with the highest priorities first
		// before elements with lower priority
		// Collections.reverseOrder() lets us place things in descending order

		Queue<String> queue = new PriorityQueue<>(Collections.reverseOrder());
		queue.offer("B");
		queue.offer("C");
		queue.offer("D");
		queue.offer("F");
		queue.offer("D");

		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}

	}
}
