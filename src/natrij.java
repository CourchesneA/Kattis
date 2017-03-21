import java.util.Scanner;

public class natrij {
	 public static void main(String[] args){

	        Scanner sc = new Scanner(System.in);
	        while(sc.hasNextLine()) {
	            String t1 = sc.nextLine();
	            String currentTime[] = new String[3];
	            currentTime = t1.split(":");
	            String t2 = sc.nextLine();
	            String expTime[] = new String[3];
	            expTime = t2.split(":");
	            

	            
	            int ct = Integer.parseInt(currentTime[0])*60*60 + Integer.parseInt(currentTime[1])*60 + Integer.parseInt(currentTime[2]);
	            int et = Integer.parseInt(expTime[0])*60*60 + Integer.parseInt(expTime[1])*60 + Integer.parseInt(expTime[2]);
	            int remTime;
	            if (et < ct){
	            	remTime = 86400 - ct + et;
	            }else if(et == ct){
	            	remTime = 86400;
	            }else{
	            	remTime = et - ct;
	            }
	            
	            double h = Math.floor(remTime/3600);
	            double m = Math.floor((remTime - h*3600)/60);
	            double s = Math.floor(remTime - h*3600 - m*60);
	            
	            String hs = Integer.toString((int) h);
	            if (hs.length() == 1){
	            	hs = 0+hs;
	            }
	            String ms = Integer.toString((int) m);
	            if (ms.length() == 1){
	            	ms = 0+ms;
	            }
	            String ss = Integer.toString((int) s);
	            if (ss.length() == 1){
	            	ss = 0+ss;
	            }
	            System.out.println(hs+":"+ms+":"+ss);
	        }
	        sc.close();
	    }
}
