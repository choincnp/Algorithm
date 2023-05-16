class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder sb = new StringBuilder();
		sb.append(my_string);
		for (int i : indices) sb.replace(i, i+1, " ");
		return sb.toString().replaceAll(" ", "");
    }
}