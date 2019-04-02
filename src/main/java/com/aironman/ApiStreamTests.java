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
	public static void main(String[] args)
			throws FileNotFoundException, InterruptedException, ExecutionException, TimeoutException {

		boolean isEmExp = false;
		boolean isEm = false;
		boolean isPrimitiva = false;
		boolean all = false;
		boolean allWithExperimental = false;
		int numThreadsToRun = -1;

		// I am going to pass PATH_TO_Euromillion2004-2018.csv file and
		// PATH_TO_Primitiva.csv too.
		// The reason is that i want a docker image and maven did not create fine the
		// resources folders.
		if (args.length != 4) {
			showArguments();
			System.out.println("Insuficient arguments.");
			System.exit(-1);
		}

		isEm = "em".equalsIgnoreCase(args[0]);
		isPrimitiva = "primitiva".equalsIgnoreCase(args[0]);
		all = "all".equalsIgnoreCase(args[0]);
		isEmExp = "em-experimental".equalsIgnoreCase(args[0]);
		allWithExperimental = "all-experimental".equalsIgnoreCase(args[0]);

		if (!isEm && !isPrimitiva && !all && !isEmExp && !allWithExperimental) {
			System.out.println("isEm " + isEm);
			System.out.println("isPrimitiva " + isPrimitiva);
			System.out.println("isEmExp " + isEmExp);
			System.out.println("allWithExperimental " + allWithExperimental);
			showArguments();
			System.out.println("Wrong arguments.");
			System.exit(-1);
		}
		try {
			numThreadsToRun = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			System.out.println(e.getLocalizedMessage());
			System.exit(-1);
		}

		String pathToEM = args[2];
		String pathToPrimitiva = args[3];
		if (pathToEM == null || pathToPrimitiva == null) {
			System.out.println(
					"You must provide the paths of these files. Euromillions2004_2018.csv and Primitiva.csv. Check resources folder.");
			System.exit(-1);
		}

		int cores = Utils.getNumberOfCPUCores();
		System.out
				.println("There are " + cores + " physical cores. I will use the double for the executor thread pool.");
		ExecutorService executor = Executors.newFixedThreadPool(cores * 2);
		final int timeToRun=500;
		for (int i = 1; i <= numThreadsToRun; i++) {
			if (isEmExp) {
				Future<?> future = executor.submit(Utils.showSorteredValuesReversedOrder(pathToEM));
				future.get(timeToRun, TimeUnit.SECONDS);
			}

			else if (isEm) {
				Future<?> future = executor.submit(Utils.calculateRandomEM(pathToEM));
				future.get(timeToRun, TimeUnit.SECONDS);
			} else if (isPrimitiva) {
				Future<?> future = executor.submit(Utils.calculatePrimitiva(pathToPrimitiva));
				future.get(timeToRun, TimeUnit.SECONDS);
			}

			else if (all) {
				Future<?> futureRandomEM = executor.submit(Utils.calculateRandomEM(pathToEM));
				Future<?> futurePrimitive = executor.submit(Utils.calculatePrimitiva(pathToPrimitiva));
				futureRandomEM.get(timeToRun, TimeUnit.SECONDS);
				futurePrimitive.get(timeToRun, TimeUnit.SECONDS);
			} else if (allWithExperimental) {
				Future<?> futureSortered = executor.submit(Utils.showSorteredValuesReversedOrder(pathToEM));
				Future<?> futurePrimitive = executor.submit(Utils.calculatePrimitiva(pathToPrimitiva));
				futureSortered.get(timeToRun, TimeUnit.SECONDS);
				futurePrimitive.get(timeToRun, TimeUnit.SECONDS);
			}
		}

		shutdownThreads(executor);
		System.out.println("Done!");
		System.exit(0);
	}

	private static void showArguments() {
		System.out.println(
				"Use java -cp PATH_TO/MyStreamjava-8-1.0.jar com.aironman.ApiStreamTests em 8 PATH_TO_EM file PATH_TO_Primitiva file to show 8 euromillions prediction.");
		System.out.println(
				"Use java -cp PATH_TO/MyStreamjava-8-1.0.jar com.aironman.ApiStreamTests em-experimental 8 to PATH_TO_EM file PATH_TO_Primitiva file show euromillions drawing by superior frequency of appearance ordered discarding repeated. EXPERIMENTAL!");
		System.out.println(
				"Use java -cp PATH_TO/MyStreamjava-8-1.0.jar com.aironman.ApiStreamTests primitiva 8 PATH_TO_EM file PATH_TO_Primitiva file to show primitiva prediction.");
		System.out.println(
				"Use java -cp PATH_TO/MyStreamjava-8-1.0.jar com.aironman.ApiStreamTests all 8 PATH_TO_EM file PATH_TO_Primitiva file to show both predictions.");
		System.out.println(
				"Use java -cp PATH_TO/MyStreamjava-8-1.0.jar com.aironman.ApiStreamTests all-experimental 8 PATH_TO_EM file PATH_TO_Primitiva file to show both predictions with experimental euromillions.");
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
