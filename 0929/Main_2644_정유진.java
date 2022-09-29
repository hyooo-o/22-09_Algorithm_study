import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int n, a, b, m;
	static int[][] arr;
	static int[] d;
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n+1][n+1];
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		d = new int[n+1];
		BFS(a, b);
		
		if(d[b] == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(d[b]);
		}
		sc.close();
	}
	private static void BFS(int s, int e) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(s);
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			if(temp==e) {
				break;
			}
			for (int i = 1; i <= n; i++) {
				if(arr[temp][i] == 1 && d[i] == 0) {
					d[i] = d[temp] + 1;
					q.offer(i);
				}
			}
		}
		
	}
}


