/**
 * 
 */
package com.aironman;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

/**
 * @author aironman
 *
 */
public class StreamTests {

	private static List<Product> productsList = new ArrayList<Product>();

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
	}

	@Test
	public void testFilteringByPrice() {
		// filtering by price, creating a map with filtered prices.
		List<Float> listPrices = productsList.stream().filter(aProduct -> aProduct.getPrice() <= 28000f)
				.map(aProduct -> aProduct.getPrice()).collect(Collectors.toList());

		// iterating over list
		listPrices.forEach(System.out::println);
		listPrices.forEach(Assert::assertNotNull);

	}

	@Test
	public void testCompactFilteringByPrice() {
		// This is more compact approach for filtering data
		productsList.stream().filter(product -> product.getPrice() == 30000)
				.forEach(product -> System.out.println(product.getPrice()));

		productsList.stream().filter(product -> product.getPrice() == 30000)
				.forEach(product -> Assert.assertNotNull(product.getPrice()));

	}

	@Test
	public void testUsingCollector_to_sum_prices() {
		// Using Collectors's method to sum the prices.
		double totalPrice3 = productsList.stream().collect(Collectors.summingDouble(product -> product.getPrice()));
		System.out.println("total sum is " + totalPrice3);
		Assert.assertNotNull(Double.toString(totalPrice3));
	}

	@Test
	public void testGetMaxProductPrice() {
		// max() method to get max Product price
		Product productA = productsList.stream()
				.max((product1, product2) -> product1.getPrice() > product2.getPrice() ? 1 : -1).get();

		System.out.println("max product price is " + productA.getPrice());
		Assert.assertNotNull(productA);
	}

	@Test
	public void testGetMinProductPrice() {
		// min() method to get min Product price
		Product productB = productsList.stream()
				.max((product1, product2) -> product1.getPrice() < product2.getPrice() ? 1 : -1).get();
		System.out.println("min product price is " + productB.getPrice());
		Assert.assertNotNull(productB);
	}

	@Test
	public void testConvertingProductListToSet() {
		// Converting product List into Set
		Set<Float> productPriceSet = productsList.stream().filter(product -> product.getPrice() < 30000)
				.map(product -> product.getPrice()).collect(Collectors.toSet());
		System.out.println("productPriceSet is " + productPriceSet);
		Assert.assertNotNull(productPriceSet);
		int expected = 2;
		Assert.assertEquals(expected, productPriceSet.size());
	}

	@Test
	public void testConvertingProductListToMap() {
		// Converting Product List into a Map
		Map<Integer, String> productPriceMap = productsList.stream()
				.collect(Collectors.toMap(p -> p.getId(), p -> p.getName()));
		System.out.println("productPriceMap is " + productPriceMap);
		int expected = 5;
		Assert.assertEquals("Should be five...", expected, productPriceMap.size());

		List<Float> productPriceList = productsList.stream().filter(p -> p.getPrice() > 30000)// filtering data
				.map(Product::getPrice) // fetching price by referring getPrice method
				.collect(Collectors.toList()); // collecting as list
		System.out.println("productPriceList is " + productPriceList);
		expected = 1;
		Assert.assertEquals("Should be only one...", expected, productPriceList.size());
	}

	@Test
	public void testParallelFilteringByPriceCreatingMap() {
		// parallel
		System.out.println("Now parallelizing...");

		// filtering by price, creating a map with filtered prices.
		List<Float> listPricesP = productsList.parallelStream().filter(aProduct -> aProduct.getPrice() <= 28000f)
				.map(aProduct -> aProduct.getPrice()).collect(Collectors.toList());

		// iterating over list
		listPricesP.forEach(System.out::println);

		listPricesP.forEach(Assert::assertNotNull);
		int expected = 3;
		Assert.assertEquals("Should be three... ", expected, listPricesP.size());

	}

	@Test
	public void testParallelCompactApproachFilteringData() {
		// This is more compact approach for filtering data
		productsList.parallelStream().filter(product -> product.getPrice() == 30000)
				.forEach(product -> System.out.println(product.getPrice()));

		productsList.parallelStream().filter(product -> product.getPrice() == 30000)
				.forEach(product -> Assert.assertNotNull(product.getPrice()));

	}

	@Test
	public void testParallelUsingCollectorToSumPrices() {
		// Using Collectors's method to sum the prices.
		double totalPrice3P = productsList.parallelStream()
				.collect(Collectors.summingDouble(product -> product.getPrice()));
		System.out.println("total sum is " + totalPrice3P);

		Assert.assertNotNull("Should be not nulll... ", Double.toString(totalPrice3P));

		Assert.assertEquals(201000.0d, totalPrice3P);
	}

	@Test
	public void testParallelMaxMethodToGetProductPrice() {
		// max() method to get max Product price
		Product productA_P = productsList.parallelStream()
				.max((product1, product2) -> product1.getPrice() > product2.getPrice() ? 1 : -1).get();

		System.out.println("max product price is " + productA_P.getPrice());

		Assert.assertNotNull(productA_P);
		float expected = 90000.0f;
		Assert.assertEquals("Should be 900000", expected, productA_P.getPrice());
	}

	@Test
	public void testParallelMinMethodToGetMinProductPrice() {
		// min() method to get min Product price
		Product productB_P = productsList.parallelStream()
				.max((product1, product2) -> product1.getPrice() < product2.getPrice() ? 1 : -1).get();
		System.out.println("min product price is " + productB_P.getPrice());

		Assert.assertNotNull(productB_P);
		float expected = 25000.0f;
		Assert.assertEquals("Should be 25000.0", expected, productB_P.getPrice());
	}

	@Test
	public void testParallelConvertProductListToSet() {
		// Converting product List into Set
		Set<Float> productPriceSet_P = productsList.parallelStream().filter(product -> product.getPrice() < 30000)
				.map(product -> product.getPrice()).collect(Collectors.toSet());
		System.out.println("productPriceSet is " + productPriceSet_P);

		Assert.assertNotNull(productPriceSet_P);
		int expected = 2;
		Assert.assertEquals("Should be two...", expected, productPriceSet_P.size());
	}

	@Test
	public void testParallelConvertProductListToMap() {
		// Converting Product List into a Map
		Map<Integer, String> productPriceMap_P = productsList.parallelStream()
				.collect(Collectors.toMap(p -> p.getId(), p -> p.getName()));
		System.out.println("productPriceMap is " + productPriceMap_P);
		int expected = 5;
		Assert.assertEquals(expected, productPriceMap_P.size());
		List<Float> productPriceList_P = productsList.parallelStream().filter(p -> p.getPrice() > 30000) // filtering
																											// data
				.map(Product::getPrice) // fetching price by referring getPrice method
				.collect(Collectors.toList()); // collecting as list

		System.out.println("productPriceList is " + productPriceList_P);
		expected = 1;
		Assert.assertEquals("Should be one...", expected, productPriceList_P.size());
	}

	@Test
	public void testCreatingStreamFromCollections() {
		// Creating stream from collection, set or array

		System.out.println("Creating stream from collection, set or array...");
		Collection<String> collection = Arrays.asList("JAVA", "J2EE", "Spring", "Hibernate");
		Stream<String> stream2 = collection.stream();
		stream2.forEach(System.out::println);
		List<String> list = Arrays.asList("JAVA", "J2EE", "Spring", "Hibernate");
		Stream<String> stream3 = list.stream();
		stream3.forEach(System.out::println);
		Set<String> set = new HashSet<>(list);
		Stream<String> stream4 = set.stream();
		// stream4.forEach(System.out::println);
		stream4.forEach(Assert::assertNotNull);

		// Array can also be a source of a Stream
		System.out.println("Array can also be a source of a Stream...");
		Stream<String> streamOfArray = Stream.of("a", "b", "c");
		streamOfArray.forEach(System.out::println);
		// creating from existing array or of a part of an array:
		String[] arr = new String[] { "a", "b", "c" };
		Stream<String> streamOfArrayFull = Arrays.stream(arr);
		streamOfArrayFull.forEach(System.out::println);
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
		// streamOfArrayPart.forEach(System.out::println);
		streamOfArrayPart.forEach(Assert::assertNotNull);
	}

	@Test
	public void testCreatingStreamFromStreamBuilder() {
		// from streamBuilder
		System.out.println("from streamBuilder...");
		Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();
		streamBuilder.forEach(Assert::assertNotNull);
	}

	@Test
	public void testCreatingStreamFromStreamGenerate() {
		// From Stream.generate()...
		System.out.println("From Stream.generate()...");
		Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);
		streamGenerated.forEach(Assert::assertNotNull);
	}

	@Test
	public void testCreatingStreamFromStreamIterate() {

		// From Stream.iterate()
		System.out.println("From Stream.iterate()...");
		Stream<Integer> streamIterated = Stream.iterate(1, n -> n + 2).limit(5);
		streamIterated.forEach(Assert::assertNotNull);
	}

	@Test
	public void testCreatingStreamFromStreamFile() {
		// Stream of File
		System.out.println("Stream of File...");
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
		}
	}

	@Test
	public void testCreatingStreamFromStreamOfPrimitives() {
		// Stream of Primitives
		System.out.println("Stream of Primitives...");
		IntStream intStream = IntStream.range(1, 3);
		intStream.forEach(Assert::assertNotNull);
		LongStream longStream = LongStream.rangeClosed(1, 3);
		longStream.forEach(System.out::println);
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
		System.out.println(sortedMap);
		Assert.assertNotNull(sortedMap);
		int expected = 4;
		Assert.assertEquals("Should be four...", expected, sortedMap.size());
	}

	@Test
	public void testCalculateEuroMillions() {
		// reading historico_euromillones.csv
		System.out.print("reading historico_euromillones.csv...");
		// FILE not provided, go to
		// https://www.loteriasyapuestas.es/es/euromillones/estadisticas
		String inputFilePath = "src/test/resources/historico_euromillones.csv";

		try {
			List<EMPojo> myListEMPojo = Utils.processInputFile(inputFilePath);
			myListEMPojo.forEach(System.out::println);
			final Comparator<EMPojo> compTotal2017 = (p1, p2) -> Integer.compare(p1.getTotal_2017(),
					p2.getTotal_2017());
			final Comparator<EMPojo> compTotal2018 = (p1, p2) -> Integer.compare(p1.getTotal_2018(),
					p2.getTotal_2018());
			long maxSize = 7l;
			System.out.println();
			System.out.print("reading historico_euromillones.csv sorted by total_2017, 7 values...");
			System.out.println();
			myListEMPojo.stream().sorted(compTotal2017.reversed()) // sort from max to min
					.limit(maxSize).forEach(System.out::println);

			System.out.println();
			System.out.print("reading historico_euromillones.csv sorted by total_2018, 7 values...");
			System.out.println();
			myListEMPojo.stream().sorted(compTotal2018.reversed()) // sort from max to min
					.limit(maxSize).forEach(System.out::println);

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Test
	public void testPlay_With_Historico_EM() {

		System.out.println();
		System.out.println("reading Lotoideas.com - Histórico de Resultados - Euromillones - 2004 a 2018-2.csv...");
		String inputFilePath = "src/test/resources/Euromillones2004_2018.csv";

		try {
			List<AnotherEMPojo> myListEMPojo = Utils.processHistoricInputFile(inputFilePath);
			System.out.println("There are " + myListEMPojo.size() + " results. Lets try to find something useful. ");
			System.out.println("Data comes from 2004 to 2018");
			System.out.println();
			System.out.println("Winer1 list and number of times");
			myListEMPojo.stream()
						.map(o -> o.getWiner1())
						.sorted()
						.collect(Collectors.groupingBy(obj -> obj))
						.entrySet()
						
						.forEach(e -> System.out.println(e.getKey() + " >> " +e.getValue().size()));
			System.out.println();
			System.out.println("Winer2 list and number of times");
			myListEMPojo.stream()
						.map(o -> o.getWiner2())
						.sorted()
						.collect(Collectors.groupingBy(obj -> obj))
						.entrySet()
						.forEach(e -> System.out.println(e.getKey() + " >> " +e.getValue().size()));
			System.out.println();
			System.out.println("Winer3 list and number of times");
			myListEMPojo.stream()
						.map(o -> o.getWiner3())
						.sorted()
						.collect(Collectors.groupingBy(obj -> obj))
						.entrySet()
						.forEach(e -> System.out.println(e.getKey() + " >> " +e.getValue().size()));
			System.out.println();
			System.out.println("Winer4 list and number of times");
			myListEMPojo.stream()
						.map(o -> o.getWiner4())
						.sorted()
						.collect(Collectors.groupingBy(obj -> obj))
						.entrySet()
						.forEach(e -> System.out.println(e.getKey() + " >> " +e.getValue().size()));
			System.out.println();
			System.out.println("Winer5 list and number of times");
			myListEMPojo.stream()
						.map(o -> o.getWiner1())
						.sorted()
						.collect(Collectors.groupingBy(obj -> obj))
						.entrySet()
						.forEach(e -> System.out.println(e.getKey() + " >> " +e.getValue().size()));
			System.out.println();
			System.out.println("Star1 list and number of times");
			myListEMPojo.stream()
						.map(o -> o.getStar1())
						.sorted()
						.collect(Collectors.groupingBy(obj -> obj))
						.entrySet()
						.forEach(e -> System.out.println(e.getKey() + " >> " +e.getValue().size()));
			System.out.println();
			
			System.out.println("Star2 list and number of times");
			myListEMPojo.stream()
						.map(o -> o.getStar2())
						.sorted()
						.collect(Collectors.groupingBy(obj -> obj))
						.entrySet()
						.forEach(e -> System.out.println(e.getKey() + " >> " +e.getValue().size()));
			System.out.println();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
