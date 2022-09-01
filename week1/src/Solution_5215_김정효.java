import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * SWEA 5215 햄버거 다이어트 (완료)
 * 부분집합
 * (실수)
 * - 미선택일 때, 칼로리랑 점수는 더해주면 안됨
 * @author kjh
 *
 */
public class Solution_5215_김정효 {
	static int[][] arr;
	static int n, l, _max;
	static boolean[] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			arr = new int[n][2];
			visit = new boolean[n];
			_max = Integer.MIN_VALUE;
			
			for (int i = 0; i < n; i++) {	// (score, cal)
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());	// score
				arr[i][1] = Integer.parseInt(st.nextToken());	// cal
			}
			
			comb(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(_max).append("\n");
		}
		System.out.println(sb);
	}

	private static void comb(int index, int cal, int score) {
		if(cal > l) {
			return;
		}
			
		if (index == n) {
			_max = Math.max(_max, score);
			return;				
		}
		
		visit[index] = true;	// 선택
		comb(index+1, cal+arr[index][1], score+arr[index][0]);
		visit[index] = false;	// 미선택
		comb(index+1, cal, score);	// 미선택이므로 칼로리, 점수는 그대로
	}
}
