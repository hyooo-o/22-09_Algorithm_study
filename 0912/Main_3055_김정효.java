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
 * @author kjh
 *
 */
public class Main_3055_김정효 {
	static int r, c, _min;
	static char map[][];
	static Queue<int[]> water = new LinkedList<>();
	static Queue<int[]> animal = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		_min = Integer.MAX_VALUE;
		
		for (int i = 0; i <r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
				
				if (map[i][j] == 'S') {
					animal.add(new int[] {i, j, 0});
				}else if (map[i][j] == '*') {
					water.add(new int[] {i, j});
				}
			}
		}
		
		bfs();
		System.out.println(_min == Integer.MAX_VALUE? "KAKTUS": _min);		// 이동할 수 없다면, "KAKTUS"   도착했다면, 최소 이동 거리 출력
	}
	
	private static void bfs() {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		while (!animal.isEmpty()) {
			// 1. 물 이동
			int len = water.size();
			for (int k = 0; k < len; k++) {
				int[] w = water.poll();
				int x = w[0];
				int y = w[1];
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx>=0 && ny>=0 && nx<r && ny<c) {
						if (map[nx][ny] == '.') {	// 비어있으면 물 확장
							map[nx][ny] = '*';
							water.add(new int[] {nx, ny});
						}
					}
				}
			}		
				
			// 2. 고슴도치 이동
			len = animal.size();
			for (int k = 0; k < len; k++) {
				int[] a = animal.poll();
				int x = a[0];
				int y = a[1];
				int cnt = a[2];
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx>=0 && ny>=0 && nx<r && ny<c) {
						if (map[nx][ny] == '.') {			// 2-1. 비어 있을 때만 이동
							animal.add(new int[] {nx, ny, cnt+1});
							map[nx][ny] = 'S';
						}else if (map[nx][ny] == 'D') {		// 2-2. 도착 시, while문 탈출
							_min = Math.min(_min, cnt+1);
							return;
						}
					}
				}
			}
		}
	}
}
