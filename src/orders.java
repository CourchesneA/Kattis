import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class orders {

	static HashMap<Integer,String> remember;
	static int[] prices;
	static int min;
	static String impossible = "Impossible";
	static String ambiguous = "Ambiguous";

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLong()) {
			//initialisation
 			int n = sc.nextInt();	//First num, number of items on the menu
			prices = new int[n];	// Prices of the items
			min = 9999999;
			for(int i=0; i<n; i++){
				prices[i] = sc.nextInt();
				if(prices[i] < min){
					min = prices[i];
				}
			}
			int m = sc.nextInt();	// Number of orders
			int orders[] = new int[m];
			for(int i=0; i<n; i++){
				orders[i] = sc.nextInt();
			}
			remember = new HashMap<Integer,String>();	//Used for memoization

			//solve
			//Idea: Solve using dynamic programming and memoization

			for(int total:orders){
				System.out.println(lookup(total));
			}


		}
		sc.close();
	}

	public static String findOrder(int total){
		// Solve total-price1, total-price2, etc.
		/* Possibilities
		Impossible, if all of the sub problems return impossible
		Ambiguous, if more than one return a solution OR one price return "ambiguous"
		Solution, if only one string return a solution return solution+price

		Base cases
		total == price, return price
		total < price, return impossible

		TODO handle case where an item is a multiple of another

		 */
        if(total < min){
            return impossible;
        }
        //Check if the current total is a possible item
        for(int i=0; i< prices.length; i++){
        	if(prices[i] == total){
        		//Solution found, unroll the stack and add to solution
    			//return Integer.toString(prices[i]);
        		return Integer.toString(i+1);
        	}
	        
		}
        

        ArrayList<String> answs = new ArrayList<String>();
        int impCount = 0;
        int ambCount = 0;
        int solCount = 0;
        int solIndex = -1;
		for(int i=0; i< prices.length; i++){
		   

			// Find the answer for the sub problem using the memoization lookup
			String result = lookup(total-prices[i]);
		    answs.add(i, result);

		    if(result.equals(impossible)){
		    	impCount++;
			}else if(result.equals(ambiguous)){
		    	ambCount++;
			}else{
				solCount++;
				solIndex = i;
			}
		}

		//Interpret the result array list
		if (impCount == prices.length){
			return impossible;	//No solution found
		}else if(ambCount > 0 || solCount > 1){
			return ambiguous;
		}else if(solCount == 1){
			return prices[solIndex] + " " + answs.get(solIndex);
		}else{
			return "Error";
		}
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
