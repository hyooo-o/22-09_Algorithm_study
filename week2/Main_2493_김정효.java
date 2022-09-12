import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * BOJ 2493 탑 - (완성)
 * stack 사용 + 시간을 줄이기 위한 조건 설정
 * (실수)
 * 1. 시간초과: 0부터 자신의 전 인덱스까지 탐색한 후, stack에 넣어 줬음 (스택을 결과 저장용으로 사용)
 *   => 스택을 결과 저장으로 사용하는 것이 아닌, 탑을 넣어 탐색해주는 용도로 사용함. 단, 스택에 넣을 때 조건을 주어 탐색 빈도을 줄임
 * 2. 조건 부족: 탑의 높이가 같을 때도 탑을 만난 것으로 간주해야하는데 이를 고려하지 않았음.
 
 * @author kjh
 *
 */
public class Main_2493_김정효 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<int[]> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			int top = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()) {
				if (stack.peek()[1] >= top) {	// 자신보다 높은 탑을 만나면, 몇 번째 탑인지 출력하고, 자신을 스택에 넣고, 스택 탐색 종료
					sb.append(stack.peek()[0]).append(" ");
					break;
				}
				stack.pop();
			}
			if (stack.isEmpty()) {
				sb.append(0).append(" ");
			}
			stack.add(new int[] {i, top});
		}
		System.out.println(sb);
	}
}
