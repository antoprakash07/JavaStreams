/**
 * 
 */
package com.example.java8features.Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ajith A
 *
 */
public class ArrayExamples {
	
	public static  void main(String[] args) {
		
		int arrays[]= {10,12,15,18,15,22,55,43,67,55,18};
		
		/**
		 * above array based find the dublicates element 
		 */
		
		Set<Integer>set=new HashSet<>();
		List<Integer>list=new ArrayList<>();	
		for (int i : arrays) {
			if(!set.add(i)) {
				list.add(i);
			}
		}
		
		System.out.println("dublicates Values "+list);
		
	}

}
