package com.christopher.dsa.stacks;

import java.util.Stack;

public class Main {
	public static void main (String[] args) {

		// stack = LIFO data structure.
		// stores objects onto a vertical tower
		// push() to add to the top
		// pop() to remove from the top

		Stack<String> stack = new Stack<String>();

		// System.out.println(stack.empty());
		stack.push("GTA V");
		stack.push("Ghost of tshushima");
		stack.push("GOW 4");

		// remove top item
		// String myfav = stack.pop();

		// take a look at the top
		String topItem = stack.peek();
		System.out.println(topItem);

		// System.out.println(myfav);
		System.out.println(stack);

		// search for specific item
		System.out.println(stack.search("GOW 4"));


		// Stacks can run out of space
		// for (int i = 0; i < 10000000000; i++) {
		// 	stack.push("Fallout76")
		// }

		// uses of stacks
		// 1. Undo/redo features in text editors
		// 2. moving back/forward through browser history
		// 3. backtracking algorithms (maze, search through file directories)
		// 4. calling the functions (call stack)
	}
}
