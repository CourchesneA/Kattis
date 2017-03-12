import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by anthony on 3/11/17.
 */
public class pikemaneasy {
    static HashMap<Integer, Integer> remember;
    static int a;
    static int b;
    static int c;
    static int t;

    public static void main(String[] args){
        remember = new HashMap<Integer, Integer>();

        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int N = sc.nextInt();
            int T = sc.nextInt();

            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            t = sc.nextInt();

            int elapsedTime = 0;
            int resolvedProblems = 0;
            long timePenalty = 0;
            for(int i=0; i< N; i++){
                //For each problem, check if he has time to do it

                //Calculate the time it will take for problem i
                int nextProblemTime = lookup(i);

                //If there is enough time to complete it, do it
                if(elapsedTime+nextProblemTime <= T){
                    //Code problem
                    elapsedTime+=nextProblemTime;
                    //Submit problem
                    timePenalty+= elapsedTime;
                    resolvedProblems++;
                }else {
                    //There is not enough time left to complete another problem, exit the loo
                    break;
                }
            }

            System.out.println(resolvedProblems +" "+(timePenalty)%1000000007L);
        }
        sc.close();
    }

    public static int calculateTime(int time){
        if(time == 0){
            return t;
        }

        return ((a*lookup(time-1)+b)%c)+1;
    }


    public static int lookup(int time){
        if(remember.get(time) != null){
            return remember.get(time);
        }
        int answer = calculateTime(time);
        remember.put(time, answer);
        return answer;
    }


}
