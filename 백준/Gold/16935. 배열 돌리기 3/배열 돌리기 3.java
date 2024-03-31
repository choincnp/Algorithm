import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[][] field;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		field = new int[N][M];
		for (int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++){
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		while (T -- > 0){
			operation(Integer.parseInt(st.nextToken()));
		}
		for (int i=0; i<field.length; i++){
			for (int j=0; j<field[0].length; j++){
				sb.append(field[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void operation(int operator){
		int ni = field.length;
		int nj = field[0].length;
		int[][] newField;
		switch (operator){
			case 1:
				newField = new int[ni][nj];
				for (int i=0; i<ni; i++){
					for(int j=0; j<nj; j++){
						newField[i][j] = field[ni-i-1][j];
					}
				}
				field = newField;
				break;
			case 2:
				newField = new int[ni][nj];
				for (int i=0; i<ni; i++){
					for (int j=0; j<nj; j++){
						newField[i][j] = field[i][nj-j-1];
					}
				}
				field = newField;
				break;
			case 3:
				newField = new int[nj][ni];
				for (int i=0; i<ni; i++){
					for (int j=0; j<nj; j++){
						newField[j][ni-i-1] = field[i][j];
					}
				}
				field = newField;
				break;
			case 4:
				newField = new int[nj][ni];
				for (int i=0; i<ni; i++){
					for (int j=0; j<nj; j++){
						newField[nj-j-1][i] = field[i][j];
					}
				}
				field = newField;
				break;
			case 5:
				newField = new int[ni][nj];
				for (int i=0; i<ni; i++){
					for (int j=0; j<nj; j++){
						//1번 그룹 -> 4번이 와야함
						if (i < ni/2 &&  j < nj/2){
							newField[i][j] = field[i+ni/2][j];
						} else if (i < ni/2 && j >= nj/2){
							//2번 그룹 -> 1번이 와야함
							newField[i][j] = field[i][j-nj/2];
						} else if (i >= ni/2 && j < nj/2){
							//4번 그룹 -> 3번이 와야함
							newField[i][j] = field[i][j+nj/2];
						} else {
							//3번 그룹 -> 2번이 와야함
							newField[i][j] = field[i-ni/2][j];
						}
					}
				}
				field = newField;
				break;
			default:
				newField = new int[ni][nj];
				for (int i=0; i<ni; i++){
					for (int j=0; j<nj; j++){
						if (i < ni/2 && j<nj/2){
							newField[i][j] = field[i][j+nj/2];
						} else if (i < ni/2 && j >= nj/2){
							newField[i][j] = field[i+ni/2][j];
						} else if (i >= ni/2 && j < nj/2){
							newField[i][j] = field[i-ni/2][j];
						} else {
							newField[i][j] = field[i][j-nj/2];
						}
					}
				}
				field = newField;
				break;

		}

	}
}
