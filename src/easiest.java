
import java.util.Scanner;

public class easiest{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLong()){
            long N = sc.nextLong();
            if(N == 0 )
                System.exit(0);
            int sum1 = countDigits(N);
            for(long p = 11; p< 999999; p++){
                if(sum1==countDigits(N*p)){
                    System.out.println(p);
                    break;
                }
            }
        }
    }

    public static int countDigits(long num){
        int acc =0;
        String numStr = Long.toString(num);
        for(int i=0; i<numStr.length(); i++){
            acc+=numStr.charAt(i)-'0';
//            System.out.println("> "+acc);
        }
        return acc;
    }
}
