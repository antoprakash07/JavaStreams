/**
 * 
 */
package com.example.java8features.java11Features;


import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ajith
 *
 */
public class StringExamples {
	
	public static void main(String[] args) {
		String name =" ";
		
		System.out.println(" is Blank "+ name.isBlank());
		System.out.println(" is Empty "+ name.isEmpty());
		
		String st =" Welcome to the \n World ";
		System.out.println(" white space remove"+st.strip());
		System.out.println(" noremovewhitespace  "+st.stripTrailing());
		
		
		String multilineString = "Baeldung helps \n \n developers \n explore Java.";
		List<String> lines = multilineString.lines()
		  .filter(line -> !line.isBlank())
		  .map(String::strip)
		  .collect(Collectors.toList());
		System.out.println(" lines "+lines);
//		assertThat(lines).containsExactly("Baeldung helps", "developers", "explore Java.");
		
	}

}
