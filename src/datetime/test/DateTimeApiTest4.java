package datetime.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import datetime.classes.ObterProximoDiaUtil;

public class DateTimeApiTest4 {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
		
		/*
		 * date = date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
		 * System.out.println(date); System.out.println(date.getDayOfWeek());
		 */
		
		/*
		 * date = date.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
		 * System.out.println(date); System.out.println(date.getDayOfWeek());
		 */
		
		date = date.with(new ObterProximoDiaUtil());
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
				
	}
}
