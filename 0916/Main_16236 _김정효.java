import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author kjh
 *
 */
public class Main_16236_김정효 {
	static char[][] arr;
	static int c1_x, c1_y, c2_x, c2_y;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		c1_x = c1_y = c2_x = c2_y = -1;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
				
				if (arr[i][j] == 'o') {
					if (c1_x == -1) {	
						c1_x = i;
						c1_y = j;
					}else {				
						c2_x = i;
						c2_y = j;
					}
				}
			}
		}
		bfs();
		
	}

	private static void bfs() {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		for (int k = 0; k < 4; k++) {
			int nx1 = c1_x + dx[k];
			int ny1 = c1_y + dy[k];
			int nx2 = c2_x + dx[k];
			int ny2 = c2_y + dy[k];
			
		}
		
		
	}

}
