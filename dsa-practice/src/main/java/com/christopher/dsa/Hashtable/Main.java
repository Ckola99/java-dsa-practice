package com.christopher.dsa.Hashtable;

import java.util.*;

public class Main {
	// Entry <K, V>
	// key.hashcode() the codeis
	// hash is for eg: key.hashCode() % capacity
	// collitions turn our bucket into a linked list
	// Hashtable = A data structure that stores unique keys to values ex.<Integer, String>
	//		Each key/value pair is known as Entry
	//		FAST insertion, look up, deletion of key/value pairs
	//		Not ideal for small data sets, great with large data sets
	// hashing = takes a key and computes an integer (formula will vary based on key and data type)
	//		In a hashtable, we use the hash % capacity to calculate an index number
	//		key.hashCode() % capacity = index
	// bucket = an indexed storage location for one or more entries
	//	    can store multiple Entries in case of a collision (linked similarly a linkedlist)
	// collision = hash function generates the same index for more than one key
	//	    less collisions = more efficiency

	public static void main(String[] args) {
		Hashtable<String, String> table = new Hashtable<>(21);

		table.put("100", "Spongebob");
		table.put("123", "Patrick");
		table.put("321", "Sandy");
		table.put("555", "Squidward");
		table.put("777", "Gary");

		// table.remove(777);

		for (String key : table.keySet()) {
			System.out.println(key.hashCode() % 21 + "\t" + key + "\t" + table.get(key));
		}
	}
}
