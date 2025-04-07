/**
 * 
 */
package com.example.java8features.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Ajith
 *
 */
public class StreamExamples {

	public static void main(String[] args) {

		/**
		 * what is stream and why its using java? A sequence of elements supporting
		 * sequential and parallel aggregate operations. Elements are processed in a
		 * pipeline, which includes various intermediate and terminal operations.
		 * 
		 * 
		 * what are the intermediate operation instream?
		 * 
		 * Return a new stream and are lazy (not executed until a terminal operation is
		 * invoked). Examples: filter(), map(), flatMap(), distinct(), sorted(),
		 * limit(), skip()
		 * 
		 * 
		 * Terminal Operations:
		 *
		 * Trigger the pipeline processing and produce a result or a side effect.
		 * Examples: forEach(), collect(), reduce(), count(), findFirst(), findAny(),
		 * allMatch(), noneMatch(), anyMatch()
		 *
		 */

		/**
		 * filter method to use predicate interface to return boolean only
		 * 
		 * map method to use function interface
		 */
		
		/**
		 * what is difference between  Stream and paralelstream ?
		 * 
		 *  the stream is to run single thread to run 
		 *  
		 *  the paralelstream  runing is multi thread to run 
		 * 
		 */

		/* ArrayBased Stream Using */
		
		 String sentence="Ajith is a Good person and Good Man Ajith";
	        List<String> seltenceList=Arrays.asList(sentence.split(" "));
	        
	        System.out.println("seltenceList " +seltenceList);
	        
	        Map<String,Integer>mapcount=new HashMap<>();
	        
	        for(String s :seltenceList){
	            if(mapcount.containsKey(s)){
	                mapcount.put(s,mapcount.get(s)+1);
	            }else{
	                mapcount.put(s,1);
	            }
	        }
	         System.out.println("mapcount " +mapcount);
	         
	       
	         //Dublicate value only printed 
	           int array[]={10,28,87,10,20,76,28,80};
	           List<Integer>list=Arrays.stream(array).boxed()
	                             .collect(Collectors.toList());
	        System.out.println("List: " + list);
	           
	        Set<Integer> set = new HashSet<>();
	        Set<Integer> duplicates = Arrays.stream(array).boxed()
	                .filter(num -> !set.add(num))  
	                .collect(Collectors.toSet());
	        System.out.println("Duplicate  Array values: " + duplicates); 
	        
	         Set<Integer> set1 = new HashSet<>();
	         Set<Integer> duplicates1 = list.stream()
	                .filter(num -> !set1.add(num))  
	                .collect(Collectors.toSet());
	                 System.out.println("Duplicate  list values: " + duplicates); 
	                 

		int arr[] = { 1, 2, 1, 2, 3, 4, 5 };
		IntStream sorted = Arrays.stream(arr).distinct().sorted();

		sorted.forEach(System.out::println);

		Long length = Arrays.stream(arr).count();
		System.out.println("length " + length);

		int totalofArrayValues = Arrays.stream(arr).sum();
		System.out.println("total " + totalofArrayValues);
		
		int total=Arrays.stream(arr)
				.reduce(0, (a,b)->a+b);
		System.out.println("total1 " + total);
		
		OptionalDouble avg = Arrays.stream(arr).average();

		System.out.println("avg " + avg.getAsDouble());

		int max = Arrays.stream(arr).distinct().max().orElse(0);
		System.out.println("max " + max);

		// secound max

		int secoundMax = Arrays.stream(arr).distinct().boxed().sorted((a, b) -> b - a).skip(1).findFirst()
				.orElseThrow();
		System.out.println("secoundMax " + secoundMax);

		int secoundMax1 = Arrays.stream(arr).distinct().boxed().sorted((a, b) -> b.compareTo(a)).skip(1).findFirst()
				.orElseThrow();
		System.out.println("secoundMax " + secoundMax1);

		int min = Arrays.stream(arr).distinct().min().orElse(0);
		System.out.println("min " + min);
		int secoundmin = Arrays.stream(arr).distinct().sorted().skip(1).findFirst().orElseThrow();

		System.out.println("secoundmin " + secoundmin);

		IntStream unique = Arrays.stream(arr).distinct();
		unique.forEach(System.out::println);

		System.out.println("Even numbers:");
		Arrays.stream(arr).filter(n -> n % 2 == 0).forEach(System.out::println);

		System.out.println("Odd numbers:");
		Arrays.stream(arr).filter(n -> n % 2 != 0).forEach(System.out::println);

		/*
		 * collection Based Stream Api function
		 */

		List<Employe> employes = new ArrayList<>();
		// 1L - means Long variable type is
		employes.add(new Employe(1L, "A", "java", 10000, 2));
		employes.add(new Employe(2L, "B", "java", 15000, 3));
		employes.add(new Employe(3L, "C", "React", 15000, 2));
		employes.add(new Employe(4L, "D", "React Native", 20000, 4));
		employes.add(new Employe(5L, "E", "Angular", 20000, 1));
		employes.add(new Employe(6L, "F", "Android", 21000, 1));

		//how to get above 2 years exprience person list?
		List<Employe> employes2 = employes.stream()
				                  .filter(em -> em.getExprience() > 2)
				                  .collect(Collectors.toList());

		System.out.println("above two years exprience person " + employes2);
		
		//how to get above 2 years exprience person and salary above 15000 list?
		List<Employe> employes3 = employes.stream()
				                 .filter(em -> em.getExprience() > 2)
				                 .filter(em -> em.getSalary() > 15000)
				                  .collect(Collectors.toList());

		System.out.println(" exprience >2 with salary > 15000 " + employes3);

		//how to get above 2 years exprience person and salary above 15000 and department java or reactive  only list? 
		List<Employe> employes4= employes.stream()
				                 .filter(em -> em.getExprience() > 2)
				                 .filter(em -> em.getSalary() > 15000)
				                 .filter(em -> em.getDept().equals("java") ||em.getDept().equals("React Native") )
				                 .collect(Collectors.toList());

		System.out.println(" exprience >2 with salary > 15000  department " + employes4 );
		
		
		//how to get above 2 years exprience person and salary above 15000 and department java or reactive  only for name list? 
		
		List<String> names= employes.stream()
                .filter(em -> em.getExprience() > 2)
                .filter(em -> em.getSalary() > 15000)
                .filter(em -> em.getDept().equals("java") ||em.getDept().equals("React Native") )
                .map(em -> em.getName())
                .collect(Collectors.toList());

System.out.println(" exprience >2 with salary > 15000  department get names " + names );

// company maximum salary get employee list 
  
            Optional<Employe>employes5=employes.stream()
            		               .max(Comparator.comparingInt(Employe::getSalary));
            
            System.out.println("maximum salary "+employes5);
           
            Optional<Integer> maxSalary =employes.stream()
            		       .max(Comparator.comparingInt(Employe::getSalary))
            		       .map(e ->e.getSalary());
            
         // Finding all employees with the maximum salary
            List<Employe> maxSalaryEmployes = employes.stream()
                                                      .filter(e -> e.getSalary() == maxSalary.get())
                                                      .collect(Collectors.toList());
            
            System.out.println("maxSalaryEmployes "+ maxSalaryEmployes);
            
          //total salary
            
    IntSummaryStatistics totalsalary=    employes.stream()
        .collect(Collectors.summarizingInt(Employe::getSalary));
    
    System.out.println("totalsalary "+ totalsalary.getSum()); 
            
       /**
        * Tcs Qustion 
        * 
        * find All number starting with 1 using java Stream
        *       
        */
    
    List<Integer>numbers=Arrays.asList(1,12,34,44,56,67,18,90,101);
    
        List<String>num=numbers.stream().map(nu ->nu+"" ).filter(nu ->nu.startsWith("1")).collect(Collectors.toList());
        System.out.println("num "+num);

	}

}
