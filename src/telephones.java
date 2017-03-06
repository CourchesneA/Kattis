import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by anthony on 3/6/17.
 */

public class telephones {

    public static void main(String[] args){

//        try {
//            System.setIn(new FileInputStream(new File("sample.in")));
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//            e.printStackTrace();
//        }

        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if(n == 0 && m ==0){
                break;
            }
            ArrayList<Call> calls = new ArrayList<Call>();
            for(int i=0; i < n; i++){
               //For each call
                int p1 = sc.nextInt();
                int p2 = sc.nextInt();
                int start = sc.nextInt();
                int duration = sc.nextInt();
                calls.add(new Call(start,duration));
            }
            for(int i=0; i < m; i++){
               //For each interval
                int s = sc.nextInt();
                int d = sc.nextInt();
                int callCount = 0;
                for(Call aCall:calls){
                    if(aCall.isInside(s,s+d)){
                        callCount++;
                    }
                }
                System.out.println(callCount);
            }
        }
        sc.close();
    }

}

class Call{
    //Omitting source and destination to save space
    public int start;
    public int end;

    public Call(int start, int duration){
        this.start = start;
        this.end = start+duration;
    }

    public boolean isInside(int intS, int intE){
        //Check if the input call is inside the interval
        //Proceed using inverse set: check if the call is outside

        //Case 1: callS & callE are before the start of the interval
        //Case 2: callS & callE are after the end of the interval
        //ELSE: The call is in the interval
        //Assume callS < callE
        //assert (this.start < this.end);
        if (this.end <= intS || this.start >= intE ){
            return false;
        }else{
            return true;
        }
    }
}
