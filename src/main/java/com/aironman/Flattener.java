package com.aironman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * The idea is to flatten a file with a custom format to a line with commas
 * 
 * @author aironman
 *
 */
public class Flattener {

	public static void main(String[] args) throws IOException {

		if (args.length != 1) {
			System.out.println(
					"Wrong arguments. Use java -cp MyStreamjava8.jar com.aironman.Flattener PATH_TO_OUTPUT.txt");
			System.exit(-1);
		}
		String inputPath = args[0];
		File inputF = new File(inputPath);
		InputStream inputFS = new FileInputStream(inputF);
		BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
		List<OutputFlatten> inputList = br.lines().map(mapToHistoricItem).collect(Collectors.toList());
		int cont =1;
		System.out.println("# Star1,Star2,Winner1,Winner2,Winner3,Winner4,Winner5");
		for (OutputFlatten output:inputList) {
			if (output!=null) {
				System.out.print(output.getValue());
				if (cont == 5) {
					System.out.print(",,");
				}else if (cont !=7)
					System.out.print(",");
			}else
				System.out.println();
			
			cont++;
			if (cont>7)
				cont=1;
		}
		br.close();
	}

	private static Function<String, OutputFlatten> mapToHistoricItem = (line) -> {
		// System.out.println("Processing line " + line);
		String[] p = line.split("  ");// a CSV has comma separated lines
		OutputFlatten item = new OutputFlatten();
		if (p.length == 1) {
			return null;
		}
		if (p.length == 2) {
			item.setType(p[0]);
			item.setValue(p[1]);
		}
		return item;

	};
}
