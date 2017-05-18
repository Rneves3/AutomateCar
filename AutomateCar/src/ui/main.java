/*package ui;

import java.util.Scanner;

import jess.JessException;
import jess.Rete;

public class main {
	
	Scanner tempMax = new Scanner(System.in);
		public 	Scanner temp = new Scanner(System.in);
		public Scanner tempMin = new Scanner(System.in);
		public 	Scanner distMax = new Scanner(System.in);
		public Scanner time = new Scanner(System.in);
		public Scanner horasMax = new Scanner(System.in);
		public int humidade, chuva, oxigenio, luminosidade;
	
	public static void main(String[] args) throws JessException{
		
		Rete jess = new Rete();
		
		
		System.out.print("\n \n       "
				+ "               Welcome to the Smart Car! Please select your preferences! \n");
		
		try{
		jess.reset();
		
		jess.batch("AutomateCar/src/Rules.clp");
		
		jess.run();
		
		} catch(JessException ex){
			
			System.out.print("Couldnt run Jess");
			
		}
		
	}
	

	public int decreaseTemp(int temperature){
		
		return temperature-1 ;
		
		
		
	}
	
}
*/