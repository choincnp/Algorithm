import java.util.stream.*;
import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int[] value = new int[]{10000,100,1};
		int[][] rankScore = new int[rank.length][2];
		for (int i=0; i<rank.length; i++){
			rankScore[i][0] = rank[i];
			rankScore[i][1] = i;
		}
		Arrays.sort(rankScore, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		int sum = 0;
		int count = 0;
		for (int i=0; i<rankScore.length; i++){
			if (count == 3) break;
			if (attendance[rankScore[i][1]]){
				sum += value[count]*rankScore[i][1];
				count++;
			}
		}
		return sum;
    }
}