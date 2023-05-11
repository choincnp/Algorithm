class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int num = 0;
        for (int i=0; i<included.length; i++){
            num = a + d * i;
            if (included[i] == true) answer += num;
        }
        return answer;
    }
}