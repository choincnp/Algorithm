import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		calculateTime(month, day);
		System.out.println(sb.toString());
	}

	static void calculateTime(int month, int day){
		LocalDate start = LocalDate.of(2007, 1, 1);
		LocalDate end = LocalDate.of(2007, month, day);
		long days = ChronoUnit.DAYS.between(start, end);
		switch ((int)days%7){
			case 1:
				sb.append("TUE");
				break;
			case 2:
				sb.append("WED");
				break;
			case 3:
				sb.append("THU");
				break;
			case 4:
				sb.append("FRI");
				break;
			case 5:
				sb.append("SAT");
				break;
			case 6:
				sb.append("SUN");
				break;
			default:
				sb.append("MON");
				break;
		}
	}
}