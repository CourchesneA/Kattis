import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//TODO att a layer of water
//then run BFS
public class coast {
	 static int[][] grid;
	
	 public static void main(String[] args){
	

	        Scanner sc = new Scanner(System.in);
	        while(sc.hasNextInt()) {
	            int n = sc.nextInt();
	            int m = sc.nextInt();

	            //Parse the input in a 2D array
	            grid = new int[n][m];
	            sc.nextLine();	//Advance the stream to next line
	            for(int i=0; i < n; i++){
	            	String s = sc.nextLine();
	            	for(int j=0; j< m; j++){
	            		grid[i][j] = s.charAt(j)-48;
	            	}
	            }
	            
	            //Identify inside lake as -1
	            for(int i=0; i < n; i++){
	            	for(int j=0; j< m; j++){
	            		if(grid[i][j] == 0){
	            			removeLake(new Position(i,j));
	            		}
	            		
	            	}
	            }
	            
	            int coastKm = 0;
	            //Scan all the horizontal edges
	            for(int i=0; i < n+1; i++){
	            	for(int j=0; j< m+1; j++){
	            		int topTile;
	            		int underTile;
	            		try{
	            			topTile = grid[i-1][j];
	            		}catch(ArrayIndexOutOfBoundsException e){
	            			topTile = 2;
	            		}
	            		try{
	            			underTile = grid[i][j];
	            		}catch(ArrayIndexOutOfBoundsException e){
	            			underTile = 2;
	            		}
	            		if(topTile+underTile == 3){	//There is exactly one of them that is land
	            			coastKm++;
	            		}
	            	}
	            }
	            
	            //Scan all the vertical edges
	            for(int i=0; i < n+1; i++){
	            	for(int j=0; j< m+1; j++){
	            		int leftTile;
	            		int rightTile;
	            		try{
	            			leftTile = grid[i][j-1];
	            		}catch(ArrayIndexOutOfBoundsException e){
	            			leftTile = 2;
	            		}
	            		try{
	            			rightTile = grid[i][j];
	            		}catch(ArrayIndexOutOfBoundsException e){
	            			rightTile = 2;
	            		}
	            		if(leftTile+rightTile == 3){	//There is exactly one of them that is land
	            			coastKm++;
	            		}
	            	}
	            }
	            
	            System.out.println(coastKm);
	        }
	        sc.close();
	    }
	 
	 public static boolean removeLake(Position p){
		 //TODO we can speed up by updating all other lake tile visited
		 //BFS implementation to find border tile
		 LinkedList<Position> visited = new LinkedList<Position>();
		 Queue<Position> queue = new LinkedList<Position>();
		 queue.add(p);
		 int setValue = 1;
		 while(!queue.isEmpty()){
			 Position p1 = queue.remove();
			 //check if its on the border
			 boolean leftBorder = false;
			 boolean rightBorder = false;
			 boolean upBorder = false;
			 boolean downBorder = false;
			 if(p1.n==0){
				 //This is ocean
				 setValue = 2;
				 upBorder = true;
			 }
			 if(p1.m==0){
				 setValue = 2;
				 leftBorder = true;
			 }
			 if(p1.n==grid.length-1){
				 setValue = 2;
				 downBorder = true;
			 }
			 if(p1.m==grid[0].length-1){
				 setValue = 2;
				 rightBorder = true;
			 }
			 //add water neighbors to queue if they were not visited before
			 Position a = new Position(p1.n+1,p1.m);
			 if( !downBorder && grid[a.n][a.m] == 0 && !visited.contains(a)){
				 queue.add(a);
			 }
			 a = new Position(p1.n,p1.m+1);
			 if(!rightBorder && grid[a.n][a.m] == 0 && !visited.contains(a)){
				 queue.add(a);
			 }
			 a = new Position(p1.n-1,p1.m);
			 if(!upBorder && grid[a.n][a.m] == 0 && !visited.contains(a)){
				 queue.add(a);
			 }
			 a = new Position(p1.n,p1.m-1);
			 if(!leftBorder && grid[a.n][a.m] == 0 && !visited.contains(a)){
				 queue.add(a);
			 }
			 
			 //p1 is done, set it has seen
			 visited.add(p1);
		 }
		 //All contiguous water explored without finding a border, its a lake
		 //Set all tiles to 1
		 for(Position lakeTile:visited){
			 grid[lakeTile.n][lakeTile.m] = setValue;
		 }
		 return true;
	 }
}

class Position{
	public int n;	//y axis
	public int m;	// x axis
	
	public Position(int n, int m){
		this.n = n;
		this. m= m;
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
