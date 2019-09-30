package datetime.test;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateTimeApiTest3 {
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.of(2017, 12, 14);
		System.out.println(localDate);
		localDate = localDate.withYear(2019);
		System.out.println(localDate);
		localDate = localDate.plusYears(2);
		System.out.println(localDate);
		
		LocalTime time = LocalTime.now();
		System.out.println(time);
		time = time.withHour(10);
		System.out.println(time);
		time = time.plusHours(15);
		System.out.println(time);
	}

}
