
public class Main_2493_송보미
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args)
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int top[] = new int[N];
        stringTokenizer st = new StringTokenizer(in.readLine());

        for(int i=0; i<top.length; i++){

            top[i] = Integer.parseInt(st.nextToken());

        }

        int ans[] = new int[N];

        Stack<Point> stack = new Stack<Point>();

        for(int i=0; i<N; i++){

            if(Stack.isEmpty()){
                stack.add(new Point(i, top[i]));

            }else {

                while(!stack.isEmpty()){

                    if(stack.peek().y >= top[i]){

                        ans[i] = stack.peek().x+1;
                        break;
                    }else{

                        stack.pop();
                    }
                }
                stack.add(new Point(i, top[i]));
            }
            System.out.println(ans[i]);
        }
    }
}
