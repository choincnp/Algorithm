import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder left = new StringBuilder();
		Map<Character, Integer> map = new TreeMap<>();
		char[] letters = br.readLine().toCharArray();
		for (char letter : letters){
			map.put(letter, map.getOrDefault(letter, 0)+1);
		}
		char mid = ' ';
		for (Map.Entry<Character, Integer> entry : map.entrySet()){
			char k = entry.getKey();
			int v = entry.getValue();
			// 홀수개의 문자가 2개 이상이면 팰린드롬 안만들어짐
			if (v%2 == 1){
				if (mid != ' '){
					System.out.println("I'm Sorry Hansoo");
					return;
				} else {
					mid = k;
				}
			}
			// 팰린드롬 왼쪽 만들기
			for (int i = 0; i< v/2 ; i++){
				left.append(k);
			}
		}
		String right = left.reverse().toString();
		// right에서 StringBuilder reverse 1번 줬으므로 다시 reverse
		System.out.println(left.reverse().toString() + (mid == ' ' ? "" : mid) + right);

	}
}
