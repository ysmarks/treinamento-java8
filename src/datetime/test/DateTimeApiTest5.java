package datetime.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeApiTest5 {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		String format = date.format(DateTimeFormatter.ISO_DATE);
		System.out.println(format);
		
		String parse = "2019-05-31";
		LocalDate parse2 = date.parse(parse, DateTimeFormatter.ISO_DATE);
		System.out.println(parse2);
		
		LocalDateTime dateTime = LocalDateTime.now();
		String format2 = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
		System.out.println(format2);
		
		String parse3 = "2019-05-31T21:19:01.363";
		LocalDateTime parse4 = dateTime.parse(parse3, DateTimeFormatter.ISO_DATE_TIME);
		System.out.println(parse4);
		
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String format3 = LocalDate.now().format(ofPattern);
		System.out.println(format3);
		
	}
}
