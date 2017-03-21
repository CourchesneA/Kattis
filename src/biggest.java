import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class biggest {

	
	 public static void main(String[] args){

	        Scanner sc = new Scanner(System.in);
	        while(sc.hasNextLong()) {
	            int m = sc.nextInt();  //nb of test cases
	            
	            for(int i=0; i< m; i++){
	            	double r = sc.nextLong();
	            	int n = sc.nextInt();
	            	double theta = sc.nextLong();
	            	double min = sc.nextLong();
	            	double sec = sc.nextLong();
	            	HashMap<Double,Integer> memo = new HashMap<Double,Integer>();
	            		
	            	double totalSec = theta*60*60+min*60+sec;
	            	//min = min + sec/60;
	            	//theta = theta + min/60;
	            	
	            	//double[] cuts = new double[n];
	            	ArrayList<Double> cuts = new ArrayList<Double>();
	            	double currentAngle = 0;
	            	for(int j=0; j< n; j++, currentAngle+= totalSec){
	            		//Note all the angles if they were not noted
	            		double a = (currentAngle % (360*60*60));
	            		if (memo.get(a) == null){
	            			memo.put(a, 1);
	            			cuts.add(a);
	            		}else{
	            			break;
	            		}
	            	}
	            	
	            	//All the cuts are noted
	            	//Find the biggest angle
	            	cuts.sort(null);
	            	double maxAngle = 0;
	            	for(int j=0; j<cuts.size()-1; j++){
	            		if(cuts.get(j+1)-cuts.get(j) > maxAngle){
	            			maxAngle = cuts.get(j+1)-cuts.get(j);
	            		}
	            	}
	            	//Check last angle
	            	
	            	if((360*60*60 - cuts.get(cuts.size()-1)) > maxAngle){
	            		maxAngle = 360*60*60-cuts.get(cuts.size()-1);
	            	}
	            	
	            	System.out.println(Math.PI*Math.pow(r, 2)*((maxAngle/3600)/360));
	            	
	            }
	        }
	        sc.close();
	    }
}

