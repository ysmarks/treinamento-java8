package datetime.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeApiTest {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2016, 2, 14);
		LocalDate date2 = LocalDate.now();
		LocalDate date3 = LocalDate.MIN;
		System.out.println("******LocalDate******");
		System.out.println(date.getYear());
		System.out.println(date.getMonthValue());
		System.out.println(date.getMonth());
		System.out.println(date.getDayOfMonth());
		System.out.println(date.getDayOfYear());
		System.out.println(date2);
		System.out.println(date3);
		System.out.println(LocalDate.MAX);
		System.out.println("*****LocalTime*****");
		LocalTime time = LocalTime.of(17, 56, 20);
		System.out.println(time.getHour());
		System.out.println(LocalTime.now());
		System.out.println("*****LocalDateTime*****");
		LocalDateTime localDateTime = LocalDateTime.of(2018, 11, 19, 8, 20, 25);
		System.out.println(localDateTime);
		System.out.println(localDateTime.now());
	}
}
