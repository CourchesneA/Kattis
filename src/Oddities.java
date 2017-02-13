
import java.util.Scanner;

public class Oddities{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int testCdn = (int)sc.nextLong();
        for(int i=1; i<= testCdn; i++){
            long a = sc.nextLong();
            if(a % 2 == 0)
                System.out.println(a+" is even");
            else
                System.out.println(a+" is odd");
        }
    }
}
