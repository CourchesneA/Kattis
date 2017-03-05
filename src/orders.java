import java.util.ArrayList;
import java.util.Comparator;
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
			for(int i=0; i<m; i++){
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
        
        ArrayList<String> answs = new ArrayList<String>();
        
        //Check if the current total is a possible item
        for(int i=0; i< prices.length; i++){
        	if(prices[i] == total){
        		if(total == min){
        			//Solution found, unroll the stack and add to solution
            		return Integer.toString(i+1);
        		}else{
        			//We found a solution but there might be others under
        			answs.add(Integer.toString(i+1));
        		}
        	}
		}
        

		for(int i=0; i< prices.length; i++){

			// Find the answer for the sub problem using the memoization lookup
			String result = lookup(total-prices[i]);
		    //answs.add(i, result);	//TODO remove this ?

		    if(result.equals(impossible)){
		    	continue;
			}else if(result.equals(ambiguous)){
		    	return ambiguous;
			}else{
				answs.add(result+" "+Integer.toString(i+1));
			}
		}

		//Interpret the result array list
		if(answs.size() == 0){
			return impossible;
		}else if(answs.size() == 1){
			return answs.get(0);
		}else{
			// check if more than one solution are the same
			// 
			return checkDuplicates(answs);
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
	
	public static String checkDuplicates(ArrayList<String> list){
		//Return an AL of string which contains only one instance of every ordered string
		
		//Check if there are more than one instance of every string when we order the values
		ArrayList<ArrayList<Integer>> sols = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i< list.size(); i++){
			sols.add(i, new ArrayList<Integer>());
			
			String str = list.get(i);
			String[] elems = str.split(" ");
			for(String elem:elems){
				sols.get(i).add(Integer.parseInt(elem));
			}
			sols.get(i).sort(new IntComparator());
		}
		
		//Now we have an AL of sorted AL<int>, we want to remove duplicates
		ArrayList<ArrayList<Integer>> rval = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i< sols.size(); i++){
//			String str = "";
//			for(int j=0; j<sols.get(i).size(); j++, str+=" "){
//				str+=sols.get(i).get(j);
//			}
			if(!rval.contains(sols.get(i))){
				rval.add(sols.get(i));
			}
		}
		if(rval.size() == 1){
			String str = Integer.toString(rval.get(0).get(0));
			for(int i=1; i<rval.get(0).size();i++){
				str+=" "+ Integer.toString(rval.get(0).get(i));
			}
			return str;
		}else{
			return ambiguous;
		}

	}

	
}
class IntComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer v1, Integer v2) {
        return v1 < v2 ? -1 : v1 > v2 ? +1 : 0;
    }
}
