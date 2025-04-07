/**
 * 
 */
package com.example.java8features.lambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author Ajith
 *
 */
public class ProgrameRunning {
	
	public static void main (String [] args) {
		// regular using class and interface 
		Test test=new Test();
		int num=test.add(5, 5);
		
		System.out.println("normal  output "+ num);
		
		//Lambda  based 
		Lambeda lambeda= (a,b)->{
			return a+b;
			};
			
		int total=lambeda.add(2,2);
		
		System.out.println("Lambeda "+ total);
		
		//
		
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
		
		/**
		 * predicate Examples 
		 * 
		 * its only return the boolean value  only 
		 * if you check all conditions ,
		 */
		Predicate<Integer> voterEligible= (age) -> (age > 18);
		Predicate<String> length= (word) -> (word.length() >5);
		
		System.out.println(voterEligible.test(19));
		System.out.println(length.test("Ajith"));
		
		ArrayList al=new ArrayList<>();
		System.out.println(al.size());
		Predicate<Collection>size = (a) -> (a.size() > 0);
		
		System.out.println(size.test(al));
		
		ArrayList<Integer> list=new ArrayList<>();
		list.add(1);
		Predicate<ArrayList> li= l ->l.size() > 0;
		
		System.out.println(li.test(list));
		
		/**
		 * Consumer
		 * 
		 * the consumer is  no return  only void function
		 * 
		 */
		
		Test test2 =new Test();
		Consumer<Test>setName=t -> t.setName("AA");
        setName.accept(test2);
		System.out.println("output "+ test2.getName());
		
		/**
		 * function 
		 * 
		 * the function is get input  and  sum opertion and  give output also 
		 */
		
		Function<Integer,String>function=t->t*10 + " Data multiple function";
		String result=function.apply(2);
		System.out.println("result "+result);
		
		/**
		 * supplier
		 * 
		 * the  supplier function  no input  get  its only give  output for  rendom genrate numbers ,
		 * and the supplier availabe only  for one get method  
		 * 
		 * the supplier get value for Mathfunction and random method  only because this only  cant give input for 
		 * Math function 
		 * 
		 */
		
		Supplier<Double>supplier=()-> Math.random();
		
		Double reuslt=supplier.get();
		
		System.out.println("reuslt " +reuslt);
		
		
	}

}
