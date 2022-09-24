import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * BOJ 17135 캐슬디펜스 - 구
 * 궁수(3명): 동시에 D이하 거리에서 가장 가까운 왼쪽 적 공격 
 * 적: 아래로 이동, 성 도착 시, 공격 받을 시 종료
 * 출력) 제거할 수 있는 적의 최대 수
 * 
 * D=1 이면, 1의 개수가 많은 열 3개 뽑아서 해당 열의 1의 개수 구하기 
 * 
 * @author jeonghyo
 *
 */
public class Main_17135_김정효 {
	static int n, m, d, map[][], data[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		data = new int[3];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0, 0);
	}

	private static int attack(int[] arr) {
		for (int i = n-1; i >= 0; i++) {
			
		}
		return null;
	}

	private static void comb(int index, int cnt) {
		if (cnt == 3) {
			attack(data);
			return;
		}
		
		for (int i = index; i < m; i++) {
			data[index] = i;
			comb(index+1, cnt+1);
		}
	}
	
	

}
