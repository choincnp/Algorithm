import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine(); //문자열
		int q = Integer.parseInt(br.readLine()); //질문 수
		int l=s.length();
		
		//누적합 기록을 위한 배열 선언
		int[][] memos = new int[l+1][26];
		//처음 값 횟수 증가
		memos[1][s.charAt(0)-'a']++;
		//나머지 문자 탐색
		for(int i=2;i<=l;i++) {
			//탐색 중인 문자
			int idx = s.charAt(i-1)-'a';
			//알파벳(a-z)탐색
			for(int j=0;j<26;j++) {
				//알파벳의 이전 누적 합
				int before = memos[i-1][j];
				//알파벳과 탐색 중인 문자가 같으면 이전값+1, 아니면 이전값과 같음
				memos[i][j]=j==idx?before+1:before;
			}
		}
		//문제 읽기
		StringTokenizer st;
		for(int i=0;i<q;i++) {
			st=new StringTokenizer(br.readLine());
			//문제 문자
			int idx=st.nextToken().charAt(0)-'a';
			//시작점
			int start=Integer.parseInt(st.nextToken())+1;
			//끝점
			int end=Integer.parseInt(st.nextToken())+1;
			//끝점의 누적합 - 시작점 바로 이전의 누적합 = 구간의 문자 반복값
			bw.append((memos[end][idx]-memos[start-1][idx])+"\n");
		}
		bw.close();
		br.close();
	}
}