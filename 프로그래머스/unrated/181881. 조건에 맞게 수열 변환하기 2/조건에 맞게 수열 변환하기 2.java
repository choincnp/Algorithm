class Solution {
    public int solution(int[] arr) {
        int result = 0;
        while (true){
            int count = 6;
            for (int i=0; i<arr.length; i++){
                if (arr[i] >= 50 && arr[i]%2 == 0) {
                    arr[i] /= 2;
                    count--;
                }
                else if (arr[i] < 50 && arr[i]%2 == 1){
                    arr[i] = arr[i] * 2 + 1;
                    count--;
                }
            }
            if (count == 6 ) break;
            result++;
        }
        return result;
    }
}