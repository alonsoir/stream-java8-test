/**
 * 
 */
package com.aironman;

/**
 * @author aironman
 *
 */
public class ApiStreamTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		boolean isEm =false;
		boolean isPrimitiva = false;
		boolean all = false;
		if (args.length != 1) {
			System.out.println("Use java -jar ApiStreamTests.jar em to show euromillions prediction.");
			System.out.println("Use java -jar ApiStreamTests.jar primitiva to show primitiva prediction.");
			System.out.println("Use java -jar ApiStreamTests.jar all to show both predictions.");
			System.out.println("Insuficient arguments.");
			System.exit(-1);
		}
		
		isEm = args[0] != null && args[0].equalsIgnoreCase("em");
		isPrimitiva = args[0] != null && args[0].equalsIgnoreCase("primitiva");
		all =args[0] !=null && args[0].equalsIgnoreCase("all");
		
		if (args.length == 1) {
			if (!isEm && !isPrimitiva && !all) {
				System.out.println("Wrong argument. Must be em, primitiva or all.");
				System.exit(-1);
			}
		}
		
		
		if (isEm)
			Utils.calculateEM();
		else
		if (isPrimitiva)
			Utils.calculatePrimitiva();
		else
		if (all) {
			Utils.calculateEM();
			Utils.calculatePrimitiva();
		}
		System.out.println("Done!");
		System.exit(0);
	}

}
