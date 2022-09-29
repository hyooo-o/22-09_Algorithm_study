import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = -1;
		int cnt = 1;
		
		while(true) {
			N = sc.nextInt();
			if(N == 0) {
				break;
			}
			ans = 0;
			int[][] arr = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int[][] temp = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					temp[i][j] = Integer.MAX_VALUE;
				}
			}
			bfs(0,0, arr, temp, N);
			sb.append("Problem ").append(cnt).append(": ").append(ans).append("\n");
			cnt++;
		}
		System.out.println(sb);
		sc.close();
	}
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static void bfs(int r, int c, int[][] arr, int[][] temp, int N) {
		Queue<P> q = new LinkedList<P>();
		q.add(new P(r, c));
		temp[0][0] = arr[0][0];
		while(!q.isEmpty()) {
			P p = q.poll();
					
			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx>=0 && nx<N && ny>=0 && ny<N) {
					if(temp[nx][ny] > temp[p.x][p.y] + arr[nx][ny]) {
						temp[nx][ny] = temp[p.x][p.y] + arr[nx][ny];
						q.add(new P(nx, ny));
					}
				}
			}
		}
		ans = temp[N-1][N-1];
	}
}
class P {
	int x;
	int y;
	P(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
