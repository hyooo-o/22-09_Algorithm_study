import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * BOJ 11286. 절댓값 힙
 * 우선순위 큐 이용
 * (실수)
 * - comparator 사용에 익숙해지기 => Comparator<T> 에 타입 안넣어 줘서 컴파일 오류 났었음
 * 
 * @author jeonghyo
 *
 */
public class Main_11286_김정효 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> lowestQ = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) == Math.abs(o2)) {
					return Integer.compare(o1, o2);
				}
				return Integer.compare(Math.abs(o1), Math.abs(o2));
			}
		});
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int data = Integer.parseInt(br.readLine());
			if(data != 0) lowestQ.add(data);
			else {
				if (lowestQ.isEmpty()) {
					sb.append("0").append("\n");
				}
				else {
					sb.append(lowestQ.poll()).append("\n");
					
				}
			}
		}
		System.out.println(sb);
	}
		
}
