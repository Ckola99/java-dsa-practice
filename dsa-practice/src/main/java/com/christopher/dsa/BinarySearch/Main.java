package com.christopher.dsa.BinarySearch;
import java.util.Arrays;

public class Main {

	// Search algorithm that finds the position of a target value within a sorted array.
	// Half od the array is eliminated during each "step"
	public static void main(String[] args) {
		int array[] = new int[1000000];
		int target = 777777;

		for (int i =0; i < array.length; i++) {
			array[i] = i;
		}

		int index = binarySearch(array, target);

		if(index == -1) {
			System.out.println(target + " not found");
		}
		else {
			System.out.println("Element found at " + index);
		}
	}

	private static int binarySearch(int[] array, int target) {
		int left  = 0;
		int right = array.length - 1;

		while (left <= right) {
			int middle = left + (right - left) / 2;
			int value = array[middle];

			System.out.println("middle: " + value);

			if (value < target) left = middle + 1;
			else if (value > target) right = middle - 1;
			else return middle;
		}

		return -1;
	}
}
