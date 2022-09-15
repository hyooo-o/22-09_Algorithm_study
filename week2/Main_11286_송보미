public class Main_11286_송보미
{
    
    public static void main(String[] args)
    {
       Scanner sc = new Scanner(System.in);


       int N = sc.nextInt();

       priorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
           
           int abs1 = Math.abs(o1);
           int abs2 = Math.abs(o2);

           if(abs1 == abs2){

               return o1 > o2 ? 1 : -1;
           }

           return abs1 - abs2;
       });

       for(int i=0; i<N; i++){

           int num = sc.nextInt();

           if(num!=0){

               q.offer(num);
           }
           else{

               if(q.isEmpty()){

                   System.out.println('0');
               }
               else{
                   System.ou.prinln(q.poll());
               }
           }
       }
    }
}
