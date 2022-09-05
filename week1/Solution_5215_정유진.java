import java.util.Scanner;
 
public class Solution_5215_정유진 {
 
    static int N, L;
    static int[] T;
    static int[] K;
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int A = sc.nextInt();
        for(int a=1;a<=A;a++) {
            N = sc.nextInt();
            L = sc.nextInt();
            T = new int[N];
            K = new int[N];
            for(int n=0;n<N;n++) {
                ans = 0;
                T[n] = sc.nextInt();
                K[n] = sc.nextInt();
            }
            hamburger(0,0,0);
            sb.append("#").append(a).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
        sc.close();
    }
    static void hamburger(int idx, int t, int c) {
 
        if (c > L)
            return;
        if (idx == N) {
            ans = Math.max(t, ans);
            return;
        }
 
        hamburger(idx + 1, t + T[idx], c + K[idx]);
        hamburger(idx + 1, t, c);
    }
 
}
