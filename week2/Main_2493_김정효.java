import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * BOJ 2493 탑 - (미완성: 시간초과)
 * @author kjh
 *
 */
public class Main_2493_김정효 {
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = n-1; i > 0; i--) {
			for (int j = i-1; j >= 0; j--) {
				if (arr[i] < arr[j]) {
					stack.add(j+1);
					break;
				}
				else {
					if (j == 0) {
						stack.add(0);
					}
				}
			}
		}
		stack.add(0);
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}
}
