package kattis;

import java.util.Scanner;
import java.util.Arrays;

public class Sortofsorting {


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        long indicator;
        int space=0;
        while((indicator=sc.nextLong())!=0) {
        	if(space==0){
        		space=1;
        	}else{
        		System.out.println("");
        	}
        	LastName[] arr = new LastName[(int)indicator];	//Using custom type to implement comparator
        	
        	//Advance scanner index past the line feed after the double
        	sc.nextLine();
        	// populate array
        	for(int i=0; i< indicator; i++){
        		 String name = sc.nextLine();
        		arr[i]= new LastName(name);
        	}
           
        	Arrays.sort(arr);

        	for(LastName person:arr){
        		System.out.println(person.lastname);
        	}
            
        }
        sc.close();
    }
	
}

class LastName implements Comparable<LastName> {
	
	public final String lastname;
	
	 public LastName(String name){
		 this.lastname = name;
	 }
	


	public int compareTo(LastName o) {
		return lastname.substring(0, 2).compareTo(o.lastname.substring(0,2));
	}

}