/**
 * 
 */
package com.example.java8features.stream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ajith
 *
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employe {
	
	private Long id;
	private String name;
	private String dept;
	private int salary,exprience;
	
	
	

}
