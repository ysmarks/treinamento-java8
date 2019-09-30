package datetime.test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DateTimeApiTest2 {

	public static void main(String[] args) {
		Instant instant = Instant.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("******Instante******");
		System.out.println(localDateTime);
		System.out.println(instant);
		System.out.println(instant.getEpochSecond());
		System.out.println(instant.getNano());
		System.out.println(Instant.ofEpochMilli(2090000000));
		System.out.println(Instant.ofEpochSecond(4, 1200000000));
		
		System.out.println("******Duration******");
		LocalDateTime dt = LocalDateTime.now();
		LocalDateTime dt2 = LocalDateTime.of(2019, 11, 23, 12, 00, 00);
		Duration d = Duration.between(dt, dt2);
		System.out.println(d);
		Duration d1 = Duration.ofDays(10);
		System.out.println(d1);
		
		System.out.println("******Period******");
		Period p = Period.between(dt.toLocalDate(), dt2.toLocalDate());
		Period p1 = Period.ofWeeks(40);
		System.out.println(p);
		System.out.println(p1);
		System.out.println(Period.between(LocalDate.now(), LocalDate.now().plusDays(p1.getDays())));
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now.until(now.plusDays(p1.getDays()), ChronoUnit.MONTHS));
		System.out.println("******ChronoUnit******");
		LocalDateTime aniver = LocalDateTime.of(1985, 1, 27, 13, 20, 10);
		System.out.println(ChronoUnit.DAYS.between(aniver, now));
		System.out.println(ChronoUnit.DECADES.between(aniver, now));
		System.out.println(ChronoUnit.WEEKS.between(aniver, now));
		System.out.println(ChronoUnit.MONTHS.between(aniver, now));
		System.out.println(ChronoUnit.YEARS.between(aniver, now));
		
	}
}
