package com.aironman;

import java.util.Arrays;

/***
 * I want that this main class receives a file with combinations, generates the permutations of each combination and
 * print to the terminal. The script will catch all permutations and check with Euromillones2004_2018.csv
 * @author aironman
 *
 */
public class PrintEveryPermutation {

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
		// this method do not avoid duplicates!
		// Permutation.permute(stringCombination);
		Permutation.permuteAndPrintWithoutDuplicates(stringCombination);
		System.out.println("Done permutations! ");
		
	}

	

}
