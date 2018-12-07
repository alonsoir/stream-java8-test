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
 * The idea is to flatten a file with a custom format to a line with commas, an output.txt file of the runMe.sh script.
 * From this:
 * 
 * Winner1  8
   Winner2  23
   Winner3  27
   Winner4  21
   Winner5  45
   Star1  9
   Star2  10
   
   to this:
   8,23,27,21,45,,9,10
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
		// this is super heavy. al hacer collect, internamente estas creado la lista! no
		// hay que hacer el new
		List<OutputFlatten> inputList = br.lines().map(mapToHistoricItem).collect(Collectors.toList());
		int cont = 0;
		// System.out.println("#Winner1,Winner2,Winner3,Winner4,Winner5,,Star1,Star2");
		/*
		 * hay un problema, bueno dos, el fichero que quieres procesar,
		 * output_1_12_2018.csv tiene los numeros estrellas primero por lo que estas
		 * imprimiendo algo asi star1, star2, winner1, winner2, winner3,, winner4,
		 * winner5 cuando deberia ser winner1,
		 * winner2,winner3,winner4,winner5,,star1,star2 pq luego quieres hacer un grep
		 * contra el fichero EuroMillones2004_2018.csv en el script.
		 */
		/*
		for (OutputFlatten output : inputList) {
			if (output != null) {
				System.out.print(output.getValue());
				cont++;
				if (cont == 5) {
					System.out.print(",,");
				} else if (cont != 7)
					System.out.print(",");
				else if (cont == 7) {
					cont = 0;
					System.out.println();
				}
			} 
				
		}
		*/
		for (OutputFlatten output : inputList) {
			if (output!=null) {
				System.out.print(output.getValue());
				cont++;
				if (cont!=7)
					System.out.print(",");
				else if (cont==7) {
					cont=0;
					System.out.println();
				}
			}
		}
		br.close();
	}

	private static Function<String, OutputFlatten> mapToHistoricItem = (line) -> {
		// System.out.println("Processing line " + line);
		OutputFlatten item = new OutputFlatten();
		if (line.contains("Star") || line.contains("Winner")) {
			String[] p = line.split("  ");// a CSV has comma separated lines
			if (p.length == 2) {
				item.setType(p[0]);
				item.setValue(p[1]);
				return item;
			}
		}
		return null;

	};
}
