class Solution {
    public int[] solution(int brown, int yellow) {
        int height = 1;
        for (int i=1 ; i<=yellow/2; i++){
            if (yellow % i == 0){
                height = i;
                if (brown + yellow == (i+2)*(yellow/i + 2)) break;
            }
        }
        return new int[]{yellow/height+2, height+2};
    }
}