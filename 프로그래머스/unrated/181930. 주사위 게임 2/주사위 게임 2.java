import java.util.*;
class Solution {
    public int solution(int a, int b, int c) {
        HashMap<Integer, Integer> dice = new HashMap<>();
		int answer = 0;
		dice.put(a, dice.getOrDefault(a,0) +1);
		dice.put(b, dice.getOrDefault(b,0) +1);
		dice.put(c, dice.getOrDefault(c,0) +1);
		switch (dice.size()){
			case 3:
				answer = a+b+c;
				break;
			case 2:
				answer = (a+b+c) * (int)(Math.pow(a,2)+Math.pow(b,2)+Math.pow(c,2));
				break;
			case 1:
				answer = (3*a) * (int)(3 * Math.pow(a,2)) * (int)(3 * Math.pow(a,3));
				break;
		}
		return answer;
    }
}