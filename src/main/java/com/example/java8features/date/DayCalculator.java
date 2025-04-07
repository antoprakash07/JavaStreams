package com.example.java8features.date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
public class DayCalculator {
	
	public static void main(String[] args) {
        long givenMillis = 1721215447011L;  // Example timestamp
        LocalDate currentDate = LocalDate.now();
        
        LocalDateTime givenDate = convertMillisToLocalDateTime(givenMillis);
        LocalDate givenLocalDate = givenDate.toLocalDate();

        long dayCount = calculateDayCount(givenLocalDate,currentDate);
        
        System.out.println("Given Date: " + givenLocalDate);
        System.out.println("Current Date: " + currentDate);
        System.out.println("Day Count: " + dayCount);
    }

    public static LocalDateTime convertMillisToLocalDateTime(long millis) {
        Instant instant = Instant.ofEpochMilli(millis);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    public static long calculateDayCount(LocalDate givenDate,LocalDate currentDate) {
        return ChronoUnit.DAYS.between(givenDate, currentDate);
    }


}
