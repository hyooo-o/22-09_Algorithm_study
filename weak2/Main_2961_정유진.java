import java.util.Scanner;

public class Main {

	static int[] S;
	static int[] B;
	static int N;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = new int[N];
		B = new int[N];
		for(int i=0;i<N;i++) {
			ans = 0;
			S[i] = sc.nextInt();
			B[i] = sc.nextInt();
		}
		ans = Integer.MAX_VALUE;
		jja(0,0,1,0);
		System.out.println(ans);
		sc.close();

	}
	static void jja(int cnt, int idx, int s, int b) {
		if (idx == N) {
			if(cnt!=0) {
				ans = Math.min(Math.abs(s-b), ans);
			}
			return;
		}
		jja(cnt, idx+1, s, b);
		jja(cnt + 1, idx+1, s * S[idx], b + B[idx]);
	}
}
