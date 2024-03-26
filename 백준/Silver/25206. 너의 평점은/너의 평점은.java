import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double creditSum = 0;
		double markSum = 0;
		for (int i=0; i<20; i++){
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			double credit = Double.parseDouble(st.nextToken());
			String mark = st.nextToken();
			if (!mark.equals("P")){
				switch (mark){
					case "F" :
						markSum += 0.0;
						break;
					case "A+":
						markSum += credit * 4.5;
						break;
					case "A0":
						markSum += credit * 4.0;
						break;
					case "B+":
						markSum += credit * 3.5;
						break;
					case "B0":
						markSum += credit * 3.0;
						break;
					case "C+":
						markSum += credit * 2.5;
						break;
					case "C0":
						markSum += credit * 2.0;
						break;
					case "D+":
						markSum += credit * 1.5;
						break;
					case "D0":
						markSum += credit;
						break;
					default:
						break;
				}
				creditSum += credit;
			}
		}
		System.out.printf("%.6f", markSum/creditSum);
	}
}