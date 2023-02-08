class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        for (int i=0;i<num;i++){
            if(num%2==0){
                answer[i] = (total/num)+i-((num-1)/2);
            }
            else answer[i] = (total/num)+i-(num/2);
        }
        return answer;
    }
}