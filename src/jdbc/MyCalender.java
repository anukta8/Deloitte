package jdbc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class MyCalender {
	
	
	public static void countDays(String date)
	{
		int numDays = 0;
		LocalDate today = LocalDate.now();
		int thisyear = today.getYear();
		int thismonth = today.getMonthValue();
		int thisday = today.getDayOfMonth();
		
		System.out.println(thisyear+":"+thismonth+":"+thisday);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");		
		LocalDate futureDate = LocalDate.from(dtf.parse(date));
		int futureyear = futureDate.getYear();
		int futuremonth = futureDate.getMonthValue();
		int futureday = futureDate.getDayOfMonth();
		
		
		System.out.println(futureyear+":"+futuremonth+":"+futureday);

		
		System.out.println("-----using chromaunits-------");
		long intervalDays = ChronoUnit.DAYS.between(today, futureDate);
	    System.out.println("Total number of days for Nilli's bday!:" + intervalDays);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		
		int yr= cal.get(Calendar.YEAR);
		int mon = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DATE);
	
		System.out.println(day+":"+(mon+1)+":"+yr);
		
		Date dt = new Date();
		long millis = dt.getTime();
		Calendar calndr = Calendar.getInstance();
		calndr.setTime(dt);
		calndr.setTimeInMillis(millis);
		
		LocalDate ld = LocalDate.now();
		System.out.println(ld);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");		
		System.out.println(dtf.format(ld));
		
		countDays("08-02-2020");
			
		}

}
