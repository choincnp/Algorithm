class Solution {
    public String solution(int q, int r, String code) {
        StringBuilder sb = new StringBuilder();
		int i=0;
		while(q*i + r < code.length()){
			sb.append(code.charAt(q*i + r));
			i++;
		}
		return sb.toString();
    }
}