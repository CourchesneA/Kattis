import java.util.HashMap;
import java.util.Scanner;

public class orders {
	
	static HashMap<Integer,String> remember;
	static int[] prices;

	  public static void main(String[] args){

	        Scanner sc = new Scanner(System.in);
	        while(sc.hasNextLong()) {
	        	//initialisation
	            int n = sc.nextInt();
	            prices = new int[n];
	            for(int i=0; i<n; i++){
	            	prices[i] = sc.nextInt();
	            }
	            int m = sc.nextInt();
	            int orders[] = new int[m];
	            for(int i=0; i<n; i++){
	            	orders[i] = sc.nextInt();
	            }
	            remember = new HashMap<Integer,String>();
	            
	            //solve
	            for(int total:orders){
	            	//Idea: Solve using dynamic programming and memoization
	            	
	            	
	            }
	            

	        }
	        sc.close();
	  }
	  
	  public static String findOrder(int total){
		  String answer = "";
		  for(int price:prices){
			  String result = lookup(total-price);
			  if(result.equals("Impossible")){
				  continue;
			  }else if(result.equals("Ambiguous")){
				  answer = "Ambiguous"; 
				  break;
			  }else{
				  if(answer != "Impossible"){
					  //TODO handle 2 answer that end up the same (Array list ?)
					  //Ambiguous
					  answer = "Ambiguous";
					  break;
				  }
				  //first possibility
				  answer = result;
			  }
		  }
		  return answer;
	  }
	  
	  public static String lookup(int price){
		  //this method registers calculated values of the recursion
		  if(remember.get(price) != null){
			  return remember.get(price);
		  }
		  String answer = findOrder(price);
		  remember.put(price, answer);
		  return answer;
	  }
	  
}
