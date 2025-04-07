/**
 * 
 */
package com.example.java8features.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ajith
 *
 */
public class Date {
	/**
	 * joter used  input give some count that count based  end date show  the  count start date  cant be start current date
	 * and  the Holy days  and   week end days  not consider  that  working day count 
	 * 
	 * @param args
	 */
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        Set<LocalDate> holidays = new HashSet<LocalDate>(Arrays.asList(
            // Add your holidays here in the format YYYY-MM-DD
            LocalDate.of(2024, 1, 1),   // New Year's Day
            LocalDate.of(2024, 7, 4), 
            LocalDate.of(2024, 7, 18),// Independence Day
            LocalDate.of(2024, 7, 22),
            LocalDate.of(2024, 12, 25)  // Christmas Day
        ));
        
        System.out.println("holidays "+ holidays);
        int businessDaysCount = 5; 
        LocalDate startDate = calculateStartDate(currentDate, holidays);
        System.out.println("Start Date: " + startDate);
        LocalDate endDate = calculateEndDate(startDate, businessDaysCount, holidays);
        System.out.println("End Date: " + endDate);
        
    }

    public static LocalDate calculateStartDate(LocalDate currentDate, Set<LocalDate> holidays) {
        LocalDate startDate = currentDate.plusDays(1);
        
        while (isWeekend(startDate) || holidays.contains(startDate)) {
            startDate = startDate.plusDays(1);
        }
        
        return startDate;
    }

    public static boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }
    
    
    public static LocalDate calculateEndDate(LocalDate startDate, int businessDaysCount, Set<LocalDate> holidays) {
        LocalDate endDate = startDate;
        int daysAdded = 0;
        
        while (daysAdded < businessDaysCount) {
            endDate = endDate.plusDays(1);
            
            if (!isWeekend(endDate) && !holidays.contains(endDate)) {
                daysAdded++;
            }
        }
        
        return endDate;
    }

    


}
