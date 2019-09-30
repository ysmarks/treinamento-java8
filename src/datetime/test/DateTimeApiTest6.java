package datetime.test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Map;

public class DateTimeApiTest6 {

	public static void main(String[] args) {
		for (Map.Entry<String, String> zonas : ZoneId.SHORT_IDS.entrySet()) {
			System.out.println(zonas.getKey() + " " + zonas.getValue());
		}
		
		System.out.println("*******************");
		System.out.println(ZoneId.systemDefault());
		
		ZoneId tokyo = ZoneId.of("Asia/Tokyo");
		System.out.println(tokyo);
		
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
		ZonedDateTime atZone = dateTime.atZone(tokyo);
		System.out.println(atZone);
		
		Instant instant = Instant.now();
		System.out.println(instant);
		ZonedDateTime atZone2 = instant.atZone(tokyo);
		System.out.println(atZone2);
		
		ZoneOffset manaus = ZoneOffset.of("-04:00");
		LocalDateTime dateTime2 = LocalDateTime.now();
		OffsetDateTime offset = OffsetDateTime.of(dateTime2, manaus);
		System.out.println(offset);
	}
}
