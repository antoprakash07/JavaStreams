/**
 * 
 */
package com.example.java8features.lambda;

/**
 * @author Ajith
 *
 */
@FunctionalInterface
public interface Lambeda {
  
	/*what is lambeda  why its using ?
	 * the lambeda expression to achive functional interface using only and the
	 * functional interface only one abstarct method must and don't allow another
	 * absract method to allow differnt types of methods 
	 * ex == 1.default method
	 * 2.static method
	 */
	  
	//abstact method 
	public int add(int a,int b);
	
	//static method 
	public static void rule() {
		
	}
	//default method 
	 public default void rule1() {
		 
	 }
	 
	 /*
		 * fuctional interface is  there are four types 
		 * 
		 * 1.Predicated the predicate is a function with only one arguments and returns
		 * boolean value only
		 * 2.Consumer - no result
		 * 3.function - input and output 
		 * 4.supplier - no input only supllier
		 *   
		 *   
		 */
	 
	 
	 

}
