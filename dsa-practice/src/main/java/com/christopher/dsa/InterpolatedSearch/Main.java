package com.christopher.dsa.InterpolatedSearch;

public class Main {
	// Interpolation search = improvement over binary search best used for "uniformly" distributed data
	// "guesses" where a value might be based on calculated probe results
	// if probe is incorrect, search area is narrowed , and new probe is calculated
	//
	// average case O(log(log(n)))
	// worst case: O(n)

	public static void main(String[] args) {
		int[] array = { 1, 2, 4, 8, 16, 32, 64, 125, 256, 512, 1024};
		int index = interpolationSearch(array, 256);

		if (index != -1) {
			System.out.println("Element found at index: " + index);
		}
		else{
			System.out.println("Element is not found");
		}
	}

	private static int interpolationSearch(int[] array, int value){
		int right = array.length - 1;
		int left = 0;

		while (value >= array[left] && value <= array[right] && left <= right) {
			int probe = left + (right - left) * (value - array[left]) /
				    (array[right] - array[left]);

			System.out.println("probe: " + probe);

			if(array[probe] == value) {
				return probe;
			}
			else if(array[probe] < value) {
				left = probe + 1;
			}
			else {
				right = probe + 1;
			}
		}

		return -1;
	}

}
