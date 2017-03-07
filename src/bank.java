import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by anthony on 3/6/17.
 */
public class bank {
    int time = 0;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int totalPeople = sc.nextInt(); //Number of people
            int closeTime = sc.nextInt(); //Time before closing

            ArrayList<People> peoples = new ArrayList<People>();

            for(int i=0; i < totalPeople; i++){
                //for each people
                int c = sc.nextInt();
                int t = sc.nextInt();
                People p = new People(c,t);
                peoples.add(p);
            }
            peoples.sort(new TimeComparator());	//Later times first
            
            int bankCash = 0;
            //Greedy solution on time, inverse loop
            for(int curTime = closeTime; curTime >= 0; curTime--){
            	//Check if there are people that are willing to wait that much time
            	
            	//Take the most paying
            	
            	//Decrement time
            }
            System.out.println(bankCash);
        }
        sc.close();
    }

}
class People{
    int cash;
    int leaveTime;

    public People(int cash, int time){
        this.cash = cash;
        this.leaveTime = time;
    }
}
class TimeComparator implements Comparator<People>{
	public int compare(People p1, People p2) {
		if(p1.leaveTime > p2.leaveTime){
			return -1;
		}else if (p1.leaveTime == p2.leaveTime){
			return 0;
		}else{
			return 1;
		}
	}
}
class CashComparator implements Comparator<People>{
	public int compare(People p1, People p2) {
		if(p1.cash > p2.cash){
			return -1;
		}else if (p1.cash == p2.cash){
			return 0;
		}else{
			return 1;
		}
	}
}

