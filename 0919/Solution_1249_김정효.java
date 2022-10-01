import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1249_김정효 {
	static int n, map[][], dp[][], min;
	static boolean[][] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			dp = new int[n][n];
			visit = new boolean[n][n];
			
			// 최소를 비교하면서 최솟값을 갱신해줘야 하기 때문에 dp배열을 max값으로 초기화해줌
			for (int i = 0; i < n; i++) {
				Arrays.fill(dp[i], Integer.MAX_VALUE);
			}
			
			dp[0][0] = 0;
			
			for (int i = 0; i < n; i++) {
				String[] str = br.readLine().split("");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}
			
			bfs();
			sb.append("#").append(tc).append(" ").append(dp[n-1][n-1]).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		q.add(new int[] {0, 0});
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			visit[x][y] = true;
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (nx>=0 && ny>=0 && nx<n && ny<n && !visit[nx][ny]) {
					visit[nx][ny] = true;
					dp[nx][ny] = Math.min(dp[nx][ny], dp[x][y]+map[nx][ny]);
					q.add(new int[] {nx, ny});
				}
			}
			
		}
	}

}
