import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * BOJ 3055 탈출
 * <조건>
 * 1. 매 분 마다
 * 	1) 고슴도치: 상하좌우 중 한 칸으로 이동.  2) 물: 상하좌우 확장
 *	 단, 고슴도치와 물은 돌 통과X
 * 2. 고슴도치는 물 찰 예정인 칸 이동X
 * 3. 물은 소굴로 이동X 
 * 
 * <출력>
 * - 고슴도치가 비버의 굴로 이동하기 위해 필요한 최소 시간
 * - 이동할 수 없다면, "KAKTUS"를 출력
 * 
 * <방법>
 * 1. 물을 먼저 이동시킨 후, 고슴도치 이동 (고슴도치는 물이 찰 예정인 곳에 이동 못하기 때문)
 * 2. 고슴도치는 이동 시, 자신이 있었던 자리를 '.'로 바꾸고, 자신의 이동거리를 더하면서 이동
 * @author kjh
 *
 */
public class Main_3055_김정효 {
	static int r, c;
	static char map[][];
	static Queue<Integer> water = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			map[i]  = str.toCharArray();
		}
		
		int start = 0;
		int end = 0;
		
		for (int i = 0; i <r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 'D') {
					start = i;
					end = j;
				}else if (map[i][j] == '*') {
					water.add(i);
					water.add(j);
				}
			}
		}
		
		dfs(start, end, 0);
		
	}
	
	private static void dfs(int x, int y, int cnt) {
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		while (true) {
			for (int k = 0; k < water.size(); k++) {
				// 1. 물 이동
				if ( !w(water.indexOf(k), water.indexOf(++k)) ) {	// 고슴도치 만나면 종료
					break;
				}
				
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx>0 && ny>0 && nx<r && ny<c) {
						// 2. 고슴도치 이동
						if (map[nx][ny] == '.') {	// 2-1. '.' 일 때만 이동
							dfs(nx, ny, cnt+1);
						}
						
						
						// 2-2. S 도착 시, while문 탈출
					}
				}
				
			}
		}
			
			
			
		
	}

	private static boolean w(int x, int y) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx>0 && ny>0 && nx<r && ny<c) {
				if (map[nx][ny] == '.') {	// 비어있으면 물 확장
					map[nx][ny] = '*';
					water.add(nx);
					water.add(ny);
				}else if (map[nx][ny] == 'D') {	// 고슴도치 만나면 종료
					return false;
				}
			}
		}
		return true;
	}

}
