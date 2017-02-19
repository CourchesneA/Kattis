import java.util.Scanner;
import java.util.HashMap;

public class narrowartgallery {
	static int[][] narrow;
	static HashMap<String,Integer> memoization;
	
	  public static void main(String[] args){

	        Scanner sc = new Scanner(System.in);
	        while(sc.hasNextInt()) {
	            int n = sc.nextInt();
	            int k = sc.nextInt();
	            narrow = new int[2][n];
	            memoization = new HashMap<String,Integer>();
	            
	            for(int i=0; i<2*n; i++){
	            	narrow[i%2][i/2] = sc.nextInt();
	            }
	            
	            //Handle special cases
	            int answer = -1;
	            if(k==n){
	            	//return left or right
	            	
	            	int vals[] = new int[2];
	            	for(int i=0;i<2*n; i++){
	            		//return total
	            		vals[i%2]+=narrow[i%2][i/2];
	            	}
	            	answer = Math.max(vals[0], vals[1]);
	            }else if(k==0){
	            	int total=0;
	            	for(int i=0;i<2*n; i++){
	            		//return total
	            		total+=narrow[i%2][i/2];
	            	}
	            	answer = total;
	            }else if(k==1){
	            	//return total - lower
	            	int total=0;
	            	int lower=1001;
	            	int current=0;
	            	for(int i=0;i<2*n;i++){
	            		current = narrow[i%2][i/2];
	            		total+=current;
	            		if(current < lower){
	            			lower = current;
	            		}
	            	}
	            	answer = total - lower;
	            	
	            }else{
	            	answer = Math.max(Math.max(localMax(n-1,k,0),localMax(n-1,k-1,1)),localMax(n-1,k-1,2));
	            }
	            
	            System.out.println(answer);
	            sc.nextInt();
	            sc.nextInt();
	        }
	        sc.close();
	  }
	  
	  public static int localMax(int rowsCount, int blockedCount, int lastState){
		  
		  if(rowsCount < blockedCount){
			  return -1;	//Invalid state, return -1 so this value does not get picked by math.max
		  }
		  //base case
		  if(rowsCount == -1 ){
			  return 0;
		  }
		  //not enough rows remaining for the blocked count
		  
		  int returnval = -1;
		  switch(lastState){
		  case 0:
			  returnval = narrow[0][rowsCount] + narrow[1][rowsCount] + Math.max(Math.max(lookup(rowsCount-1, blockedCount, 0),lookup(rowsCount-1, blockedCount-1, 1)),lookup(rowsCount-1, blockedCount-1, 2));
			  break;
		  case 1:
			  returnval = narrow[1][rowsCount] + Math.max(lookup(rowsCount-1, blockedCount, 0),lookup(rowsCount-1, blockedCount-1, 1));
			  break;
		  case 2:
			  returnval = narrow[0][rowsCount] + Math.max(lookup(rowsCount-1, blockedCount, 0),lookup(rowsCount-1, blockedCount-1, 2));
			  break;
		  }
		  return returnval;
	  }
	  
	  /**
	   * Store the answer so we can re-use it later if we need
	   * @param rowsCount
	   * @param blockedCount
	   * @param lastState
	   * @return
	   */
	  public static int lookup(int rowsCount, int blockedCount, int lastState){
		  //this method registers calculated values of the recursion
		  String key =Integer.toString(rowsCount)+Integer.toString(blockedCount)+Integer.toString(lastState);
		  if(memoization.get(key) != null){
			  return memoization.get(key);
		  }
		  int answer = localMax(rowsCount,blockedCount,lastState);
		  memoization.put(key, answer);
		  return answer;
	  }
	
}
