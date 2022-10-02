package algo;

import java.util.Scanner;

public class Solution_5215_송보미 {
	
	static int N;
	static int L;
	static int[] score;
	static int[] cal;
	static int ans;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1; i<=T; i++) {
			
			N = sc.nextInt();
			L = sc.nextInt();
			score = new int[N];
			cal = new int[N];
			ans = 0;
			
			for(int j=0; j<N; j++) {
				
				score[i] = sc.nextInt();
				cal[i] = sc.nextInt();
				
			}
			
			// 재료개수, 점수합, 칼로리 모두 0으로 시작
			ham(0, 0, 0);
			
			System.out.println("#" + i + " " + ans);
		}

	}
	
	public static void ham(int cnt, int sum, int c) {
		
		// 제한 칼로리보다 클때
		if(c > L) return;
		
		
		// N개의 재료를 뽑았을때 점수 비교
		if(cnt == N) {
			
			ans = Math.max(ans, sum);
			return;
		
		}
		
		// 재료수 + 1, 점수, 칼로리 합
		ham(cnt+1, sum + score[cnt], c+cal[cnt]);
		
		// 재료 빼기
		ham(cnt+1, sum, c);
	}

}
