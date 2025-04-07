/**
 * 
 */
package com.example.java8features.exampleofForEach;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author edwin
 *
 */
public class Test22 {

	
//	// for loop 
//		for(int i=0;i<2 ;i++) {
//			System.out.println(i);
//			
//		}
//		
//		//enhanced for loop
//		for(Integer values :list) {
//			System.out.println(values);
//		}
	
	public static void main (String [] args) {
		 // Create an int array
        int[] arr = {1, 2, 3, 4};

        // Convert int array to Integer array
        Integer[] integerArray = IntStream.of(arr).boxed().toArray(Integer[]::new);

        // Convert Integer array to List using Arrays.asList()
        List<Integer> list = Arrays.asList(integerArray);
		System.out.println(""+list);
		
		/**
		 * for and forEach Differents 
		 */
		
		//for loop
		for(int i=0;i<arr.length;i++) {
			System.out.println("arr "+ arr[i]);
		}
		//Enhanced ForLoop
		for(Integer integer :list) {
			System.out.println(integer);
		}
		
		/**
		 * above Both loop are Call External for Loop 
		 * 
		 * and the internal for loop is ForEach
		 */
		//for each 
		list.forEach(e -> System.out.println(e));
		
	}

}
