import java.util.ArrayList;
import java.util.Scanner;

public class commertials {

	/*
	 * There is likely something that make it runs forever right now
	 */
	public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLong()) {
            int n = sc.nextInt();
            int p = sc.nextInt();
            
            ArrayList<Integer> listeners = new ArrayList<Integer>();
            
            int maxProfit=0;
            
            for(int i=0; i<n; i++){
            	listeners.add(sc.nextInt());
            }
            
            //Strip the ending
            while(listeners.get(0)-p <=0){
            	listeners.remove(0);
            }
            while(listeners.get(listeners.size()-1)-p<=0){
            	listeners.remove(listeners.size()-1);
            }
            
            for(int i=0; i<listeners.size(); i++){
            	if(listeners.get(i)<=p){
            		continue;
            	}
            	for(int j=i; j<listeners.size(); j++){
            		int profit=0;
            		if(i==j){
            			profit = listeners.get(i)-p;
            		}else{
            			for(int k=i; k<=j; k++){
            				profit+=listeners.get(k)-p;
            			}
            		}
            		if(profit > maxProfit){
            			maxProfit = profit;
            		}
            	}
            }


            System.out.println(maxProfit);
        }
        sc.close();
    }
	
}
