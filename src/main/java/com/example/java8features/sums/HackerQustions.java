/**
 * 
 */
package com.example.java8features.sums;

import java.util.Scanner;

/**
 * @author Ajith
 *
 */
public class HackerQustions {
	
	/**
	 * 
	 * @param QUSTION
	 * 
	 * We use the integers a, b, and  to create the following series:
	 * 
	 * You are given  queries in the form of a, b, and n. For each query, print the series corresponding to the given a, b, and n values as a single line of  space-separated integers.

          
          Input Format

           The first line contains an integer, q, denoting the number of queries.
          Each line i of the  q subsequent lines contains three space-separated integers describing the respective ai,bi ,ni and  values for that query.
	 * 
	 * 
	 * 
	 * Output Format

          For each query, print the corresponding series on a new line. Each series must be printed in order as a single line of  space-separated integers.
          
          input 
          2
          0 2 10
          5 3 5
          
          Sample Output
          
          2 6 14 30 62 126 254 510 1022 2046
          8 14 26 50 98
          
          
          
    Explanation

	We have two queries:

	1.We use a=0,b=2 ,n=10 and  to produce some series :

		s0,s1,.....,sn-1 :
	 	s0 = 0+ 1*2 =2
	 	s0 = 0+ 1*2 +2*2  =6
	 	s0 = 0+ 1*2 +2*2 +4 *2=14
		... and so on.	

      2.We use a=5,b=3 ,n=5 and  to produce some series :
          s0,s1,.....,sn-1 :
          s0 = 5 + (1*3) =8
	      s0 = 5 + (1*3 +2*3 ) =24
          s0 = 5 +( 1*3 +2*3 +4 *3)=26
          s0 = 5 + (1*3 +2*3 +4 *3 +8 *3 )=50
          s0 = 5 + (1*3 +2*3 +4 *3 +8 *3 +16 *3 )=98
	 */
	
	
	public static void main(String []args) {
		
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Enter Over All Loop ");
		int t=scan.nextInt();
		
		for(int i=0;i<t;i++) {
			System.out.println("Enter the A value");
			int a=scan.nextInt();
			System.out.println("Enter the B value");
			int b=scan.nextInt();
			System.out.println("Enter the n value");
			int n=scan.nextInt();
			 double result = Math.pow(2, n);
			 int loop=(int)result;
//			 System.out.println("loop "+loop);
			for(int j=1;j<loop;j=j*2) {
//				System.out.println("j "+j);
				
				int sum=0;
				
				for(int k=1;k<=j;k=k*2) {
					int total=(k*b);
					sum+=total;
				}
				System.out.print((sum+a) +" ");
				
			}
			 System.out.println();
			
		}
		
		/**
		 * 
		 */
		
		int lineNumber=1;
        while(scan.hasNext()){
              String line = scan.nextLine();  // Read the next line of input
            System.out.println(lineNumber + " " + line);  // Print line number and content
            lineNumber++; 
        }
        
        scan.close();
		
	}

}
