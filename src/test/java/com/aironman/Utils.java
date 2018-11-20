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

public class Utils {

	static final String COMMA = ",";

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
			System.out.println("FileNotFoundException or IOException ");
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
			System.out.println("FileNotFoundException or IOException ");
			e.printStackTrace();
		}
		return inputList;
	}
	
	static Function<String, AnotherEMPojo> mapToHistoricItem = (line) -> {
		String[] p = line.split(COMMA);// a CSV has comma separated lines
		AnotherEMPojo item = new AnotherEMPojo();
		item .setDateContest(p[0]);
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
	
	static void showValueReversedOrder(Set<Entry<Integer, List<Integer>>> mySetwinner,String type) {
		System.out.println(type + "list and number of times sortered reversed by number of times: ");
		

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
		
		int max = aLinkedHM.size();
		int min=1;
		int key = ThreadLocalRandom.current().nextInt(min, max + 1);
		
		Integer value = aLinkedHM.get(key);
		
		System.out.println("type: " + type + " number is " + key + " " + "frecuncy is " + value );
		// showing data...
		// Iterator<Entry<Integer, Integer>> itLK = aLinkedHM.entrySet().iterator();
		// while (itLK.hasNext()) {
		// Entry<Integer, Integer> it = itLK.next();
		//	System.out.println(type + it.getKey() + " numTimes: " + it.getValue());
		//}
		System.out.println("Done " + type + "list and number of times sortered reversed by number of times! " + aLinkedHM.size());
	}
	
	
	static void showStar1ReversedOrder(List<AnotherEMPojo> myListEMPojo) {
		System.out.println("Star1 list and number of times sortered reversed by number of times: ");
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
		Iterator<Entry<Integer, Integer>> itLK = aLinkedHM.entrySet().iterator();
		while (itLK.hasNext()) {
			Entry<Integer, Integer> it = itLK.next();
			System.out.println("star1: " + it.getKey() + " numTimes: " + it.getValue());
		}*/
		System.out.println("Done star1 list and number of times sortered reversed by number of times! " + aLinkedHM.size());
	}
	
	static void showStar2ReversedOrder(List<AnotherEMPojo> myListEMPojo) {
		System.out.println("Star2 list and number of times sortered reversed by number of times: ");
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
		Iterator<Entry<Integer, Integer>> itLK = aLinkedHM.entrySet().iterator();
		while (itLK.hasNext()) {
			Entry<Integer, Integer> it = itLK.next();
			System.out.println("star2: " + it.getKey() + " numTimes: " + it.getValue());
		}*/
		System.out.println("Done star2 list and number of times sortered reversed by number of times! " + aLinkedHM.size());
	}
	
	
	static void showWinner1ReversedOrder(List<AnotherEMPojo> myListEMPojo) {
		System.out.println("Winer1 list and number of times sortered reversed by number of times: ");
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
		Iterator<Entry<Integer, Integer>> itLK = aLinkedHM.entrySet().iterator();
		while (itLK.hasNext()) {
			Entry<Integer, Integer> it = itLK.next();
			System.out.println("winner2: " + it.getKey() + " numTimes: " + it.getValue());
		}*/
		System.out.println("Done Winer2 list and number of times sortered reversed by number of times! " + aLinkedHM.size());
	}

	static void showWinner2ReversedOrder(List<AnotherEMPojo> myListEMPojo) {
		System.out.println("Winer2 list and number of times sortered reversed by number of times: ");
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
		Iterator<Entry<Integer, Integer>> itLK = aLinkedHM.entrySet().iterator();
		while (itLK.hasNext()) {
			Entry<Integer, Integer> it = itLK.next();
			System.out.println("winner2: " + it.getKey() + " numTimes: " + it.getValue());
		}*/
		System.out.println("Done Winer2 list and number of times sortered reversed by number of times!  " + aLinkedHM.size());
	}

	static void showWinner3ReversedOrder(List<AnotherEMPojo> myListEMPojo) {
		System.out.println("Winer3 list and number of times sortered reversed by number of times: ");
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
		Iterator<Entry<Integer, Integer>> itLK = aLinkedHM.entrySet().iterator();
		while (itLK.hasNext()) {
			Entry<Integer, Integer> it = itLK.next();
			System.out.println("winner3: " + it.getKey() + " numTimes: " + it.getValue());
		}*/
		System.out.println("Done Winer3 list and number of times sortered reversed by number of times! " + aLinkedHM.size());
	}

	static void showWinner4ReversedOrder(List<AnotherEMPojo> myListEMPojo) {
		System.out.println("Winer4 list and number of times sortered reversed by number of times: ");
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
		Iterator<Entry<Integer, Integer>> itLK = aLinkedHM.entrySet().iterator();
		while (itLK.hasNext()) {
			Entry<Integer, Integer> it = itLK.next();
			System.out.println("winner4: " + it.getKey() + " numTimes: " + it.getValue());
		}*/
		System.out.println("Done Winer4 list and number of times sortered reversed by number of times! " + aLinkedHM.size());
	}

	static void showWinner5ReversedOrder(List<AnotherEMPojo> myListEMPojo) {
		System.out.println("Winer5 list and number of times sortered reversed by number of times: ");
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
		Iterator<Entry<Integer, Integer>> itLK = aLinkedHM.entrySet().iterator();
		while (itLK.hasNext()) {
			Entry<Integer, Integer> it = itLK.next();
			System.out.println("winner5: " + it.getKey() + " numTimes: " + it.getValue());
		}*/
		System.out.println("Done Winer5 list and number of times sortered reversed by number of times! " + aLinkedHM.size());
	}
	
	
}
