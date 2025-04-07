/**
 * 
 */
package com.example.java8features.date;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author edwin
 *
 */
public class Businessalculator {
	
    private Date startDate;
    private Date endDate;

    private static Set<Date> holidays = new HashSet<>();

    // Constructor
    public Businessalculator(Date startDate) {
        this.startDate = adjustToNextWorkingDay(startDate);
    }

    // Add a holiday
    public static void addHoliday(Date holiday) {
        holidays.add(holiday);
    }

    // Method to calculate the end date
    public void calculateEndDate(long milliseconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        while (milliseconds > 0) {
            // Add milliseconds in chunks for efficiency
            long increment = Math.min(milliseconds, 60 * 60 * 1000); // Add up to an hour
            calendar.add(Calendar.MILLISECOND, (int) increment);

            if (isWorkingDay(calendar.getTime())) {
                milliseconds -= increment;
            } else {
                // If not a working day, move to the next working day
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
            }
        }

        this.endDate = calendar.getTime();
    }

    // Check if a date is a working day (not a weekend or holiday)
    private boolean isWorkingDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // Check if the date is a weekend
        if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
            return false;
        }

        // Check if the date is a holiday
        for (Date holiday : holidays) {
            Calendar holidayCal = Calendar.getInstance();
            holidayCal.setTime(holiday);

            if (calendar.get(Calendar.YEAR) == holidayCal.get(Calendar.YEAR) &&
                calendar.get(Calendar.MONTH) == holidayCal.get(Calendar.MONTH) &&
                calendar.get(Calendar.DAY_OF_MONTH) == holidayCal.get(Calendar.DAY_OF_MONTH)) {
                return false;
            }
        }

        return true;
    }

    // Adjust the date to the next working day if it falls on a weekend or holiday
    private Date adjustToNextWorkingDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        while (!isWorkingDay(calendar.getTime())) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        return calendar.getTime();
    }

    // Getters
    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public static long convertToMilliseconds(int days, int hours, int minutes) {
        long millisInADay = 24 * 60 * 60 * 1000L;
        long millisInAnHour = 60 * 60 * 1000L;
        long millisInAMinute = 60 * 1000L;

        return (days * millisInADay) + (hours * millisInAnHour) + (minutes * millisInAMinute);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example usage
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.JULY, 15); // Set the start date (a holiday)
        Businessalculator workingHoursInstance = new Businessalculator(calendar.getTime());

        // Add holidays
        calendar.set(2024, Calendar.JULY, 15); // Example holiday
        Businessalculator.addHoliday(calendar.getTime());
        calendar.set(2024, Calendar.JULY, 16); // Another holiday
        Businessalculator.addHoliday(calendar.getTime());

        System.out.println("Enter Working Days:Hours:Minutes in format (D:H:M):");

        String input = scanner.nextLine();
        String[] parts = input.split(":");
        if (parts.length != 3) {
            System.out.println("ERROR! Please enter the input in the format D:H:M");
            return;
        }

        long milliseconds = 0;

        try {
            int workingDays = Integer.parseInt(parts[0]);
            int workingHours = Integer.parseInt(parts[1]);
            int workingMinutes = Integer.parseInt(parts[2]);

            milliseconds = convertToMilliseconds(workingDays, workingHours, workingMinutes);
            long days = milliseconds / (24 * 60 * 60 * 1000);
            long hours = (milliseconds % (24 * 60 * 60 * 1000)) / (60 * 60 * 1000);
            long minutes = (milliseconds % (60 * 60 * 1000)) / (60 * 1000);

            System.out.println("Total Milliseconds: " + milliseconds);
            System.out.println("Days: " + days);
            System.out.println("Hours: " + hours);
            System.out.println("Minutes: " + minutes);
        } catch (NumberFormatException e) {
            System.out.println("ERROR! Please enter valid numbers in the format D:H:M");
        }

        // Calculate end date with given milliseconds
        workingHoursInstance.calculateEndDate(milliseconds);

        System.out.println("Start Date: " + workingHoursInstance.getStartDate());
        System.out.println("End Date: " + workingHoursInstance.getEndDate());

        scanner.close();
    }

}
