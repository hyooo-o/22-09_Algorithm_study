import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 미완성 ㅠㅠ
public class Main_16929_김정효 {
	static char[][] arr;
	static int n, m;
	static boolean[][] visit;
	static String result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		visit = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			String c = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = c.charAt(j);
			}
		}
		result = "NO";
		dfs(0, 0);
		System.out.println(result);
	}

	private static void dfs(int x, int y) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		visit[x][y] = true;
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (nx>=0 && ny>=0 && nx<n && ny<m) {
				if (arr[nx][ny] == arr[x][y]) {
					if(!visit[nx][ny])	dfs(nx, ny);
					else {
						result="YES";
						return;
					}
				}
			}
		}
		
	}

}
