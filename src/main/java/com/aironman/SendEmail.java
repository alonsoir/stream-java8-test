package com.aironman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SendEmail {

	public static void main(String[] args) throws IOException {

		if (args.length != 3) {
			System.out.println("USAGE: java -cp target/MyStreamjava8-1.0.1-RELEASE.jar com.aironman.SendEmail PATH_TO_final_output_winners.txt PATH_TO_final_output_star.txt correo_destino");
			System.exit(-1);
		}
		String path_to_winners = args[0];
		String path_to_stars = args[1];
		String email = args[2];
		
		String content_path_to_winners = new String(Files.readAllBytes(Paths.get(path_to_winners)));
		String content_path_to_stars = new String(Files.readAllBytes(Paths.get(path_to_stars)));
		StringBuffer sb = new StringBuffer();
		sb.append(content_path_to_winners);
		sb.append(content_path_to_stars);
		String subject = "Resultados_" + new java.util.Date();
		boolean ret = EmailSenderService.sendEmail(sb.toString(),subject ,email);
		System.out.println("Done! " + ret );
		System.exit(0);
	}
}
