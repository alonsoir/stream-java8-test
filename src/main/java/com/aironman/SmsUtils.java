package com.aironman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SmsUtils {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		if (args.length !=2) {
			System.out.println("Usage: java -cp target/MyStreamjava8-1.0.1-RELEASE.jar com.aironman.SmsUtils PATH_TO_final_output_winners.txt PATH_TO_final_output_star.txt");
			System.exit(-1);
		}
		String path_to_bodyWinners = args[0];
		String path_to_bodyStars = args[1];
		StringBuffer sb = new StringBuffer();
		String sbWinners = readFile(path_to_bodyWinners);
		String sbStars = readFile(path_to_bodyStars);
		sb.append(sbWinners);
		sb.append(sbStars);
		Utils.sendSms(sb.toString());
		System.out.println("Done sms!");
		System.exit(0);
	}
	
	private static final String readFile(String file) throws IOException {
	    BufferedReader reader = new BufferedReader(new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    try {
	        while((line = reader.readLine()) != null) {
	            stringBuilder.append(line);
	            stringBuilder.append(ls);
	        }

	        return stringBuilder.toString();
	    } finally {
	        reader.close();
	    }
	}
	

}
