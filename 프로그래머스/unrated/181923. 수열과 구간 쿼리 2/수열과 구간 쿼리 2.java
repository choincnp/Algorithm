class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for (int i=0; i<queries.length; i++){
            int a = queries[i][0];
            int b = queries[i][1];
            int min = Integer.MAX_VALUE;
            for (int j=a; j<=b; j++){
                if (arr[j] > queries[i][2] && arr[j] < min){
                    min = arr[j];
                }
            }
            answer[i] = (min == Integer.MAX_VALUE) ? -1 : min;
        }
        return answer;
    }
}