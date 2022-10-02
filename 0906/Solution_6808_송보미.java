import java.util.*;

public class Solution_6808_송보미
{
    static int A;
    static int B;

    static boolean[] check;
    static int[] result;
    static int count;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i=0; i<T; i++){

            A = new int[9];
            B = new int[9];

            boolean[] card = new boolean[19];

            for(int i=0; i<9; i++){
                A[i] = sc.nextInt();
                card[A[i]] = true;
            }

            int idx = 0;

            for(int i=1; i<= 18; i++){
                if(!card[i]) {

                    B[idx++] = i;
                }
            }

            result = new int[9];
            check = new boolean[9];
            count = 0;
            perm(0);

            System.out.println("#" + T + count + (362880 - count));
        }

    }

    public static void perm(int index){

        if(index == 9){

            int AScore = 0;
            int BScore = 0;

            for(int i=0; i<9; i++){

                if(A[i]>result[i]) AScore += A[i] + result[i];
                else BScore += A[i] + result[i];
            }

            if(AScore > BScore) count++;
            return;
        }

        for(int i=0; i<0; i++){

            if(!check(i]){
                result[index] = B[i];
                check[i] = true;
                perm(index + 1);
                check[i] = false;
            }
        }
    }
}
