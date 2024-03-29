import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int index = 0;
		ArrayList<String> arr = new ArrayList<>();
		for (int i=0; i<T; i++){
			String letter = br.readLine();
			if (letter.equals("?")){
				index = i;
			} else{
				arr.add(letter);
			}
		}
		char prev = ' ';
		char next = ' ';
		if (index > 0 && index <= arr.size()){ // arr.get(index-1)를 안전하게 호출하기 위한 조건 수정
			prev = arr.get(index-1).charAt(arr.get(index-1).length()-1);
		}
		if (index >= 0 && index < arr.size()){ // arr.get(index)를 안전하게 호출하기 위한 조건 수정
			next = arr.get(index).charAt(0);
		}
		T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++){
			String candidate = br.readLine();
			if ((prev == ' ' || prev == candidate.charAt(0)) && (next == ' ' || next == candidate.charAt(candidate.length() - 1))) {
				boolean flag = false;
				for (String check : arr){
					if (candidate.equals(check)){
						flag = true;
					}
				}
				if (!flag){
					System.out.println(candidate);
					break;
				}
			}
		}


	}
}
