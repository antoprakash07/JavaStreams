/**
 * 
 */
package com.example.java8features.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;




/**
 * @author Ajith 
 *
 */
public class JavaTechieExamples {
	
	public static void main(String []args) {
		
		/**
		 * Q1) java program to count the accurence of the each character in a string  using java 8?
		 */
		String input="ilovejava";
		
		String arr[]=input.split("");
		
		Map<String, Long> map= Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		System.out.println("map "+map);
		
		/**
		 * Q2) java programe to find the dublicate element  given String   (Example = String input="ilovejava");
		 * 
		 * 
		 */
		
		Set<String>set=new HashSet<>();
		List<String>dublicates=new ArrayList<>();	
		dublicates=Arrays.stream(arr).filter(n ->!set.add(n)).collect(Collectors.toList());
		System.out.println("dublicates "+dublicates); 
		
		/**
		 * Q3) java programe to find the non dublicate element  given String
		 * 
		 */
		
		List<String>nodublicates=Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet()
				.stream().filter(n -> n.getValue() ==1).map(x -> x.getKey())
				.collect(Collectors.toList());
		System.out.println("nodublicates "+nodublicates);
		
		/**
		 * Q3) java programe to find the first non dublicate element  given String
		 * 
		 */	
		
		String firstnodublicates=Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet()
				.stream().filter(n -> n.getValue() ==1)
				.findFirst().get().getKey();
		
		System.out.println("firstnodublicates "+firstnodublicates);
		
		/**
		 * Q4) java programe to find the longest length words   given Array
		 * Ex String Arra=["java","texhie",springboot]
		 */	
		
		String arrays[]= {"java","texhie","springboot"};
		
		String longestWord=Arrays.stream(arrays).reduce((word1, word2) -> word1.length() > word2.length() ?word1:word2)
				.get();
		
		System.out.println("longestWord "+longestWord);
		
	}

}
