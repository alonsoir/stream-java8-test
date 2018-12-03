/**
 * 
 */
package com.aironman;

import java.io.FileNotFoundException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author aironman
 *
 */
public class ApiStreamTests {

	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws FileNotFoundException
	 * @throws TimeoutException 
	 * @throws ExecutionException 
	 */
	public static void main(String[] args) throws FileNotFoundException, InterruptedException, ExecutionException, TimeoutException {

		boolean isEmExp = false;
		boolean isEm = false;
		boolean isPrimitiva = false;
		boolean all = false;
		boolean allWithExperimental = false;
		int numThreadsToRun = -1;
		if (args.length != 2) {
			System.out.println("Use java -jar ApiStreamTests.jar em 8 to show euromillions prediction.");
			System.out.println(
					"Use java -jar ApiStreamTests.jar em-experimental 8 to show euromillions drawing by superior frequency of appearance ordered discarding repeated. EXPERIMENTAL!");
			System.out.println("Use java -jar ApiStreamTests.jar primitiva 8 to show primitiva prediction.");
			System.out.println("Use java -jar ApiStreamTests.jar all 8 to show both predictions.");
			System.out.println(
					"Use java -jar ApiStreamTests.jar all-experimental 8 to show both predictions with experimental euromillions.");
			System.out.println("Insuficient arguments.");
			System.exit(-1);
		}

		isEm = args[0] != null && args[0].equalsIgnoreCase("em");
		isPrimitiva = args[0] != null && args[0].equalsIgnoreCase("primitiva");
		all = args[0] != null && args[0].equalsIgnoreCase("all");
		isEmExp = args[0] != null && args[0].equalsIgnoreCase("em-experimental");
		allWithExperimental = args[0] != null && args[0].equalsIgnoreCase("all-experimental");
		try {
			numThreadsToRun = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			System.out.println(e.getLocalizedMessage());
			System.exit(-1);
		}
		// Runtime.getRuntime().availableProcessors();
		int cores = Utils.getNumberOfCPUCores();
		System.out.println("There are " + cores + " physical cores. I will use the double.");
		ExecutorService executor = Executors.newFixedThreadPool(cores * 2);
		
		if (args.length == 2) {
			if (!isEm && !isPrimitiva && !all && !isEmExp && !allWithExperimental) {
				System.out.println("Wrong argument. Must be em, primitiva, all, em-experimental or all-experimental. "
						+ args.length);
				System.out.println("isEm " + isEm);
				System.out.println("isPrimitiva " + isPrimitiva);
				System.out.println("all " + all);
				System.out.println("isEmExp " + isEmExp);
				System.out.println("allWithExperimental " + allWithExperimental);
				for (int i = 0; i < args.length; i++)
					System.out.println("args " + i + " " + args[i]);
				System.exit(-1);
			}
		}

		for (int i = 1; i <= numThreadsToRun; i++) {
			if (isEmExp) {
				Future<?> future = executor.submit(Utils.showSorteredValuesReversedOrder());
				future.get(5, TimeUnit.SECONDS);
			}

			else if (isEm) {
				Future<?> future = executor.submit(Utils.calculateRandomEM());
				future.get(5, TimeUnit.SECONDS);
			} else if (isPrimitiva) {
				Future <?> future = executor.submit(Utils.calculatePrimitiva());
				future.get(5, TimeUnit.SECONDS);
			}

			else if (all) {
				Future <?> futureRandomEM = executor.submit(Utils.calculateRandomEM());
				Future <?> futurePrimitive = executor.submit(Utils.calculatePrimitiva());
				futureRandomEM .get(5, TimeUnit.SECONDS);
				futurePrimitive.get(5, TimeUnit.SECONDS);
			} else if (allWithExperimental) {
				Future <?> futureSortered = executor.submit(Utils.showSorteredValuesReversedOrder());
				Future <?> futurePrimitive = executor.submit(Utils.calculatePrimitiva());
				futureSortered .get(5, TimeUnit.SECONDS);
				futurePrimitive.get(5, TimeUnit.SECONDS);
			}
		}

		shutdownThreads(executor);
		System.out.println("Done!");
		System.exit(0);
	}

	private static void shutdownThreads(ExecutorService executor) {
		try {
			System.out.println("attempt to shutdown executor");
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			System.err.println("tasks interrupted");
			System.exit(-1);
		} finally {
			if (!executor.isTerminated()) {
				System.err.println("cancel non-finished tasks");
			}
			executor.shutdownNow();
			System.out.println("shutdown finished");
		}
	}

}
