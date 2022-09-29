import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int R;
	static int C;
	static int T;
	static int[][] arr;
	static LinkedList<Xy> q;
	static ArrayList<Xy> air;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		air = new ArrayList<>();
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == -1) {
					if(air.isEmpty()) {
						air.add(new Xy(i, j, 0));
					}
					else {
						air.add(new Xy(i, j, 1));
					}
				}
			}
		}
		for(int i=0;i<T;i++) {
			dust();
			mise();
			airOn();
		}
		countMise();
	}
	static void print() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static void dust() {
		q = new LinkedList<Xy>();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(arr[i][j] != 0 && arr[i][j] != -1) {
					q.add(new Xy(i, j, arr[i][j]));
				}
			}
		}
	}
	static void mise() {
		int size = q.size();
		for(int i=0;i<size;i++) {
			int temp = q.peek().n / 5;
			int cnt = 0;
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			if(x-1 >= 0 && arr[x-1][y] != -1) {
				cnt++;
				arr[x-1][y] += temp;
			}
			if(x+1 < R && arr[x+1][y] != -1) {
				cnt++;
				arr[x+1][y] += temp;
			}
			if(y+1 <C && arr[x][y+1] != -1) {
				cnt++;
				arr[x][y+1] += temp;
			}
			if(y-1 >= 0 && arr[x][y-1] != -1) {
				cnt++;
				arr[x][y-1] += temp;
			}
			arr[x][y] -= temp * cnt;
		}
	}
	static void airOn() {
		int x1 = air.get(0).x;
		int x2 = air.get(1).x;

		for(int i=x1;i>=1;i--) {
			if(arr[i][0] == -1) {
				continue;
			}
			else {
				arr[i][0] = arr[i-1][0];
			}
		}
		for(int i=x2;i<R-1;i++) {
			if(arr[i][0] == -1) {
				continue;
			}
			else {
				arr[i][0] = arr[i+1][0];
			}
		}
		for(int j=0;j<C-1;j++) {
			arr[0][j] = arr[0][j+1];
		}
		for(int j=0;j<C-1;j++) {
			arr[R-1][j] = arr[R-1][j+1];
		}
		for(int i=0;i<=x1;i++) {
			arr[i][C-1] = arr[i+1][C-1];
		}
		for(int i=R-1;i>x2;i--) {
			arr[i][C-1] = arr[i-1][C-1];
		}
		for(int i=x1;i<=x2;i++) {
			for(int j=C-1;j>=1;j--) {
				if(arr[i][j-1] == -1) {
					arr[i][j] = 0;
				}
				else {
					arr[i][j] = arr[i][j-1];
				}
			}
		}
	}
	static void countMise() {
		int c = 0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(arr[i][j] != -1) {
					c += arr[i][j];
				}
			}
		}
		System.out.println(c);
	}

}
class Xy {
	int x, y, n;
	public Xy(int x, int y, int n) {
		super();
		this.x = x;
		this.y = y;
		this.n = n;
	}
}
