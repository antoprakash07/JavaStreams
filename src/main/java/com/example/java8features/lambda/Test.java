/**
 * 
 */
package com.example.java8features.lambda;

import lombok.Data;

/**
 * @author Ajith
 *
 */
@Data
public class Test implements Contract {
	
	private String name;
	

	
	
	
	@Override
	public int add(int a, int b) {
		
		return a + b;
	}

}
