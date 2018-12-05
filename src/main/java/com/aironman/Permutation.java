package com.aironman;

public class Permutation {
	public static void permute(String[] arr) {
		System.out.println("There are " + factorial(arr.length) + " possible permutations.");
		permuteHelper(arr, 0);
	}

	private static void permuteHelper(String[] arr, int index) {

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
			// System.out.println("]");
			System.out.println();
			return;
		}

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

	private static int factorial(double numero) {
		if (numero == 0)
			return 1;
		else
			return (int) (numero * factorial(numero - 1));
	}
}
