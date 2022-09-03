import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * BOJ 1010 다리놓기
 * m(r)개 중에 n(c)개 선택하는 그냥 조합으로 풀면 시간 초과 발생 => 배열에 이전 결과 저장하여 반복 계산 작업을 줄여줌
 * rCc == (r-1)Cc + (r-1)C(c-1) 활용
 * @author kjh
 *
 */
public class Main_1010_김정효 {
	static int[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dp = new int[31][31];	// n, m < 30
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			comb(m, n);
		}
	}

	private static int comb(int r, int c) {
		if (c == 0 || c == r) return dp[r][c] = 1;		// rC0 또는 rCr 이면 1 대입
		
		else if (c > r/2) return dp[r][c]; 				// r/2를 기준으로 앞에 했던 연산이 뒤에 할 연산과 중복됨
		
		else return comb(r-1, c)+comb(r-1, c-1);		// rCc == (r-1)Cc + (r-1)C(c-1)
	}

}
