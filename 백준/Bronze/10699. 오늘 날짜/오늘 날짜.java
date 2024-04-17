import java.time.LocalDate;
import java.time.ZoneId;

public class Main {
	public static void main(String[] args) {
		System.out.println(LocalDate.now(ZoneId.of("UTC+9")));
	}
}
