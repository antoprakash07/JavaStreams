/**
 * 
 */
package com.example.java8features.StringPracties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Ajith A
 *
 */
public class InterviewProblems {
	
	public static void main(String args[]) {
		
		Scanner scanner=new Scanner(System.in);
		
            
            //Zeho interview Qustions 
		//Quation 1
//            i)input pattern = abba and s=dog cat cat dog  this pattern based if come true 
//            ii)input pattern = abbc and s=dog cat cat fish  result is false 
//            iii)input pattern = aaac and s=dog dog dog fish  result is false
		System.out.println("Enter pattern");
		String pattern=scanner.nextLine();
		
		List<String>list=Arrays.asList(pattern.split(""));
		
		String s="";
		String a="dog";
		String b="cat";
		String c="fish";
//		System.out.println("a "+a );
//		System.out.println("b " +b);
//		System.out.println("c "+c);
//		
		
		for(String st:list) {
//			System.out.println("sd"+ st);
//			
//			System.out.println("a status "+ st == "a");
			if(st.equals("a") || st == "a") {
//				System.out.println("inside  a");
				s +=a +" " ;
			}else  if(st.equals("b")||st == "b"){
				
//				System.out.println("b");
				s +=b +" ";
			}else  if(st.equals("c") ||st == "c"){
				s +=c +" ";
			}
		}
		
		boolean result1=false;
		
		String inputpattern="dog cat cat dog";
		
//		System.out.println("input pattern "+inputpattern.trim());
//		System.out.println(" S value"+ s.trim());
//		System.out.println("s space remove "+ s.replaceAll(" ", "") + s.replace(" ", ""));
		
		
		
		if(inputpattern.trim().equals(s.trim())) {
			result1=true;
		}else {
			result1=false;
		}
		
		System.out.println("result1;" +result1);
		
		
//		
		
		//Qustion 2 
		
		// substring to get inndex based 
		
		 String name="Ajith1";
         String name1= new String("Ajith");
         String name2= new String("Ajith");
         
         System.out.println("status Normal: " + name == name1);
         
          System.out.println("status Equals: " + name.equals(name1));
          
           System.out.println("status Equals 1: " + name1.equals(name2));
           
            System.out.println("status Equals: " +name1.compareTo(name));
            
            String sub=name.substring(0, 3);
            
            System.out.println("sub" +sub);
            String sub1=name.substring(3,5);
            System.out.println("sub1" +sub1);
            
        
            
        
	}
	
   


}
