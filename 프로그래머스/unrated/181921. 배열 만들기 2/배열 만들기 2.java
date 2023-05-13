import java.util.*;
class Solution {
    static ArrayList<Integer> arr = new ArrayList<>();
    
    public int[] solution(int l, int r) {
        DFS(5,l,r);
        Collections.sort(arr);
        return arr.size()==0? new int[]{-1} : arr.stream().mapToInt(i->i).toArray();
    }
    
    public static void DFS(int num, int l, int r){
		if (num > r) return;
		else if(num >= l) arr.add(num);
		for (int i=0; i<10; i++){
			if (i % 5 != 0) continue;
			if (i ==0 || i==5) DFS(num * 10 + i, l, r);
		}
	}
}