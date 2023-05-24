class Solution {
    public String solution(String a, String b) {
        int exceed = 0;
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<(int)Math.max(a.length(), b.length()); i++){
			int aNum = 0;
			int bNum = 0;
			if (i < a.length()){
				aNum = a.charAt(a.length()-1-i) - '0';
			}
			if (i < b.length()){
				bNum = b.charAt(b.length()-1-i) - '0';
			}
			int sum = aNum + bNum + exceed;
			exceed = sum / 10;
			sb.append(sum % 10);
		}
        if (exceed==1) sb.append(1);
		return sb.reverse().toString();
    }
}