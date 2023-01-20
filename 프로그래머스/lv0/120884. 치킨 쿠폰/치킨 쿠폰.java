class Solution {
    public int solution(int chicken) {
        if (chicken < 10) return 0;
        else {
            int service = (chicken-10)/9 +1;
            return service;    
        }
    }
}