package ui;

import java.util.Scanner;

import jess.JessException;
import jess.Rete;

public class main {
	
	
	public static void main(String[] args) throws JessException{
		
		Scanner tempMax = new Scanner(System.in);
		Scanner temp = new Scanner(System.in);
		Scanner tempMin = new Scanner(System.in);
		Scanner distMax = new Scanner(System.in);
		Scanner time = new Scanner(System.in);
		Scanner horasMax = new Scanner(System.in);
		int humidade, chuva, oxigenio, luminosidade;
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
