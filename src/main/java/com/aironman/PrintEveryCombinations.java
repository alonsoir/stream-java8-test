package com.aironman;

/***
 * I want that this main class receives a combination, create all permutations and scan them in a file.
 * @author aironman
 *
 */
public class PrintEveryCombinations {

	/***
	 * 
	 * @param args 0 is the name of the process, 1 is the array
	 * I am going to print out every combination
	 */
	public static void main(String[] args) {
		
		if (args.length!=1) {
			System.out.println("Insufficient arguments. Try with java -cp MyStreamjava8.jar com.aironman.PrintEveryCombinations 1,2,3,4,5,6,7");
			System.exit(-1);
		}
		String combination = args[0];
		System.out.println("Initial combination " + combination);
		String [] stringCombination = combination.split(",");
		Permutation.permute(stringCombination);
		System.out.println("Done!");
		
	}

}
