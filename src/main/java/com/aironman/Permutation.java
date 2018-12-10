package com.aironman;

import java.util.Arrays;

public class Permutation {
	public static void permute(String[] arr) {
		System.out.println("There are " + factorial(arr.length) + " possible permutations.");
		int index = 0;
		permuteHelper(arr, index);

	}

	/***
	 * HINT!! i have to avoid duplicates in the array
	 * 
	 * @param arr
	 * @param index
	 */
	private static void permuteHelper(String[] arr, int index) {

		printPermutations(arr, index);

		for (int i = index; i < arr.length; i++) { // For each index in the sub array arr[index...end]

			// Swap the elements at indices index and i
			String t = arr[index];
			arr[index] = arr[i];
			arr[i] = t;

			// Recurse on the sub array arr[index+1...end]
			permuteHelper(arr, index + 1);

			// Swap the elements back
			t = arr[index];
			arr[index] = arr[i];
			arr[i] = t;
		}
	}

	private static void printPermutations(String[] arr, int index) {
		if (index >= arr.length - 1) { // If we are at the last element - nothing left to permute
			// Print the array
			for (int i = 0; i < arr.length - 1; i++) {
				if (i == 4) // i have to print with this particular format: 01,02,03,04,05,,07,08
					System.out.print(arr[i] + ",,");
				else
					System.out.print(arr[i] + ",");
			}
			if (arr.length > 0)
				System.out.print(arr[arr.length - 1]);
			System.out.println();
		}
	}

	static int factorial(double numero) {
		if (numero == 0)
			return 1;
		else
			return (int) (numero * factorial(numero - 1));
	}

	static boolean permuteLexically(int[] data) {
		int k = data.length - 2;
		while (data[k] >= data[k + 1]) {
			k--;
			if (k < 0) {
				return false;
			}
		}
		int l = data.length - 1;
		while (data[k] >= data[l]) {
			l--;
		}
		swap(data, k, l);
		int length = data.length - (k + 1);
		for (int i = 0; i < length / 2; i++) {
			swap(data, k + 1 + i, data.length - i - 1);
		}
		return true;
	}

	private static void swap(int[] data, int k, int l) {
		data[k] = data[k] + data[l];
		data[l] = data[k] - data[l];
		data[k] = data[k] - data[l];
	}

	static void permuteAndPrintWithoutDuplicates(String[] stringCombination) {
		
		int[] intCombination = new int[stringCombination.length];
		for (int i = 0; i < stringCombination.length; i++)
			intCombination[i] = Integer.valueOf(stringCombination[i]);
		Arrays.sort(intCombination);
		StringBuilder sbCombination = null;
		// System.out.println("There are " + Permutation.factorial(intCombination.length) + " possible permutations.");
		do {
			sbCombination = new StringBuilder();
			for (int i = 0; i <= intCombination.length - 1; i++) {
				sbCombination.append(intCombination[i]);
				if (i == 4) // i have to print with this particular format: 01,02,03,04,05,,07,08
					sbCombination.append(",,");
				else if (i!=6)
					sbCombination.append(",");
			}
			System.out.println(sbCombination.toString());
		} while (Permutation.permuteLexically(intCombination)); // this method avoids duplication.
	}

	public static void main(String[] args) {
		int[] data = { 1, 2, 3 };
		Arrays.sort(data);
		do {
			System.err.println(Arrays.toString(data));
		} while (permuteLexically(data));
	}
}
