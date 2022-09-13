import java.util.Scanner;

public class Main_1010_정유진 {
	static int [][]arr=new int[30][30];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int n;
			int r;
			n = sc.nextInt();
			r = sc.nextInt();
			System.out.println(comb1(r, n));
		}

		sc.close();
	}
	
	static int comb1(int a, int b){
		if(arr[a][b]>0){
			return arr[a][b];
		}
		if(a==b||b==0){
			return arr[a][b]=1;
		}
		return arr[a][b]=comb1(a-1,b-1)+comb1(a-1,b);
	}
}
