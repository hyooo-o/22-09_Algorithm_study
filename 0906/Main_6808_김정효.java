import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * SWEA 6808 규영이와 인영이의 카드게임
 * 순열 (팩토리얼)
 * @author multicampus
 *
 */
public class Solution {

	static int d_sum, a_sum, lose, win;
	static boolean isSelected[];
	static int[] arr, numbers;
	static ArrayList<Integer> data;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=t; i++) {
			arr = new int[9];
			data = new ArrayList<>();
			for(int j=1; j<=18; j++) {
				data.add(j);			//{2, 4, 6, 8, 10, 12, 14, 16, 18}
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				data.remove(Integer.valueOf(arr[j]));
			}//---------- 카드 입력 완료 -----------
			isSelected = new boolean[9];		// false
			numbers = new int[9];
			lose=0; win=0;
			recursive(0);
			sb.append("#").append(i).append(" ").append(win).append(" ").append(lose).append("\n");
		}System.out.println(sb);

	}
	
	public static void recursive(int cnt) {
		if(cnt == 9) {
			for(int i=0; i<9; i++) {
				if(numbers[i] > arr[i]) {
					d_sum += numbers[i] + arr[i];
				}else {
					a_sum += numbers[i] + arr[i];
				}
			}
			if(d_sum > a_sum) {
				lose += 1;
			}else if(d_sum < a_sum) {
				win += 1;
			}
			d_sum = 0;
			a_sum = 0;
		}
		else {
			for(int i=0; i<9; i++) {
				if(isSelected[i]) {
					continue;
				}
				numbers[cnt] = data.get(i);
				isSelected[i] = true;
//				if(numbers[cnt] > arr[cnt]) {
//					d_sum += numbers[cnt] + arr[cnt];
//				}else {
//					a_sum += numbers[cnt] + arr[cnt];
//				}
				recursive(cnt+1);
				isSelected[i] = false;
			}
		}
		
	}

}
