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

		boolean isEmExp=false;
		boolean isEm =false;
		boolean isPrimitiva = false;
		boolean all = false;
		boolean allWithExperimental=false;
		if (args.length != 1) {
			System.out.println("Use java -jar ApiStreamTests.jar em to show euromillions prediction.");
			System.out.println("Use java -jar ApiStreamTests.jar em-experimental to show euromillions drawing by superior frequency of appearance ordered discarding repeated. EXPERIMENTAL!");
			System.out.println("Use java -jar ApiStreamTests.jar primitiva to show primitiva prediction.");
			System.out.println("Use java -jar ApiStreamTests.jar all to show both predictions.");
			System.out.println("Use java -jar ApiStreamTests.jar all-experimental to show both predictions with experimental euromillions.");
			System.out.println("Insuficient arguments.");
			System.exit(-1);
		}
		
		isEm = args[0] != null && args[0].equalsIgnoreCase("em");
		isPrimitiva = args[0] != null && args[0].equalsIgnoreCase("primitiva");
		all =args[0] !=null && args[0].equalsIgnoreCase("all");
		isEmExp = args[0] != null && args[0].equalsIgnoreCase("em-experimental");
		allWithExperimental=args[0] != null && args[0].equalsIgnoreCase("all-experimental");
		
		if (args.length == 1) {
			if (!isEm && !isPrimitiva && !all && !isEmExp  && !allWithExperimental) {
				System.out.println("Wrong argument. Must be em, primitiva, all, em-experimental or all-experimental.");
				System.exit(-1);
			}
		}
		
		if (isEmExp)
			Utils.showSorteredValuesReversedOrder();
		else
		if (isEm)
			Utils.calculateRandomEM();
		else
		if (isPrimitiva)
			Utils.calculatePrimitiva();
		else
		if (all) {
			Utils.calculateRandomEM();
			Utils.calculatePrimitiva();
		}
		else
		if (allWithExperimental) {
			Utils.showSorteredValuesReversedOrder();
			Utils.calculatePrimitiva();
		}
		System.out.println("Done!");
		System.exit(0);
	}

}
