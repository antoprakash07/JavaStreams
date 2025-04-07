/**
 * 
 */
package com.example.java8features.palindrome;

import java.util.Scanner;

/**
 * @author Ajith
 *
 */
public class Palindrome {
	
    public static boolean isPalindromeInt(int number) {
        int originalNumber = number;
        int reversedNumber = 0;

        // Reverse the number
        while (number != 0) {
            int remainder = number % 10;       // Get the last digit
            reversedNumber = reversedNumber * 10 + remainder;  // Append it to the reversed number
            number = number / 10;              // Remove the last digit from the number
        }

        // Check if the original number and the reversed number are the same
        return originalNumber == reversedNumber;
    }

	
	public static void main(String[] args) {
		
		Scanner in =new Scanner(System.in);
		System.out.println("enter input  :" );
		
		String input=in.nextLine();
		
		char array[]=input.toCharArray();
		
		boolean isPalindrome=true;
		
		for(int i=0; i <= array.length/2;i++) {
//			System.out.println("i "+i +" array.length/2 " + array.length/2);
//			System.out.println("array.length - 1 - i = "+ (array.length - 1 - i));
//			System.out.println("length " + (array.length - 1));
//			System.out.println(" i " +i);
//			System.out.println( "array[i] "+array[i]   +  " array[array.length - 1 - i] "+array[array.length - 1 - i]);
			if (array[i] != array[array.length - 1 - i]) {
                isPalindrome = false;
                break;
            }
			
		}
		
		  if (isPalindrome) {
	            System.out.println("Palindrome: " + input);
	        } else {
	            System.out.println("Not a palindrome: " + input);
	        }
	        
	        
	        
	     
	    
			System.out.println("enter input  Integers :" );
			
			int num=in.nextInt();
			
			 if (isPalindromeInt(num)) {
		            System.out.println(num + " is a palindrome.");
		        } else {
		            System.out.println(num + " is not a palindrome.");
		        }
	        
			 in.close();
	}

}
