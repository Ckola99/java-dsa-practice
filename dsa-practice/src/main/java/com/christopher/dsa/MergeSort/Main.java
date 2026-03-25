package com.christopher.dsa.MergeSort;

public class Main {
	// Faster than the below algos
	// O(n log n) = quasilinear time
	// - quicksort
	// - mergesort
	// - heapsort

	// O(n^2) = quadratic time
	// - insertion sort
	// - selection sort
	// - bubble sort

	// Psace
	// O(n) = linear space
	// Merge sort
	//
	// O(1) = constant space  (sort in place)
	// - Bubble sort
	// - Selection sort
	// - Insertion sort


	public static void main(String[] args) {
		int[] array = {8, 2, 5, 3, 4, 7, 6, 1};

		mergeSort(array);

		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	private static void mergeSort(int[] array){
		// base case
		if(array.length <= 1) return;

		int length = array.length;
		int middle = length / 2;

		int[] rightArray = new int[middle];
		int[] leftArray = new int[length - middle];

		int i = 0;
		int j = 0;

		for (; i < length; i++) {
			if(i < leftArray.length) {
				leftArray[i] = array[i];
			}
			else {
				rightArray[j] = array[i];
				j++;
			}
		}

		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(leftArray, rightArray, array);
	}

	private static void merge(int[] leftArray, int[] rightArray, int[] array) {
		int sizeOfRightArray = rightArray.length;
		int sizeofLeftArray = leftArray.length;
		int l = 0, r = 0, i = 0;

		while(l < sizeofLeftArray && r < sizeOfRightArray){
			if(leftArray[l] < rightArray[r]) {
				array[i] = leftArray[l];
				i++;
				l++;
			}
			else {
				array[i] = rightArray[r];
				i++;
				r++;
			}
		}

		while (r < sizeOfRightArray){
			array[i] = rightArray[r];
			r++;
			i++;
		}

		while (l < sizeofLeftArray) {
			array[i] = leftArray[l];
			l++;
			i++;
		}

	}
}
