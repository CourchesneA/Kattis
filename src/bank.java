import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by anthony on 3/6/17.
 */
public class bank {
    int time = 0;

    public static void main(String[] args){

        try {
            System.setIn(new FileInputStream(new File("sample.in")));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int totalPeople = sc.nextInt(); //Number of people
            int closeTime = sc.nextInt(); //Time before closing

            ArrayList<People> peoples = new ArrayList<People>();
            for(int i=0; i < totalPeople; i++){
                //for each people
                int c = sc.nextInt();
                int t = sc.nextInt();
                peoples.add(new People(c,t));
            }
            for(int curTime = 0; curTime < closeTime; i++ ) { //Assert we do not serve at closing time

            }
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
