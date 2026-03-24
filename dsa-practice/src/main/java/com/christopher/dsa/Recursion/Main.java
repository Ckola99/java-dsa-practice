package com.christopher.dsa.Recursion;

public class Main {
	// recursion = When a thing is defined in terms of itself.
	// Apply the result of a procedure to a procedure
	// A recursive method calls itself. Can be a substitute for itersation.
	// Divide a problem into sub-problems of the same type as the original
	// Commonly used with advance sorting algorithms and navigating trees

	// Advantages
	//
	// easier to read/write
	// easier to debug

	// Disadvantages
	//
	// sometimes slower
	// uses more memory


	public static void main(String[] args) {
		walk(5);
		System.out.println(factorial(7));
		System.out.println(power(2, 8));
	}

	private static void walk(int steps) {
		// for(int i = 0; i < steps; i++) {
		// 	System.out.println("STEP! ");
		// }

		if(steps < 1) return;

		System.out.println("STEP!");
		walk(steps - 1);
	}

	private static int factorial(int num) {
		if(num < 1) return 1;

		return num * factorial(num - 1);
	}

	private static int power(int base, int power) {
		if(power == 0){
			return 1;
		}

		return base * power(base, power - 1);
	}
}
