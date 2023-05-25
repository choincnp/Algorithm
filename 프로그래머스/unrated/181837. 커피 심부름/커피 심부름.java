import java.util.stream.*;
import java.util.*;
class Solution {
    public int solution(String[] order) {
        return Arrays.stream(order).map(i -> {
			int price = 0;
			if (i.contains("americano") || i.contains("anything")){
				price += 4500;
			} else if (i.contains("cafelatte")){
				price += 5000;
			}
			return price;
		}).reduce(0, Integer::sum).intValue();
    }
}