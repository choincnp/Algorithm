import java.util.*;
class Solution {
    static int[] arr;
    public int solution(int[] num_list, int n) {
    arr = num_list;
		Arrays.sort(arr);
		return binarySearch(n);
	}
	public static int binarySearch(int n){
		int left = 0;
		int right = arr.length - 1;
		int mid = 0;
		while(left <= right){
			mid = (left + right) / 2;
			if(arr[mid] == n){
				return 1;
			}
			else if(arr[mid] > n){
				right = mid - 1;
			}
			else{
				left = mid + 1;
			}
		}
		return 0;
	}
}