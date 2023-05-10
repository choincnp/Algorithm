import java.util.*;
class Solution {
    public int solution(int a, int b, int c, int d) {
		int answer = 0;
		HashMap<Integer, Integer> pocket = new HashMap<>();
		pocket.put(a, 1);
		addPocket(b, pocket);
		addPocket(c, pocket);
		addPocket(d, pocket);
		switch (pocket.size()){
			case 1:
				answer = a * 1111;
				break;
			case 2:
				int p = 0,q = 0;
				if (pocket.containsValue(3)){
					for (Map.Entry<Integer, Integer> entry : pocket.entrySet()) {
						if (entry.getValue() == 3){
							p = entry.getKey();
						} else q = entry.getKey();
					}
					answer = (int)Math.pow(10 * p + q, 2);
				}
				else {
					for (Map.Entry<Integer, Integer> entry : pocket.entrySet()) {
						if (p == 0)
							p = entry.getKey();
						else q = entry.getKey();
					}
					answer = (p+q) * Math.abs(p-q);
				}
				break;
			case 3:
                answer = 1;
				for (Map.Entry<Integer, Integer> entry : pocket.entrySet()) {
					if (entry.getValue() == 1){
						answer *= entry.getKey();
					}
				}
				break;
			case 4:
				int min = Integer.MAX_VALUE;
				for (Map.Entry<Integer, Integer> entry : pocket.entrySet()) {
					if (entry.getKey() < min)
						min = entry.getKey();
				}
				answer = min;
				break;
		}
		return answer;
	}
	public static void addPocket(int a, HashMap<Integer, Integer> pocket){
		if (pocket.containsKey(a))
			pocket.put(a, pocket.get(a) + 1);
		else
			pocket.put(a, 1);
	}
}