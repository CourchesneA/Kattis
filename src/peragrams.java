import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class peragrams {

	/*
	 * Parse in a DS
	 * count the number of letters that do not have a pair
	 */
	
	public static void main(String args[]){
		
		 Scanner sc = new Scanner(System.in);
	        while(sc.hasNextLine()) {
	            String line = sc.nextLine();
	            int[] word = new int[26];
	            for(int i=0; i<line.length(); i++){
	            	word[(int) line.charAt(i)-97]++;
	            }
	            
	            int loneLetter =0;
	            
	            for(int i=0; i< word.length; i++){
	            	if(word[i]%2==1){
	            		loneLetter++;
	            	}
	            }
	            int result =0;
	            if(loneLetter > 1){
	            	result = loneLetter-1;
	            }


	            System.out.println(result);
	        }
		sc.close();
		
	}
}
