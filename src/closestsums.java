import java.util.Scanner;
import java.util.ArrayList;

public class closestsums {

	public static void main(String args[]){
		
	
	    Scanner sc = new Scanner(System.in);
	    int casenb=1;
	    while(sc.hasNextLong()) {
	    	System.out.println("Case "+casenb+":");
	        int ncount = sc.nextInt();
	        int[] ns = new int[ncount];
	        
	        
	        for(int i=0; i<ns.length; i++){
	        	ns[i]=sc.nextInt();
	        }
	        
	        int mcount = sc.nextInt();
	        
	        for(int i=0; i< mcount; i++){
	        	int query = sc.nextInt();
	        	
	        	//find the sum
	        	int sum= (ns.length <= 1) ? ns[0] : ns[0]+ns[1];
	        	int distance = (ns.length <= 1) ? Math.abs(query-ns[0]) : Math.abs(query-(ns[0]+ns[1]));
	        	for(int j=0; j<ns.length; j++){	//iterate through data
	        		for(int k=j+1; k<ns.length; k++){ // second iterate
	        			int m;
	        			if((m = Math.abs(query-(ns[j]+ns[k]))) < distance){
	        				distance = m;
	        				sum = ns[j]+ns[k];
	        			}
	        		}
	        	}
	        	
	        	System.out.println("Closest sum to "+query+" is "+sum+".");
	        	
	        }
	        casenb++;
	    }
	    sc.close();
		
	}
	
}
