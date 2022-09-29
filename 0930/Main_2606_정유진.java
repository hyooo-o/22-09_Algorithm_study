import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2606_정유진 {
	static int V, E; // 컴퓨터 수, 간선 수
	static ArrayList<Integer>[] list;
	static boolean[] visited; // dfs는 갔던 곳 가면 안 되니까 필수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		list = new ArrayList[V + 1];
		visited = new boolean[V + 1];
		
		for (int i = 1; i < V+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		StringTokenizer st = null;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			list[n1].add(n2);
			list[n2].add(n1);
		}
		
		visited[1] = true;
		dfs(1);
		
		int cnt = 0;
		for (int i = 0; i < visited.length; i++) {
			if(visited[i]) cnt++;
		}
		
		System.out.println(cnt - 1);
	}
	private static void dfs(int v) {
		// 1. 가지치기
		// 모든 정점을 돌아야 해서 필요 없음
		
		// 2. 기저 조건
		// 모든 정점을 돌아야 해서 필요 없음
		// 다음 노드 찾을 때 체크하면 됨
		
		// 3. 다음 노드 구하기
		for (int i = 0; i < list[v].size(); i++) {
			int num = list[v].get(i);
			
			if(!visited[num]) {
				visited[num] = true;
				dfs(num);
//				vistied[num] = false; 또 안 갈거니까 필요 없음(한번 나오면 끝)
			}
		}
	}

}
