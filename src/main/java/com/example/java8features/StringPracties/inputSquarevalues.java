/**
 * 
 */
package com.example.java8features.StringPracties;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Ajith
 *
 */
public class inputSquarevalues {
	/**
	 * Qustion  given inputs  to get Squarevales  given arrys/list  
	 * example  input 13  output =[2,3] exaplination  2^2,3^2  =2sequare + 3Sequare =4+9 =13
	 *          input 23  output =[1,1,1,2,4] explination 1^2,1^2,1^2,2^2,4^2 =1+1+1+4+16=23
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		  System.out.println("Enter vaue inputs square  :" );  
          int input=scanner.nextInt();
           
           List<Integer> result = findSquares(input);
           System.out.println("Output: " + result);
	}
	
	 public static List<Integer> findSquares(int target) {
	        List<Integer> squares = new ArrayList<>();
	        List<Integer> result = new ArrayList<>();

	        // Find all squares less than or equal to the target
	        for (int i = 1; i * i <= target; i++) {
	            squares.add(i * i);
	        }
	        
//	        System.out.println("squares: " + squares);
	        
	        List<Integer>seqIntegers=squares.stream().sorted((a,b)-> b-a).collect(Collectors.toList());
//	        System.out.println("seqIntegers: " + seqIntegers);
	        findSquaresHelper(seqIntegers, result, new ArrayList<>(), target, 0);
	        return result;
	    }

	    private static boolean findSquaresHelper(List<Integer> squares, List<Integer> result, List<Integer> tempList, int remaining, int start) {
	        if (remaining == 0) {
	            if (result.isEmpty() || tempList.size() < result.size()) {
	                result.clear();
	                List<Integer>teplate=tempList.stream().sorted().collect(Collectors.toList());
	                result.addAll(teplate);
	            }
	            return true;
	        }
	        
//	        System.out.println("squares.size() "+squares.size());
	        

	        for (int i = start; i < squares.size(); i++) {
	            int square = squares.get(i);
//	            System.out.println("square " +square);
//	            if (square > remaining) break; // Early termination
	            if(square >remaining) {
	            	i=i;
	            }else {
	            	tempList.add((int) Math.sqrt(square));
	   	            findSquaresHelper(squares, result, tempList, remaining - square, i);
	            }
//	            tempList.add((int) Math.sqrt(square));
//	            findSquaresHelper(squares, result, tempList, remaining - square, i);
//	            tempList.remove(tempList.size() - 1);
	        }
	        return false;
	    }

}
