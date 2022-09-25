import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_김정효 {
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		binarySearch((int) Math.pow(2, n), r, c);
		System.out.println(cnt);
	}
	
	private static void binarySearch(int size, int r, int c) {
		int mid = size / 2;
		if (size == 1) return;
		else if (r < mid && c < mid) {	// 1사분면
			binarySearch(mid, r, c);
		}else if (r < mid && c >= mid) {	// 2사분면
			cnt += (size*size) / 4;
			binarySearch(mid, r, c-mid);
		}else if (r >= mid && c < mid) {	// 3사분면
			cnt += (size*size/4) * 2;
			binarySearch(mid, r-mid, c);
		}else if (r >= mid && c >= mid) {	// 4사분면
			cnt += (size*size/4) * 3;
			binarySearch(mid, r-mid, c-mid);
		}
	}

}
