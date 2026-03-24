package com.christopher.dsa.InsertionSort;

public class Main {

	// Insertion Sort = after comparing elements to the left
	//		    shift elements to the right to make room to insert a value
	//
	// Quadratic time O(n^2)
	// small data = decent
	// large data = BAD
	// Less steps than Bubble Sort
	// Best case is O(n) compared to Selection Sort O(n^2)
	// Adaptive: If the array is already mostly sorted, it is incredibly fast
	// (O(n))
	// Stable: It doesn't change the relative order of elements with equal values.

	public static void main(String[] args) {
		int array[] = {9, 1, 8, 2, 7, 3, 6, 5, 4};

		insertionSort(array);

		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	private static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++){
			int temp = array[i];
			int j = i - 1;

			while(j >= 0 && array[j] > temp) {
				array[j + 1] = array[j];
				j--;
			}

			array[j + 1] = temp;
		}
	}
}
