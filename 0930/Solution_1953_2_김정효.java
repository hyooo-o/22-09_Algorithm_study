import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * SWEA 1953 탈주범 검거 - (dfs 이용)
 
 * @author kjh
 *
 */
public class Solution_1953_2_김정효 {
	static int n, m, l, r, c, cnt, map[][];
	static int[] dx = {-1, 0, 0, 1};		// 상, 좌, 우, 하
	static int[] dy = {0, -1, 1, 0};
	static int[][] types = {		// 각 7종류가 갈 수 있는 방향
			{},
			{0, 1, 2, 3},
			{0, 3},
			{1, 2},
			{0, 2},
			{2, 3},
			{1, 3},
			{0, 1}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			map = new int[n][m];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(r, c, l, new int[n][m]);
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int x, int y, int L, int[][] visit) {
		if (L == 0) return;
		
		// 먼저 체크 후, 방문 처리
		// 처음 방문이라면
		if (visit[x][y] == 0) cnt++;
		visit[x][y] = L;	// 방문 처리
		
		// 자식 탐색
		int[] cur = types[map[x][y]];
		for (int d : cur) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if (nx>=0 && ny>=0 && nx<n && ny<m && visit[nx][ny]!=0 && connection(3-d, types[map[nx][ny]])) {
				dfs(nx, ny, L-1, visit);
			}
		}
	}

	// 통로가 연결되어 있는지 확인
	private static boolean connection(int d, int[] t_arr) {
		for (int j : t_arr) {
			if (j == d) return true;
		}
		return false;
	}
}
