/**
 * 
 */
package com.example.java8features.methodReference;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ajith
 *
 */
public class Demo {
	
	public void print(int no) {
		System.out.println("no static method "+ no);
	}
	
	public static void name(int no) {
		System.out.println("static method " +no);
	}
	
	public static void main (String[] args) {
		
		List<Integer>list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		//normal for each
		list.forEach(e -> System.out.println(e));
		
		//double collan reference 
		list.forEach(System.out::println);
		
		/*
		 * Method references are a special type of lambda expressions. They’re often
		 * used to create simple lambda expressions by referencing existing methods.
		 * 
		 * There are four kinds of method references:
		 * 
		 * 1.Static methods 
		 * 2.Instance methods of particular objects
         * 3.Instance methods of an arbitrary object of a particular type 
         * 4.Constructor
		 */
		
		
		/**
		 * the method reference we can use static methods and  non static method also used
		 * 
		 * Ex  of static methods
		 *   
		 */
		
		Demo demo=new Demo();
		
		//normal call
		Contract1 con= no ->System.out.println(no);
		
		/**
		 *  functional interface  method  and  non static method arguments match  
		 *  
		 *  this object based call the method 
		 */
		 Contract1 contract1=demo::print;
		 contract1.show(12);
		 
		 /**
		  * the static method also match the functional interface should method arguments match
		  * 
		  * this class Based 
		  */
		 
		 Contract1 contract12=Demo::name;
		 contract12.show(5);
		
	}

}
