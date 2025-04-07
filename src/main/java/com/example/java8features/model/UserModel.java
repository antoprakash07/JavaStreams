/**
 * 
 */
package com.example.java8features.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Ajith A
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
	
	private Long id;
	private String name;
	private String address;

}
