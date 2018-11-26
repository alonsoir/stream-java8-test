package com.aironman;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;
import java.util.concurrent.ThreadLocalRandom;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {

	static final String COMMA = ",";
	// private static Logger logger = LoggerFactory.getLogger(Utils.class);

	static List<EMPojo> processInputFile(String inputFilePath) throws FileNotFoundException {
		List<EMPojo> inputList = new ArrayList<EMPojo>();
		try {
			File inputF = new File(inputFilePath);
			InputStream inputFS = new FileInputStream(inputF);
			BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
			// skip the header of the csv
			inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
			br.close();
		} catch (IOException e) {
			// logger.error("FileNotFoundException or IOException ");
			e.printStackTrace();
		}
		return inputList;
	}

	static Function<String, EMPojo> mapToItem = (line) -> {
		String[] p = line.split(COMMA);// a CSV has comma separated lines
		EMPojo item = new EMPojo(Integer.parseInt(p[0]), Integer.parseInt(p[1]), Integer.parseInt(p[2]),
				Integer.parseInt(p[3]));
		return item;

	};

	static List<AnotherEMPojo> processHistoricInputFile(String inputFilePath) throws FileNotFoundException {
		List<AnotherEMPojo> inputList = new ArrayList<AnotherEMPojo>();
		try {
			File inputF = new File(inputFilePath);
			InputStream inputFS = new FileInputStream(inputF);
			BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
			// skip the header of the csv
			inputList = br.lines().skip(1).map(mapToHistoricItem).collect(Collectors.toList());
			br.close();
		} catch (IOException e) {
			// logger.error("FileNotFoundException or IOException ");
			e.printStackTrace();
		}
		return inputList;
	}

	static Function<String, AnotherEMPojo> mapToHistoricItem = (line) -> {
		// System.out.println("Processing line " + line);
		String[] p = line.split(COMMA);// a CSV has comma separated lines
		AnotherEMPojo item = new AnotherEMPojo();
		item.setDateContest(p[0]);
		item.setWiner1(Integer.parseInt(p[1]));
		item.setWiner2(Integer.parseInt(p[2]));
		item.setWiner3(Integer.parseInt(p[3]));
		item.setWiner4(Integer.parseInt(p[4]));
		item.setWiner5(Integer.parseInt(p[5]));
		// 6 and 7 are null values...
		item.setStar1(Integer.parseInt(p[7]));
		item.setStar2(Integer.parseInt(p[8]));
		return item;

	};

	static LinkedHashMap<Integer, Integer>  calculateMostFrequentValuesReversedOrder(Set<Entry<Integer, List<Integer>>> mySetwinner) {
		
		Iterator<Entry<Integer, List<Integer>>> iteratorSetWinner1 = mySetwinner.iterator();
		HashMap<Integer, Integer> aMap = new HashMap<Integer, Integer>();
		while (iteratorSetWinner1.hasNext()) {
			Entry<Integer, List<Integer>> it = iteratorSetWinner1.next();
			List<Integer> listValues = it.getValue();
			final Comparator<Integer> c = (p1, p2) -> Integer.compare(p1, p2);
			listValues.sort(c);
			aMap.put(it.getKey(), it.getValue().size());
		}
		// creating sorted map by value reversed order
		LinkedHashMap<Integer, Integer> aLinkedHM = aMap.entrySet().stream()
				.sorted(Collections.reverseOrder(comparingByValue()))
				.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		return aLinkedHM ;
	}
	
	/***
	 * I must refactor this method in order to achieve better perfomance. Probably there is too much data structures.
	 * @param mySetwinner
	 * @param type
	 */
	static void showRandomValuesReversedOrder(Set<Entry<Integer, List<Integer>>> mySetwinner, String type) {

		LinkedHashMap<Integer, Integer> aLinkedHM = calculateMostFrequentValuesReversedOrder(mySetwinner);

		int max = aLinkedHM.size();
		int min = 1;
		int key = ThreadLocalRandom.current().nextInt(min, max);
		Integer realKey = calculateRealKeyReverserOrder(aLinkedHM, max, min, key);
		
		Integer value = aLinkedHM.get(realKey );
		
		if (value == null)
			System.out.println("PROBLEM! Check showRandomValuesReversedOrder.");
		System.out.println("Selected " + type + "is " + realKey + " " + "frequency is " + value);
		// showing data...
		iterateAndShowRandomValuesReversedOrder(type, aLinkedHM);
	}

	private static void iterateAndShowRandomValuesReversedOrder(String type,
			LinkedHashMap<Integer, Integer> aLinkedHM) {
		Iterator<Entry<Integer, Integer>> itLK = aLinkedHM.entrySet().iterator();
		while (itLK.hasNext()) {
			Entry<Integer, Integer> it = itLK.next();
			System.out.println("*** DEBUG *** " + type + it.getKey() + " numTimes: " + it.getValue());
		}
		//System.out.println("Done " + type + "list and number of times sortered reversed by number of times! " + aLinkedHM.size());
	}

	private static Integer calculateRealKeyReverserOrder(LinkedHashMap<Integer, Integer> aLinkedHM, int max, int min,
			int key) {
		Object[] keySet = aLinkedHM.keySet().toArray();
		// System.out.println("max "+ max + " min " + min + " key " + key + " length " + keySet.length );
		HashMap<Integer,Integer> aMapWithKeys = new HashMap<Integer,Integer>();
		int internalKey=-1;
		int internalHashMapKey=1;
		for (int i=1;i<keySet.length;i++) {
			internalKey=(int) keySet[i];
			aMapWithKeys .put(internalHashMapKey, internalKey);
			// System.out.println("internalKey is " + internalKey + " internalHashMapKey is " + internalHashMapKey);
			internalHashMapKey++;
		}
		Integer realKey = aMapWithKeys.get(key);
		//System.out.println("realKey " + realKey );
		return realKey;
	}

	static void showStar1ReversedOrder(List<AnotherEMPojo> myListEMPojo) {
		// logger.debug("Star1 list and number of times sortered reversed by number of times: ");
		Set<Entry<Integer, List<Integer>>> mySetwinner = myListEMPojo.stream().map(o -> o.getStar1())
				.collect(Collectors.groupingBy(obj -> obj)).entrySet();

		Iterator<Entry<Integer, List<Integer>>> iteratorSetWinner1 = mySetwinner.iterator();
		HashMap<Integer, Integer> aMap = new HashMap<Integer, Integer>();
		while (iteratorSetWinner1.hasNext()) {
			Entry<Integer, List<Integer>> it = iteratorSetWinner1.next();
			List<Integer> listValues = it.getValue();
			final Comparator<Integer> c = (p1, p2) -> Integer.compare(p1, p2);
			listValues.sort(c);
			aMap.put(it.getKey(), it.getValue().size());
		}
		// creating sorted map by value reversed order
		LinkedHashMap<Integer, Integer> aLinkedHM = aMap.entrySet().stream()
				.sorted(Collections.reverseOrder(comparingByValue()))
				.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		/*
		 * Iterator<Entry<Integer, Integer>> itLK = aLinkedHM.entrySet().iterator();
		 * while (itLK.hasNext()) { Entry<Integer, Integer> it = itLK.next();
		 * logger.debug("star1: " + it.getKey() + " numTimes: " + it.getValue()); }
		 */
		// logger.debug("Done star1 list and number of times sortered reversed by number of times! " + aLinkedHM.size());
	}

	static void showStar2ReversedOrder(List<AnotherEMPojo> myListEMPojo) {
		// logger.debug("Star2 list and number of times sortered reversed by number of times: ");
		Set<Entry<Integer, List<Integer>>> mySetwinner = myListEMPojo.stream().map(o -> o.getStar2())
				.collect(Collectors.groupingBy(obj -> obj)).entrySet();

		Iterator<Entry<Integer, List<Integer>>> iteratorSetWinner1 = mySetwinner.iterator();
		HashMap<Integer, Integer> aMap = new HashMap<Integer, Integer>();
		while (iteratorSetWinner1.hasNext()) {
			Entry<Integer, List<Integer>> it = iteratorSetWinner1.next();
			List<Integer> listValues = it.getValue();
			final Comparator<Integer> c = (p1, p2) -> Integer.compare(p1, p2);
			listValues.sort(c);
			aMap.put(it.getKey(), it.getValue().size());
		}
		// creating sorted map by value reversed order
		LinkedHashMap<Integer, Integer> aLinkedHM = aMap.entrySet().stream()
				.sorted(Collections.reverseOrder(comparingByValue()))
				.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		/*
		 * Iterator<Entry<Integer, Integer>> itLK = aLinkedHM.entrySet().iterator();
		 * while (itLK.hasNext()) { Entry<Integer, Integer> it = itLK.next();
		 * logger.debug("star2: " + it.getKey() + " numTimes: " + it.getValue()); }
		 */
		// logger.debug("Done star2 list and number of times sortered reversed by number of times! " + aLinkedHM.size());
	}

	static void showWinner1ReversedOrder(List<AnotherEMPojo> myListEMPojo) {
		// logger.debug("Winer1 list and number of times sortered reversed by number of times: ");
		Set<Entry<Integer, List<Integer>>> mySetwinner = myListEMPojo.stream().map(o -> o.getWiner1())
				.collect(Collectors.groupingBy(obj -> obj)).entrySet();

		Iterator<Entry<Integer, List<Integer>>> iteratorSetWinner1 = mySetwinner.iterator();
		HashMap<Integer, Integer> aMap = new HashMap<Integer, Integer>();
		while (iteratorSetWinner1.hasNext()) {
			Entry<Integer, List<Integer>> it = iteratorSetWinner1.next();
			List<Integer> listValues = it.getValue();
			final Comparator<Integer> c = (p1, p2) -> Integer.compare(p1, p2);
			listValues.sort(c);
			aMap.put(it.getKey(), it.getValue().size());
		}
		// creating sorted map by value reversed order
		LinkedHashMap<Integer, Integer> aLinkedHM = aMap.entrySet().stream()
				.sorted(Collections.reverseOrder(comparingByValue()))
				.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		/*
		 * Iterator<Entry<Integer, Integer>> itLK = aLinkedHM.entrySet().iterator();
		 * while (itLK.hasNext()) { Entry<Integer, Integer> it = itLK.next();
		 * logger.debug("winner2: " + it.getKey() + " numTimes: " + it.getValue()); }
		 */
		// logger.debug("Done Winer2 list and number of times sortered reversed by number of times! " + aLinkedHM.size());
	}

	static void showWinner2ReversedOrder(List<AnotherEMPojo> myListEMPojo) {
		// logger.debug("Winer2 list and number of times sortered reversed by number of times: ");
		Set<Entry<Integer, List<Integer>>> mySetwinner = myListEMPojo.stream().map(o -> o.getWiner2())
				.collect(Collectors.groupingBy(obj -> obj)).entrySet();

		Iterator<Entry<Integer, List<Integer>>> iteratorSetWinner1 = mySetwinner.iterator();
		HashMap<Integer, Integer> aMap = new HashMap<Integer, Integer>();
		while (iteratorSetWinner1.hasNext()) {
			Entry<Integer, List<Integer>> it = iteratorSetWinner1.next();
			List<Integer> listValues = it.getValue();
			final Comparator<Integer> c = (p1, p2) -> Integer.compare(p1, p2);
			listValues.sort(c);
			aMap.put(it.getKey(), it.getValue().size());
		}
		// creating sorted map by value reversed order
		LinkedHashMap<Integer, Integer> aLinkedHM = aMap.entrySet().stream()
				.sorted(Collections.reverseOrder(comparingByValue()))
				.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		/*
		 * Iterator<Entry<Integer, Integer>> itLK = aLinkedHM.entrySet().iterator();
		 * while (itLK.hasNext()) { Entry<Integer, Integer> it = itLK.next();
		 * logger.debug("winner2: " + it.getKey() + " numTimes: " + it.getValue()); }
		 */
		// logger.debug("Done Winer2 list and number of times sortered reversed by number of times!  " + aLinkedHM.size());
	}

	static void showWinner3ReversedOrder(List<AnotherEMPojo> myListEMPojo) {
		// logger.debug("Winer3 list and number of times sortered reversed by number of times: ");
		Set<Entry<Integer, List<Integer>>> mySetwinner = myListEMPojo.stream().map(o -> o.getWiner3())
				.collect(Collectors.groupingBy(obj -> obj)).entrySet();

		Iterator<Entry<Integer, List<Integer>>> iteratorSetWinner1 = mySetwinner.iterator();
		HashMap<Integer, Integer> aMap = new HashMap<Integer, Integer>();
		while (iteratorSetWinner1.hasNext()) {
			Entry<Integer, List<Integer>> it = iteratorSetWinner1.next();
			List<Integer> listValues = it.getValue();
			final Comparator<Integer> c = (p1, p2) -> Integer.compare(p1, p2);
			listValues.sort(c);
			aMap.put(it.getKey(), it.getValue().size());
		}
		// creating sorted map by value reversed order
		LinkedHashMap<Integer, Integer> aLinkedHM = aMap.entrySet().stream()
				.sorted(Collections.reverseOrder(comparingByValue()))
				.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		/*
		 * Iterator<Entry<Integer, Integer>> itLK = aLinkedHM.entrySet().iterator();
		 * while (itLK.hasNext()) { Entry<Integer, Integer> it = itLK.next();
		 * logger.debug("winner3: " + it.getKey() + " numTimes: " + it.getValue()); }
		 */
		// logger.debug("Done Winer3 list and number of times sortered reversed by number of times! " + aLinkedHM.size());
	}

	static void showWinner4ReversedOrder(List<AnotherEMPojo> myListEMPojo) {
		// logger.debug("Winer4 list and number of times sortered reversed by number of times: ");
		Set<Entry<Integer, List<Integer>>> mySetwinner = myListEMPojo.stream().map(o -> o.getWiner4())
				.collect(Collectors.groupingBy(obj -> obj)).entrySet();

		Iterator<Entry<Integer, List<Integer>>> iteratorSetWinner1 = mySetwinner.iterator();
		HashMap<Integer, Integer> aMap = new HashMap<Integer, Integer>();
		while (iteratorSetWinner1.hasNext()) {
			Entry<Integer, List<Integer>> it = iteratorSetWinner1.next();
			List<Integer> listValues = it.getValue();
			final Comparator<Integer> c = (p1, p2) -> Integer.compare(p1, p2);
			listValues.sort(c);
			aMap.put(it.getKey(), it.getValue().size());
		}
		// creating sorted map by value reversed order
		LinkedHashMap<Integer, Integer> aLinkedHM = aMap.entrySet().stream()
				.sorted(Collections.reverseOrder(comparingByValue()))
				.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		/*
		 * Iterator<Entry<Integer, Integer>> itLK = aLinkedHM.entrySet().iterator();
		 * while (itLK.hasNext()) { Entry<Integer, Integer> it = itLK.next();
		 * logger.debug("winner4: " + it.getKey() + " numTimes: " + it.getValue()); }
		 */
		// logger.debug("Done Winer4 list and number of times sortered reversed by number of times! " + aLinkedHM.size());
	}

	static void showWinner5ReversedOrder(List<AnotherEMPojo> myListEMPojo) {
		// logger.debug("Winer5 list and number of times sortered reversed by number of times: ");
		Set<Entry<Integer, List<Integer>>> mySetwinner = myListEMPojo.stream().map(o -> o.getWiner5())
				.collect(Collectors.groupingBy(obj -> obj)).entrySet();

		Iterator<Entry<Integer, List<Integer>>> iteratorSetWinner1 = mySetwinner.iterator();
		HashMap<Integer, Integer> aMap = new HashMap<Integer, Integer>();
		while (iteratorSetWinner1.hasNext()) {
			Entry<Integer, List<Integer>> it = iteratorSetWinner1.next();
			List<Integer> listValues = it.getValue();
			final Comparator<Integer> c = (p1, p2) -> Integer.compare(p1, p2);
			listValues.sort(c);
			aMap.put(it.getKey(), it.getValue().size());
		}
		// creating sorted map by value reversed order
		LinkedHashMap<Integer, Integer> aLinkedHM = aMap.entrySet().stream()
				.sorted(Collections.reverseOrder(comparingByValue()))
				.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		/*
		 * Iterator<Entry<Integer, Integer>> itLK = aLinkedHM.entrySet().iterator();
		 * while (itLK.hasNext()) { Entry<Integer, Integer> it = itLK.next();
		 * logger.debug("winner5: " + it.getKey() + " numTimes: " + it.getValue()); }
		 */
		// logger.debug("Done Winer5 list and number of times sortered reversed by number of times! " + aLinkedHM.size());
	}

	static void calculateEM() {
		String inputFilePath = "src/main/resources/Euromillones2004_2018.csv";

		try {
			List<AnotherEMPojo> myListEMPojo = Utils.processHistoricInputFile(inputFilePath);
			Set<Entry<Integer, List<Integer>>> mySetStar1 = myListEMPojo.stream().map(o -> o.getStar1())
					.collect(Collectors.groupingBy(obj -> obj)).entrySet();
			Utils.showRandomValuesReversedOrder(mySetStar1, "Star1 ");

			Set<Entry<Integer, List<Integer>>> mySetStar2 = myListEMPojo.stream().map(o -> o.getStar2())
					.collect(Collectors.groupingBy(obj -> obj)).entrySet();
			Utils.showRandomValuesReversedOrder(mySetStar2, "Star2 ");

			Set<Entry<Integer, List<Integer>>> mySetWinner1 = myListEMPojo.stream().map(o -> o.getWiner1())
					.collect(Collectors.groupingBy(obj -> obj)).entrySet();
			Utils.showRandomValuesReversedOrder(mySetWinner1, "Winner1 ");

			Set<Entry<Integer, List<Integer>>> mySetWinner2 = myListEMPojo.stream().map(o -> o.getWiner2())
					.collect(Collectors.groupingBy(obj -> obj)).entrySet();
			Utils.showRandomValuesReversedOrder(mySetWinner2, "Winner2 ");

			Set<Entry<Integer, List<Integer>>> mySetWinner3 = myListEMPojo.stream().map(o -> o.getWiner3())
					.collect(Collectors.groupingBy(obj -> obj)).entrySet();
			Utils.showRandomValuesReversedOrder(mySetWinner3, "Winner3 ");

			Set<Entry<Integer, List<Integer>>> mySetWinner4 = myListEMPojo.stream().map(o -> o.getWiner4())
					.collect(Collectors.groupingBy(obj -> obj)).entrySet();
			Utils.showRandomValuesReversedOrder(mySetWinner4, "Winner4 ");

			Set<Entry<Integer, List<Integer>>> mySetWinner5 = myListEMPojo.stream().map(o -> o.getWiner5())
					.collect(Collectors.groupingBy(obj -> obj)).entrySet();
			Utils.showRandomValuesReversedOrder(mySetWinner5, "Winner5 ");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error, file Euromillones2004_2018.csv not found.");
		}
	}

	static void calculatePrimitiva() {
		// reading historico_euromillones.csv
		String inputFilePath = "src/main/resources/primitiva.csv";

		try {
			List<EMPojo> myListEMPojo = Utils.processInputFile(inputFilePath);
			final Comparator<EMPojo> compTotal2017 = (p1, p2) -> Integer.compare(p1.getTotal_2017(),
					p2.getTotal_2017());
			final Comparator<EMPojo> compTotal2018 = (p1, p2) -> Integer.compare(p1.getTotal_2018(),
					p2.getTotal_2018());
			long maxSize = 7l;

			System.out.println("Primitiva 2017. ");
			myListEMPojo.stream().sorted(compTotal2017.reversed()) // sort from max to min
					.limit(maxSize).forEach(e -> System.out.println(e.toString()));

			System.out.println("Primitiva 2018. ");
			myListEMPojo.stream().sorted(compTotal2018.reversed()) // sort from max to min
					.limit(maxSize).forEach(e -> System.out.println(e.toString()));

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Error, file primitiva.csv not found");
		}
	}

}
