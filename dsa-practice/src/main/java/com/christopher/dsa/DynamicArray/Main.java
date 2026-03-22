package com.christopher.dsa.DynamicArray;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		// 1. Random access
		// 2. Good locality of reference and data
		// 3. Easy to insert and delete elements at the end

		// 1. Wastes more memory
		// 2. Shifting elements is time consuming
		// 3. Expanding/shrinking the array is time consuming

		// dexpanding = nes String[capacity * 2]

		// ArrayList<String> arrayList = new ArrayList<>();

		DynamicArray dynamicArray = new DynamicArray(5);
		dynamicArray.add("A");
		dynamicArray.add("B");
		dynamicArray.add("C");
		dynamicArray.add("D");
		dynamicArray.add("E");
		dynamicArray.add("F");

		dynamicArray.delete("A");
		dynamicArray.delete("B");
		dynamicArray.delete("C");

		// dynamicArray.insert(0, "X");
		// dynamicArray.delete("A");
		// System.out.println(dynamicArray.search("C"));

		System.out.println(dynamicArray);
		System.out.println(dynamicArray.size);
		System.out.println(dynamicArray.capacity);
		System.out.println("empty: " + dynamicArray.isEmpty());
	}
}
