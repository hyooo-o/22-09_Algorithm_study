import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;
/**
 * SWEA 3289 서로소 집합 (미완성)
 * @author jeonghyo
 *
 */
public class Solution_3289_김정효 {
	static class Edge {
		int from, to;

		public Edge(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}
		
	}
	
	static Edge[] edgeList;
	static int[] parents;
	static int n, result;
	
	static void make() {
		parents = new int[n];
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			make();
			edgeList = new Edge[m];
			Arrays.sort(edgeList);
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int check = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				if (check == 0) union(edgeList[i].from, edgeList[i].to);
				else {
					if(find(edgeList[i].from) == find(edgeList[i].to)) sb.append("1");
					else sb.append("0");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
}
