import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * BOJ 2961. 도영이가 만든 맛있는 음식
 * 부분집합 이용
 * (실수)
 * - (line 36) 원소가 하나도 없을 때를 고려하지 않았었음
 * @author kjh
 *
 */
public class Main_2961_김정효 {
	static int n, arr[][], _min;
	static boolean[] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		visit = new boolean[n];
		_min = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		subset(0, 0, 1, 0);
		System.out.println(_min);

	}
	
	private static void subset(int index, int cnt, int mul, int sum) {
		if (cnt == n) {
			if (sum != 0) {		// 이 조건 안넣어서 실패했었음
				int result = Math.abs(mul-sum);
				_min = Math.min(_min, result);
			}
			return;
		}
		// 원소 선택
		visit[index] = true;
		subset(index+1, cnt+1, mul*arr[index][0], sum+arr[index][1]);
		// 원소 미선택
		visit[index] = false;
		subset(index+1, cnt+1, mul, sum);
	}

}
