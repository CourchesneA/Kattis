//TODO use array instead of linked list
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//then run BFS
public class coast {
	
	 public static void main(String[] args){
	

	        Scanner sc = new Scanner(System.in);
	        while(sc.hasNextInt()) {
	            int n = sc.nextInt();
	            int m = sc.nextInt();

	            //Parse the input in a 2D array
	            int[][] grid = new int[n+2][m+2];	//Add extra water contour
	            sc.nextLine();	//Advance the stream to next line
	            for(int i=0; i < n+2; i++){
	            	if(i==0 || i == n+1){
	            		continue;
	            	}
	            	String s = sc.nextLine();
	            	for(int j=0; j< m+2; j++){
	            		if(j == 0 || j == m+1){
	            			continue;
	            		}else{
	            			grid[i][j] = s.charAt(0)-48;
	            			s= s.substring(1);
	            		}
	            		
	            	}
	            }
	            
	            int coastKm = 0;
	            //Run BFS from 0,0, add 1 when neighbor is land tile
	            //LinkedList<Position> visited = new LinkedList<Position>();
	            int[][] visited = new int[n+2][m+2];
	   		 	Queue<Position> queue = new LinkedList<Position>();
	   		 	queue.add(new Position(0,0));
	   		 	while(!queue.isEmpty()){
	   		 		Position currentPosition = queue.remove();
	   		 		for(int i=0; i<4; i++){
	   		 			//For each direction
	   		 			int addToN = (int) Math.round(Math.cos((Math.PI/2)*i)); //1 0 -1 0
	   		 			int addToM = (int) Math.round(Math.sin((Math.PI/2)*i)); //0 1 0 -1
	   		 			Position newPosition = new Position(currentPosition.n+addToN,currentPosition.m+addToM);
	   		 			//Check if neighbor is outof bound
	   		 			int gridVal;
	   		 			try{
	   		 				gridVal = visited[newPosition.n][newPosition.m];
	   		 			}catch(ArrayIndexOutOfBoundsException e){
	   		 				gridVal = 1;
	   		 			}
	   		 			if(visited[newPosition.n][newPosition.m] == 1 ){ //TODO check outofbound
	   		 				continue;
	   		 			}
	   		 			int tileValue;	//Grid value of the new position: 1 = land, out or water = 0
	   		 			try{
	   		 				tileValue = grid[newPosition.n][newPosition.m];
	   		 				if(tileValue==1){
	   		 					coastKm++;
	   		 					
	   		 				}else{
	   		 					if(!queue.contains(newPosition)){
	   		 						queue.add(newPosition);
	   		 					}
	   		 				}
	   		 			}catch(ArrayIndexOutOfBoundsException e){
	   		 				continue;
	   		 			}
	   		 			
	   		 		}
	   		 		visited[currentPosition.n][currentPosition.m] = 1;
	   		 	}
	            
	            System.out.println(coastKm);
	        }
	        sc.close();
	    }
}

class Position{
	public int n;	//y axis
	public int m;	// x axis
	
	public Position(int n, int m){
		this.n = n;
		this.m= m;
	}
	
	@Override
	public boolean equals(Object other){
		if(other instanceof Position){
			Position o = (Position) other;
			if(this.n == o.n && this.m == o.m){
				return true;
			}
		}
		
		return false;
	}
}
