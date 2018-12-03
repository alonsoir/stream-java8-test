/**
 * 
 */
package com.aironman;

import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;

/**
 * @author aironman
 *
 */
public class StreamTests {

	private static List<Product> productsList = new ArrayList<Product>();
	private static Logger logger = LoggerFactory.getLogger(StreamTests.class);

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		// @Before runs after every test execution.
		productsList.clear();
		// Adding Products
		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));
		logger.debug("setUp. productsList.size: " + productsList.size());
		logger.debug("Done setUp.");
	}

	@Test
	public void testFilteringByPrice() {
		// filtering by price, creating a map with filtered prices.
		List<Float> listPrices = productsList.stream().filter(aProduct -> aProduct.getPrice() <= 28000f)
				.map(aProduct -> aProduct.getPrice()).collect(Collectors.toList());

		// iterating over list
		// listPrices.forEach(e->logger.debug(String.valueOf(e)));
		listPrices.forEach(Assert::assertNotNull);

	}

	@Test
	public void testCompactFilteringByPrice() {
		// This more compact approach for filtering data
		// productsList.stream().filter(product -> product.getPrice() ==
		// 30000).forEach(product -> logger.debug(String.valueOf(product.getPrice())));

		productsList.stream().filter(product -> product.getPrice() == 30000)
				.forEach(product -> Assert.assertNotNull(product.getPrice()));

	}

	@Test
	public void testUsingCollector_to_sum_prices() {
		// Using Collectors's method to sum the prices.
		double totalPrice3 = productsList.stream().collect(Collectors.summingDouble(product -> product.getPrice()));
		logger.debug("total sum " + totalPrice3);
		Assert.assertNotNull(Double.toString(totalPrice3));
	}

	@Test
	public void testGetMaxProductPrice() {
		// max() method to get max Product price
		Product productA = productsList.stream()
				.max((product1, product2) -> product1.getPrice() > product2.getPrice() ? 1 : -1).get();

		logger.debug("max product price " + productA.getPrice());
		Assert.assertNotNull(productA);
	}

	@Test
	public void testGetMinProductPrice() {
		// min() method to get min Product price
		Product productB = productsList.stream()
				.max((product1, product2) -> product1.getPrice() < product2.getPrice() ? 1 : -1).get();
		logger.debug("min product price " + productB.getPrice());
		Assert.assertNotNull(productB);
	}

	@Test
	public void testConvertingProductListToSet() {
		// Converting product List into Set
		Set<Float> productPriceSet = productsList.stream().filter(product -> product.getPrice() < 30000)
				.map(product -> product.getPrice()).collect(Collectors.toSet());
		logger.debug("productPriceSet " + productPriceSet);
		Assert.assertNotNull(productPriceSet);
		int expected = 2;
		Assert.assertEquals(expected, productPriceSet.size());
	}

	@Test
	public void testConvertingProductListToMap() {
		// Converting Product List into a Map
		Map<Integer, String> productPriceMap = productsList.stream()
				.collect(Collectors.toMap(p -> p.getId(), p -> p.getName()));
		logger.debug("productPriceMap " + productPriceMap);
		int expected = 5;
		Assert.assertEquals("Should be five...", expected, productPriceMap.size());

		List<Float> productPriceList = productsList.stream().filter(p -> p.getPrice() > 30000)// filtering data
				.map(Product::getPrice) // fetching price by referring getPrice method
				.collect(Collectors.toList()); // collecting as list
		logger.debug("productPriceList " + productPriceList);
		expected = 1;
		Assert.assertEquals("Should be only one...", expected, productPriceList.size());
	}

	@Test
	public void testParallelFilteringByPriceCreatingMap() {
		// parallel
		logger.debug("Now parallelizing...");

		// filtering by price, creating a map with filtered prices.
		List<Float> listPricesP = productsList.parallelStream().filter(aProduct -> aProduct.getPrice() <= 28000f)
				.map(aProduct -> aProduct.getPrice()).collect(Collectors.toList());

		// iterating over list
		// listPricesP.forEach(e->logger.debug(String.valueOf(e)));

		listPricesP.forEach(Assert::assertNotNull);
		int expected = 3;
		Assert.assertEquals("Should be three... ", expected, listPricesP.size());

	}

	@Test
	public void testParallelCompactApproachFilteringData() {
		// This more compact approach for filtering data
		// productsList.parallelStream().filter(product -> product.getPrice() ==
		// 30000).forEach(product -> logger.debug(String.valueOf(product.getPrice())));

		productsList.parallelStream().filter(product -> product.getPrice() == 30000)
				.forEach(product -> Assert.assertNotNull(product.getPrice()));

	}

	@Test
	public void testParallelUsingCollectorToSumPrices() {
		// Using Collectors's method to sum the prices.
		double totalPrice3P = productsList.parallelStream()
				.collect(Collectors.summingDouble(product -> product.getPrice()));
		logger.debug("total sum " + totalPrice3P);

		Assert.assertNotNull("Should be not nulll... ", Double.toString(totalPrice3P));

		Assert.assertEquals("Should be 201000.0d.", 201000.0d, totalPrice3P, 0);
	}

	@Test
	public void testParallelMaxMethodToGetProductPrice() {
		// max() method to get max Product price
		Product productA_P = productsList.parallelStream()
										 .max((product1, product2) -> product1.getPrice() > product2.getPrice() ? 1 : -1).get();

		logger.debug("max product price " + productA_P.getPrice());

		Assert.assertNotNull(productA_P);
		float expected = 90000.0f;
		Assert.assertEquals("Should be 90000", expected, productA_P.getPrice(), 0f);
	}

	@Test
	public void testParallelMinMethodToGetMinProductPrice() {
		// min() method to get min Product price
		Product productB_P = productsList.parallelStream()
				.max((product1, product2) -> product1.getPrice() < product2.getPrice() ? 1 : -1).get();
		logger.debug("min product price " + productB_P.getPrice());

		Assert.assertNotNull(productB_P);
		float expected = 25000.0f;
		Assert.assertEquals("Should be 25000.0", expected, productB_P.getPrice(), 0f);
	}

	@Test
	public void testParallelConvertProductListToSet() {
		// Converting product List into Set
		Set<Float> productPriceSet_P = productsList.parallelStream().filter(product -> product.getPrice() < 30000)
				.map(product -> product.getPrice()).collect(Collectors.toSet());
		logger.debug("productPriceSet " + productPriceSet_P);

		Assert.assertNotNull(productPriceSet_P);
		int expected = 2;
		Assert.assertEquals("Should be two...", expected, productPriceSet_P.size());
	}

	@Test
	public void testParallelConvertProductListToMap() {
		// Converting Product List into a Map
		Map<Integer, String> productPriceMap_P = productsList.parallelStream()
				.collect(Collectors.toMap(p -> p.getId(), p -> p.getName()));
		logger.debug("productPriceMap " + productPriceMap_P);
		int expected = 5;
		Assert.assertEquals("Should be five.", expected, productPriceMap_P.size());
		List<Float> productPriceList_P = productsList.parallelStream().filter(p -> p.getPrice() > 30000) // filtering
																											// data
				.map(Product::getPrice) // fetching price by referring getPrice method
				.collect(Collectors.toList()); // collecting as list

		logger.debug("productPriceList " + productPriceList_P);
		expected = 1;
		Assert.assertEquals("Should be one...", expected, productPriceList_P.size());
	}

	@Test
	public void testCreatingStreamFromCollections() {
		// Creating stream from collection, set or array

		logger.debug("Creating stream from collection, set or array...");
		Collection<String> collection = Arrays.asList("JAVA", "J2EE", "Spring", "Hibernate");
		Stream<String> stream2 = collection.stream();
		stream2.forEach(e -> Assert.assertNotNull(e));
		List<String> list = Arrays.asList("JAVA-8", "J2EE-8", "SpringCore", "HibernateShit");
		Stream<String> stream3 = list.stream();
		stream3.forEach(e -> Assert.assertNotNull(e));
		Set<String> set = new HashSet<>(list);
		Stream<String> stream4 = set.stream();
		stream4.forEach(Assert::assertNotNull);

		// Array can also be a source of a Stream
		logger.debug("Array can also be a source of a Stream...");
		Stream<String> streamOfArray = Stream.of("a", "b", "c");
		streamOfArray.forEach(e -> assertNotNull(e));
		// creating from existing array or of a part of an array:
		String[] arr = new String[] { "a1", "b1", "c1" };
		Stream<String> streamOfArrayFull = Arrays.stream(arr);
		streamOfArrayFull.forEach(e -> Assert.assertNotNull(e));
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
		streamOfArrayPart.forEach(Assert::assertNotNull);
	}

	@Test
	public void testCreatingStreamFromStreamBuilder() {
		// from streamBuilder
		logger.debug("from streamBuilder...");
		Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();
		streamBuilder.forEach(Assert::assertNotNull);
	}

	@Test
	public void testCreatingStreamFromStreamGenerate() {
		// From Stream.generate()...
		logger.debug("From Stream.generate()...");
		Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);
		streamGenerated.forEach(Assert::assertNotNull);
	}

	@Test
	public void testCreatingStreamFromStreamIterate() {

		// From Stream.iterate()
		logger.debug("From Stream.iterate()...");
		Stream<Integer> streamIterated = Stream.iterate(1, n -> n + 2).limit(5);
		streamIterated.forEach(Assert::assertNotNull);
	}

	@Test
	public void testCreatingStreamFromStreamFile() {
		// Stream of File
		logger.debug("Stream of File...");
		// absolut path...
		Path path = Paths.get("src/test/resources/pmd-eclipse.log");
		Stream<String> streamOfStrings;
		try {
			streamOfStrings = Files.lines(path);
			Stream<String> streamWithCharset = Files.lines(path, Charset.forName("UTF-8"));
			streamOfStrings.forEach(Assert::assertNotNull);
			streamWithCharset.forEach(Assert::assertNotNull);
			streamOfStrings.close();
			streamWithCharset.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getLocalizedMessage());
			Assert.assertNotNull("IOException", null);
		}
	}

	@Test
	public void testCreatingStreamFromStreamOfPrimitives() {
		// Stream of Primitives
		logger.debug("Stream of Primitives...");
		IntStream intStream = IntStream.range(1, 3);
		intStream.forEach(Assert::assertNotNull);
		LongStream longStream = LongStream.rangeClosed(1, 3);
		Assert.assertNotNull(longStream);
		// longStream.forEach(e->logger.debug(String.valueOf(e)));
		Random random = new Random();
		DoubleStream doubleStream = random.doubles(3);
		doubleStream.forEach(Assert::assertNotNull);
	}

	@Test
	public void testSortingHashMapByValue() {
		// sorting a hashMap by value
		Map<String, Integer> map = new HashMap<String, Integer>();
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		map.put("a", 21);
		map.put("b", 10);
		map.put("c", 12);
		map.put("d", 20);
		map.entrySet().stream().sorted((o1, o2) -> o1.getValue().compareTo(o2.getValue())).map(e -> e.getKey())
				.collect(Collectors.toList()).forEach(k -> sortedMap.put(k, map.get(k)));
		logger.debug(sortedMap.toString());
		Assert.assertNotNull(sortedMap);
		int expected = 4;
		Assert.assertEquals("Should be four...", expected, sortedMap.size());
	}

	@Test
	public void testCalculateEuroMillions() {
		// reading historico_euromillones.csv
		logger.debug("reading historico_euromillones.csv...");
		// FILE not provided, go to
		// https://www.loteriasyapuestas.es/es/euromillones/estadisticas
		String inputFilePath = "src/test/resources/historico_euromillones.csv";

		try {
			List<EMPojo> myListEMPojo = Utils.processInputFile(inputFilePath);
			// myListEMPojo.forEach(e-> logger.debug(e.toString()));
			final Comparator<EMPojo> compTotal2017 = (p1, p2) -> Integer.compare(p1.getTotal_2017(),
					p2.getTotal_2017());
			final Comparator<EMPojo> compTotal2018 = (p1, p2) -> Integer.compare(p1.getTotal_2018(),
					p2.getTotal_2018());
			long maxSize = 7l;

			logger.debug("reading historico_euromillones.csv sorted by total_2017, 7 values...");
			// sort from max to min
			myListEMPojo.stream().sorted(compTotal2017.reversed()).limit(maxSize)
					.forEach(e -> logger.debug(e.toString()));

			logger.debug("reading historico_euromillones.csv sorted by total_2018, 7 values...");
			// sort from max to min
			myListEMPojo.stream().sorted(compTotal2018.reversed()).limit(maxSize)
					.forEach(e -> logger.debug(e.toString()));

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			logger.error(e1.getLocalizedMessage());
			Assert.assertNotNull("FileNotFoundException", null);
		}
	}

	@Test
	public void testCalculatePrimitivaUsingThreads() {
		Runnable runnable = Utils.calculatePrimitiva();
		new Thread (runnable).start();
	}
	@Test
	public void testCalculatePrimitiva() {
		// reading historico_euromillones.csv
		logger.debug("reading primitiva.csv...");
		String inputFilePath = "src/test/resources/primitiva.csv";

		try {
			List<EMPojo> myListEMPojo = Utils.processInputFile(inputFilePath);
			myListEMPojo.forEach(e -> logger.debug(e.toString()));
			final Comparator<EMPojo> compTotal2017 = (p1, p2) -> Integer.compare(p1.getTotal_2017(),
					p2.getTotal_2017());
			final Comparator<EMPojo> compTotal2018 = (p1, p2) -> Integer.compare(p1.getTotal_2018(),
					p2.getTotal_2018());
			long maxSize = 7l;

			logger.info("reading primitiva.csv sorted from max to min by total_2017, 7 values...");

			myListEMPojo.stream().sorted(compTotal2017.reversed()) // sort from max to min
					.limit(maxSize).forEach(e -> logger.info(e.toString()));

			logger.info("reading primitiva.csv sorted from max to min by total_2018, 7 values...");

			myListEMPojo.stream().sorted(compTotal2018.reversed()) // sort from max to min
					.limit(maxSize).forEach(e -> logger.info(e.toString()));

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			logger.error(e1.getLocalizedMessage());
			Assert.assertNotNull("FileNotFoundException", null);
		}
	}

	@Test
	public void testPlay_With_Historico_EM() {

		logger.debug("reading Lotoideas.com - Histórico de Resultados - Euromillones - 2004 a 2018-2.csv...");
		String inputFilePath = "src/test/resources/Euromillones2004_2018.csv";

		try {
			List<AnotherEMPojo> myListEMPojo = Utils.processHistoricInputFile(inputFilePath);
			logger.debug(
					"There are " + myListEMPojo.size() + " lines in the file. Lets try to find something useful. ");
			logger.debug("Data comes from 2004 to 2018.");

			logger.debug("Winer1 list and number of times. Unsortered");
			myListEMPojo.stream().map(o -> o.getWiner1()).sorted().collect(Collectors.groupingBy(obj -> obj)).entrySet()
					.forEach(
							e -> logger.debug("winer1 " + e.getKey() + " appeared " + e.getValue().size() + " times."));

			logger.debug("Winer2 list and number of times. Unsortered");
			myListEMPojo.stream().map(o -> o.getWiner2()).sorted().collect(Collectors.groupingBy(obj -> obj)).entrySet()
					.forEach(
							e -> logger.debug("winer2 " + e.getKey() + " appeared " + e.getValue().size() + " times."));

			logger.debug("Winer3 list and number of times. Unsortered");
			myListEMPojo.stream().map(o -> o.getWiner3()).sorted().collect(Collectors.groupingBy(obj -> obj)).entrySet()
					.forEach(
							e -> logger.debug("winer3 " + e.getKey() + " appeared " + e.getValue().size() + " times."));

			logger.debug("Winer4 list and number of times. Unsortered");
			myListEMPojo.stream().map(o -> o.getWiner4()).sorted().collect(Collectors.groupingBy(obj -> obj)).entrySet()
					.forEach(
							e -> logger.debug("winer4 " + e.getKey() + " appeared " + e.getValue().size() + " times."));

			logger.debug("Winer5 list and number of times. Unsortered");
			myListEMPojo.stream().map(o -> o.getWiner1()).sorted().collect(Collectors.groupingBy(obj -> obj)).entrySet()
					.forEach(
							e -> logger.debug("winer5 " + e.getKey() + " appeared " + e.getValue().size() + " times."));

			logger.debug("Star1 list and number of times. Unsortered");
			myListEMPojo.stream().map(o -> o.getStar1()).sorted().collect(Collectors.groupingBy(obj -> obj)).entrySet()
					.forEach(e -> logger.debug("star1 " + e.getKey() + " appeared " + e.getValue().size() + " times."));

			logger.debug("Star2 list and number of times. Unsortered");
			myListEMPojo.stream().map(o -> o.getStar2()).sorted().collect(Collectors.groupingBy(obj -> obj)).entrySet()
					.forEach(e -> logger.debug("star2 " + e.getKey() + " appeared " + e.getValue().size() + " times."));

			logger.debug("Done unsortered!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getLocalizedMessage());
			Assert.assertNotNull("FileNotFoundException", null);
		}

	}

	@Test
	public void testFeatureEM1() {
		String inputFilePath = "src/test/resources/Euromillones2004_2018.csv";

		try {
			List<AnotherEMPojo> myListEMPojo = Utils.processHistoricInputFile(inputFilePath);
			logger.debug(
					"There are " + myListEMPojo.size() + " lines in the file. Lets try to find something useful. ");
			logger.debug("Data comes from 2004 to 2018.");

			Utils.showWinner1ReversedOrder(myListEMPojo);

			Utils.showWinner2ReversedOrder(myListEMPojo);

			Utils.showWinner3ReversedOrder(myListEMPojo);

			Utils.showWinner4ReversedOrder(myListEMPojo);

			Utils.showWinner5ReversedOrder(myListEMPojo);

			Utils.showStar1ReversedOrder(myListEMPojo);

			Utils.showStar2ReversedOrder(myListEMPojo);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getLocalizedMessage());
			Assert.assertNotNull("FileNotFoundException", null);
		}
	}

	@Test
	public void testRefactoredFeatureEM1() {
		logger.debug("testRefactoredFeatureEM1");
		String inputFilePath = "src/test/resources/Euromillones2004_2018.csv";
		boolean isDebug = false;
		try {
			List<AnotherEMPojo> myListEMPojo = Utils.processHistoricInputFile(inputFilePath);
			logger.debug(
					"There are " + myListEMPojo.size() + " lines in the file. Lets try to find something useful. ");
			logger.debug("Data comes from 2004 to 2018.");
			logger.info("Reading Euromillones2004_2018.csv");
			Set<Entry<Integer, List<Integer>>> mySetStar1 = myListEMPojo.stream().map(o -> o.getStar1())
					.collect(Collectors.groupingBy(obj -> obj)).entrySet();
			Utils.showRandomValuesReversedOrder(mySetStar1, "Star1 ", isDebug);

			Set<Entry<Integer, List<Integer>>> mySetStar2 = myListEMPojo.stream().map(o -> o.getStar2())
					.collect(Collectors.groupingBy(obj -> obj)).entrySet();
			Utils.showRandomValuesReversedOrder(mySetStar2, "Star2 ", isDebug);

			Set<Entry<Integer, List<Integer>>> mySetWinner1 = myListEMPojo.stream().map(o -> o.getWiner1())
					.collect(Collectors.groupingBy(obj -> obj)).entrySet();
			Utils.showRandomValuesReversedOrder(mySetWinner1, "Winner1 ", isDebug);

			Set<Entry<Integer, List<Integer>>> mySetWinner2 = myListEMPojo.stream().map(o -> o.getWiner2())
					.collect(Collectors.groupingBy(obj -> obj)).entrySet();
			Utils.showRandomValuesReversedOrder(mySetWinner2, "Winner2 ", isDebug);

			Set<Entry<Integer, List<Integer>>> mySetWinner3 = myListEMPojo.stream().map(o -> o.getWiner3())
					.collect(Collectors.groupingBy(obj -> obj)).entrySet();
			Utils.showRandomValuesReversedOrder(mySetWinner3, "Winner3 ", isDebug);

			Set<Entry<Integer, List<Integer>>> mySetWinner4 = myListEMPojo.stream().map(o -> o.getWiner4())
					.collect(Collectors.groupingBy(obj -> obj)).entrySet();
			Utils.showRandomValuesReversedOrder(mySetWinner4, "Winner4 ", isDebug);

			Set<Entry<Integer, List<Integer>>> mySetWinner5 = myListEMPojo.stream().map(o -> o.getWiner5())
					.collect(Collectors.groupingBy(obj -> obj)).entrySet();
			Utils.showRandomValuesReversedOrder(mySetWinner5, "Winner5 ", isDebug);

			logger.debug("Done testRefactoredFeatureEM1");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getLocalizedMessage());
			Assert.assertNotNull("FileNotFoundException", null);
		}

	}

	/***
	 * La idea de este test es tratar de mostrar una prediccion del euromillones
	 * basandonse en dos puntos: 1) Ordenar los numeros ganadores en orden de
	 * frecuencia ascendente, de manera que aparezcan los números que más veces han
	 * salido arriba del todo. 2) Discriminar los números anteriores de manera que
	 * no voy a seleccionar ese número si ha salido repetido en una ventana de
	 * tiempo, de manera que me quedaré con los números que cumplan estas dos
	 * condiciones. En progreso, no terminado. Por ahora la implementacion es
	 * horrorosa...
	 */
	@Test
	public void testshowSorteredValuesReversedOrder() {

		try {
			Runnable runnable = Utils.showSorteredValuesReversedOrder();
			new Thread(runnable).start();
		} catch (FileNotFoundException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testcalculateRandomEM() {
		
		Runnable runnable = Utils.calculateRandomEM();
		new Thread(runnable).start();
		
	}
	@Test
	public void testConvertingDateToLocalDate() {
		// converting java.util.Date to java.time.LocalDate
		Date today = new Date();
		Instant instant = Instant.ofEpochMilli(today.getTime());
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		LocalDate localDate = localDateTime.toLocalDate();

		System.out.println("java.util.Date: " + today);
		System.out.println("java.time.LocalDate: " + localDate);
	}

	@Test
	public void testConvertingDateToLocalDateCompact() {
		Date today = new Date();
		LocalDate localDate = today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		System.out.println("Compact java.util.Date: " + today);
		System.out.println("Compact java.time.LocalDate: " + localDate);
	}

	@Test
	public void testConvertingDateToTimeStamp() {
		Date today = new Date();

		// converting date to Timestamp in JDBC
		Timestamp timestamp = new Timestamp(today.getTime());
		Timestamp t2 = Utils.getTimestamp(today);

		System.out.println("date: " + today);
		System.out.println("timestamp: " + timestamp);
		System.out.println("timestamp2: " + t2);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testConvert_Util_Date_To_SQL_Date() {
		// contains both date and time information
		java.util.Date utilDate = new java.util.Date();
		System.out.println("Util date in Java : " + utilDate);

		// contains only date information without time
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		System.out.println("SQL date in Java : " + sqlDate);
	}

	@Test
	public void testConvert_String_To_LocalDate() {
		String str = "2016-03-04 11:30";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		System.out.println("dateTime : " + dateTime);
	}

	@Test
	public void testCurrent_Date_To_TimeStamp() {
		Date now = new java.util.Date();
		Timestamp current = new java.sql.Timestamp(now.getTime());
		System.out.println("current timestamp: " + current);
		System.out.println("current date: " + now);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testParseString_to_localDate() {
		// BASIC_ISO_DATE formatter can parse date in yyyyMMdd format
		DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;

		LocalDate date = LocalDate.parse("20150927", formatter);
		System.out.println("date string : 20150927, " + "localdate : " + date);

		// The ISO date formatter format or parse date in yyyy-MM-dd format
		// such as '2015-09-27' or '2015-09-27+01:00'
		// This is also the default format of LocalDate, if you print LocalDate
		// it prints date in this format only.
		formatter = DateTimeFormatter.ISO_DATE;

		date = LocalDate.parse("2015-09-27", formatter);
		System.out.println("date string : 2015-09-27, " + "localdate : " + date);

		// dd/MM/yyyy is also known as British or French date format, popular
		// in England, India and France.
		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		date = LocalDate.parse("27/09/2015", formatter);
		System.out.println("date string : 27/09/2015, " + "localdate : " + date);

		// MM/dd/yyyy is also known USA standard date format
		formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		date = LocalDate.parse("09/27/2015", formatter);
		System.out.println("date string : 09/27/2015, " + "localdate : " + date);

		DateFormatSymbols sym = DateFormatSymbols.getInstance(new Locale("es", "ar"));
		sym.setMonths(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
				"Septiembre", "Octubre", "Noviembre", "Diciembre" });
		sym.setShortMonths(new String[] { "Ene", "Feb", "Mar", "May", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic" });
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", sym);
		System.out.println(simpleDateFormat.format(new Date(2014 - 1900, 0, 1)));

		String input = "6 junio 2012";
		Locale l = new Locale("es", "ES");
		DateTimeFormatter f = DateTimeFormatter.ofPattern("d MMMM uuuu", l);
		LocalDate ld = LocalDate.parse(input, f);
		String output = ld.toString(); // 2012-06-06.
		System.out.println("output: " + output);

	}
}
