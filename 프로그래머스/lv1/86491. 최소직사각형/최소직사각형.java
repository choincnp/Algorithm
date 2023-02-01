class Solution {
    public int solution(int[][] sizes) {
        int max=0, min = 0;
        for(int i=0; i<sizes.length; i++){
            if (sizes[i][0]<sizes[i][1]){
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
            if (sizes[i][0]>max) max = sizes[i][0];
            if (sizes[i][1]>min) min = sizes[i][1];
        }
        return max*min;
    }
}