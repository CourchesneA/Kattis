

import java.util.Scanner;
import java.util.ArrayList;


public class Permutationencryption {

	  public static void main(String[] args){

	        Scanner sc = new Scanner(System.in);
	        int keyLength;
	        while((keyLength = (int)sc.nextLong())!=0) {
	        	int[] key = new int[keyLength];
	        	//Populate the key arraylist
	        	for(int i=0; i<keyLength; i++){
	        		key[i] = (int) sc.nextLong();
	        	}
	        	
	        	
	        	//Get the scanner past the line feed
	        	sc.nextLine();
	        	String msg = sc.nextLine();
	        	
	        	int missingChars = (keyLength-msg.length()%keyLength)%keyLength;	//Additional modulo to handle case where strlength is multiple of key
	        	//System.out.println(missingChars +" "+ keyLength +" "+ msg.length());
	        	
	        	//Pad the string
	        	for(int i=0;i<missingChars;i++){
	        		msg+=" ";
	        	}
	        	
	        	//iterate through each part of the string
	        	char[] msgArr = msg.toCharArray();
	        	String newMsg ="";
	        	for(int part=0; part < msg.length()/keyLength; part++){
	        		for(int i=0; i<keyLength; i++){	//for each int in the key
	        			newMsg+=msgArr[part*keyLength+key[i]-1];
	        		}
	        	}


	            System.out.println("\'"+newMsg+"\'");
	        }
	    }
	
}
