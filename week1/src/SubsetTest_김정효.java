import java.util.Scanner;

public class SubsetTest_김정효 {
	static boolean[] visit;
	static int[] arr;
	static int n, total;
	// n개의 수를 입력받았을 때
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();			// 2
		visit = new boolean[n];
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();			// 1, 2
		}

		subset(0);
		System.out.println(total);
	}

	private static void subset(int index) {		//1
		if(index == n) {
			total++;
			for (int i = 0; i < n; i++) {
				if (visit[i]){
					System.out.print(arr[i]);
				}
			}
			System.out.println();
			return;
		}

		// 원소를 선택했을 때
		// {1, 2} ->  [], {1, X}, {X, 2}, {1, 2}
		visit[index] = true;		// 1, 2
		subset(index+1);
		// 원소를 선택하지 않았을 때
		visit[index] = false;		// 1, X 
		subset(index+1);
	}

}
