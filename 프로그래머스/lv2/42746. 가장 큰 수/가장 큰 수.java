import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(int[] arr) {
        StringBuilder sb = new StringBuilder();
		String[] strArr = new String[arr.length];
		for(int i=0; i<arr.length; i++){
			strArr[i] = String.valueOf(arr[i]);
		}
		Arrays.sort(strArr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
		});
		if(strArr[0].equals("0")){ // 이걸 생각못함
			return "0";
		}
		Arrays.stream(strArr).forEach(s -> sb.append(s));
		return sb.toString();
    }
}