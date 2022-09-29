package M10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2667_정유진 {

	static int N;
	static int[][] map;
	static int[][] temp;
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		temp = new int[N][N];
		int danji = 0;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = (int) (str.charAt(j) - '0');
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					danji++;
					visited[i][j] = true;
					temp[i][j] = danji;
					dfs(i, j, danji);
				}
			}
		}

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if(visited[i][j] == true) {
//					System.out.print(1);
//				}
//				else {
//					System.out.print(0);
//				}
//			}
//			System.out.println();
//		}

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(temp[i][j]);
//			}
//			System.out.println();
//		}

		System.out.println(danji);

		int[] arr = new int[danji + 1];

		for (int j2 = 1; j2 <= danji; j2++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (temp[i][j] == j2) {
						arr[j2] += 1;
					}
				}
			}
		}
		Arrays.sort(arr);
		for (int i = 1; i < danji + 1; i++) {
			System.out.println(arr[i]);
		}
	}

	private static void dfs(int x, int y, int danji) {
		int nx;
		int ny;
		for (int d = 0; d < 4; d++) {
			nx = x + delta[d][0];
			ny = y + delta[d][1];
			if (nx >= 0 && ny < N && nx < N && ny >= 0 && visited[nx][ny] != true && map[nx][ny] == 1) {
				visited[nx][ny] = true;
				temp[nx][ny] = danji;
				dfs(nx, ny, danji);
			}
		}
	}

}
