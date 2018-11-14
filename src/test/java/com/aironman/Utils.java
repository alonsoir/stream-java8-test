package com.aironman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Utils {

	private static final String COMMA = ",";

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
	
	
}
