
import java.util.Scanner;

public class GuessDT{

	/**
	 * Algorithm: Have an implementation of each type an try them, compare answer or catch exceptions
	 * @param args
	 */
    public static void main(String[] args){
    	
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLong()) {
            long nextInputCount = sc.nextLong();
            int[][] sample = new int[(int) nextInputCount][2];

            for(int i=0; i<nextInputCount; i++){
            	sample[i][0] = (int) sc.nextLong();
            	sample[i][1] = (int) sc.nextLong();
            }
            int a = testQueue(sample);
            int b = testStack(sample);
            int c = testPriorityQueue(sample);
            String result = "";
            if(a+b+c == 0){
            	result = "impossible";
            }else if(a+b+c >1){
            	result = "not sure";
            }else if(a == 1){
            	result = "queue";
            }else if(b == 1){
            	result = "stack";
            }else if(c == 1){
            	result = "priority queue";
            }
            System.out.println(result);
        }
        sc.close();
        System.exit(0);
    }
    
    public static int testQueue(int[][] sample){
    	//Test a queue implementation, check if last element is what is expected, or if an excpetion is thrown
    	java.util.Queue<Integer> qDT = new java.util.LinkedList<Integer>();
    	for(int i = 0; i< sample.length; i++){
    		if(sample[i][0] == 1){
    			qDT.add(sample[i][1]);
    		}else if(sample[i][0] == 2){
    			int element;
    			try{
    				element = qDT.remove();
    				if (element != sample[i][1]){
    					return 0;
    				}
    			}catch(java.util.NoSuchElementException e){
    				return 0;
    			}
    		}
    	}
    	return 1;
    }
    
    public static int testStack(int[][] sample){
    	java.util.Stack<Integer> sDT = new java.util.Stack<Integer>();
    	for(int i = 0; i< sample.length; i++){
    		if(sample[i][0] == 1){
    			sDT.push(sample[i][1]);
    		}else if(sample[i][0] == 2){
    			int element;
    			try{
    				element = sDT.pop();
    				if (element != sample[i][1]){
    					return 0;
    				}
    			}catch(java.util.EmptyStackException e){
    				return 0;
    			}
    		}
    	}
    	return 1;
    }
    
    public static int testPriorityQueue(int[][] sample){
    	java.util.PriorityQueue<Integer> pqDT = new java.util.PriorityQueue<Integer>(11, java.util.Collections.reverseOrder());
    	for(int i = 0; i< sample.length; i++){
    		if(sample[i][0] == 1){
    			pqDT.add(sample[i][1]);
    		}else if(sample[i][0] == 2){
    			Integer element;
    			if((element = pqDT.poll()) == null){
    				return 0;	//Poll does not throw an error like remove from Queue
    			}
				
				if (element != sample[i][1]){
					return 0;
				}
    			
    		}
    	}
    	return 1;
    }
}
