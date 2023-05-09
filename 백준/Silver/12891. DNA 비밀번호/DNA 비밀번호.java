import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int checkArr[];
	static int myArr[];
	static int checkSecret;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int total = Integer.parseInt(st.nextToken());
		int part = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		char[] totalArr = new char[total];
		checkArr = new int[4];
		myArr = new int[4];
		int count = 0;
		checkSecret = 0;
		totalArr = st.nextToken().toCharArray();
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<4; i++){
			checkArr[i] = Integer.parseInt(st.nextToken());
			if (checkArr[i] == 0)
				checkSecret++;
		}
		for (int i=0; i<part; i++){
			Add(totalArr[i]);
		}
		if (checkSecret == 4) count++;
		for (int i= part; i<total; i++){
			Add(totalArr[i]);
			Remove(totalArr[i-part]);
			if (checkSecret == 4) count++;
		}
		System.out.println(count);
	}
	public static void Add(char c){
		switch (c){
			case 'A':
				myArr[0] ++;
				if (myArr[0] == checkArr[0]) checkSecret++;
				break;
			case 'C':
				myArr[1] ++;
				if (myArr[1] == checkArr[1]) checkSecret++;
				break;
			case 'G':
				myArr[2] ++;
				if (myArr[2] == checkArr[2]) checkSecret++;
				break;
			case 'T':
				myArr[3] ++;
				if (myArr[3] == checkArr[3]) checkSecret++;
				break;
		}
	}
	public static void Remove(char c){
		switch (c){
			case 'A':
				if (myArr[0] == checkArr[0]) checkSecret--;
				myArr[0] --;
				break;
			case 'C':
				if (myArr[1] == checkArr[1]) checkSecret--;
				myArr[1] --;
				break;
			case 'G':
				if (myArr[2] == checkArr[2]) checkSecret--;
				myArr[2] --;
				break;
			case 'T':
				if (myArr[3] == checkArr[3]) checkSecret--;
				myArr[3] --;
				break;
		}
	}
}
