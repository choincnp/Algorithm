import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
		int[] stock = new int[n+1];
		Arrays.fill(stock, 1);
		for (int i=0; i<reserve.length; i++){
			stock[reserve[i]]++;
		}
		for (int i=0; i<lost.length; i++){
			stock[lost[i]]--;
		}
		for (int i=1; i<stock.length; i++){
			if (stock[i] == 2){
				if (i != 1 && stock[i-1] == 0){
					stock[i-1]++;
				} else if (i != stock.length-1 && stock[i+1] == 0){
					stock[i+1]++;
				}
			}
		}
		for (int i=1; i<=n; i++){
			if (stock[i] == 0){
				answer--;
			}
		}
		return answer;
    }
}