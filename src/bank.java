import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

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

            PriorityQueue<People> peoples = new PriorityQueue<People>(new TimeComparator());

            for(int i=0; i < totalPeople; i++){
                //for each people
                int c = sc.nextInt();
                int t = sc.nextInt();
                People p = new People(c,t);
                peoples.add(p);
            }

            int bankCash = 0;
            //Greedy solution on time, inverse loop
            for(int curTime = closeTime; curTime >= 0; curTime--){
            	//Check if there are people that are willing to wait that much time
                //Order people on reverse time
                People person;
                while((person = peoples.peek()).leaveTime < curTime){   //TODO check;
                    if(person.leaveTime < curTime){
                        break;  //The last leaving person will leave before this minute to do nothing
                    }else{
                        //We should create a heap with all the possible people
                        //Then get and remove the the richest
                    }
                }

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

