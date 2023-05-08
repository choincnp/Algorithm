class Solution {
public String solution(String p) {
    String answer = "";
		if (p.length()==0) return answer;

		String u = "";
		String v = "";
		int lCnt = 0;
		int rCnt = 0;
		for (int i=0; i<p.length(); i++){
			// if (p.charAt(0) == ')') {
			// 	v = p;
			// 	break;
			// }
			if(p.charAt(i) == '('){
				lCnt++;
			}else rCnt++;
			u += p.charAt(i);
			if(lCnt == rCnt){
				v = p.substring(i+1);
				break;
			}
		}
		if (isRight(u)){
			return u += solution(v);
		} else {
			String tmp = "(";
			tmp += solution(v);
			tmp += ")";
			u = u.substring(1, u.length()-1);
			for (int i=0; i<u.length(); i++){
				if (u.charAt(i) == '(') tmp += ")";
				else tmp += "(";
			}
			return tmp;
		}
	}

	public static boolean isRight(String u){
		int cnt = 0;
		for (int i=0; i<u.length(); i++){
			if (u.charAt(i) == '(') cnt++;
			else cnt--;
			if (cnt < 0) return false;
		}
		return true;
	}
}