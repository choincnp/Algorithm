import java.util.*;
class Solution {
    public ArrayList solution(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i=2;i<=n; i++){
            if (n%i==0 && isPrime(i)){
                arr.add(i);
            }
        }
        return arr;
    }
    static boolean isPrime(int n){
        for (int i=2;i<=Math.sqrt(n);i++){
            if (n%i==0) return false;
        }
        return true;
    }
}

