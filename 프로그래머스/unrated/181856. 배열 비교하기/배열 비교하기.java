import java.util.*;
class Solution {
    public int solution(int[] arr1, int[] arr2) {
        return arr1.length == arr2.length ?
        Arrays.stream(arr1).sum() == Arrays.stream(arr2).sum() ? 0 :
        Arrays.stream(arr1).sum() > Arrays.stream(arr2).sum() ? 1 : -1 :
        arr1.length>arr2.length ? 1 : -1;
    }
}