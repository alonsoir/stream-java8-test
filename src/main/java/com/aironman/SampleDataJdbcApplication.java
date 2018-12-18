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

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aironman.pojo.OutputEntity;
import com.aironman.pojo.Stars;
import com.aironman.pojo.Winners;
import com.aironman.service.StarService;
import com.aironman.service.WinnerService;

@SpringBootApplication
public class SampleDataJdbcApplication {

	@Autowired
	WinnerService winnerService;

	@Autowired
	StarService starService;

	static String pathToWinner=null;
	static String pathToStar=null;
	List<OutputEntity> inputListWinners = null;
	List<OutputEntity> inputListStars = null;
	private static final String SPACE = " ";

	/***
	 * 
	 * @param args [1] is final_output_winners.txt args [2] is
	 *             final_output_stars.txt I am going to process every line of each
	 *             file to call each service, fill every table and then invoke their
	 *             sortByFrequency methods.
	 */
	public static void main(String[] args) {

		if (args.length != 3) {
			System.out.println("ERROR!");
			System.exit(-1);
		}
		pathToWinner = args[1];
		pathToStar = args[2];
		// Instantiate dependencies within Spring container.
		SpringApplication.run(SampleDataJdbcApplication.class);

	}

	private static Function<String, OutputEntity> mapToItemWinners = (line) -> {
		String[] p = line.split(SPACE);// a CSV has comma separated lines
		// It is waste to use this pojo...
		OutputEntity item = new OutputEntity();
		item.setWinner1(Integer.valueOf(p[1]));
		item.setFrequency(Float.valueOf(p[9]));
		return item;

	};

	private static Function<String, OutputEntity> mapToItemStars = (line) -> {
		String[] p = line.split(SPACE);// a CSV has comma separated lines
		// It is waste to use this pojo...
		OutputEntity item = new OutputEntity();
		item.setStar1(Integer.valueOf(p[1]));
		item.setFrequency(Float.valueOf(p[9]));
		return item;

	};

	@PostConstruct
	public void processFiles() {

		if (pathToWinner == null || pathToStar == null) return;
		
		try {
			File inputFWinners = new File(pathToWinner);
			InputStream inputFSWinners = new FileInputStream(inputFWinners);
			BufferedReader brWinners = new BufferedReader(new InputStreamReader(inputFSWinners));
			inputListWinners = brWinners.lines().map(mapToItemWinners).collect(Collectors.toList());

			File inputFStars = new File(pathToStar);
			InputStream inputFSStars = new FileInputStream(inputFStars);
			BufferedReader brStars = new BufferedReader(new InputStreamReader(inputFSStars));
			inputListStars = brStars.lines().map(mapToItemStars).collect(Collectors.toList());
			
			winnerService.dropData();
			Long idWinner=1l;
			for (OutputEntity entity : inputListWinners) {
				Winners entityToCreate = new Winners();
				entityToCreate.setId(idWinner++);
				entityToCreate.setFrequency(entity.getFrequency());
				entityToCreate.setWinner(entity.getWinner1());
				Winners created = winnerService.create(entityToCreate);
				// System.out.println("winner created. " + created .toString());
			}
			Iterable<Winners> iterable = winnerService.findAll();
			iterable.forEach(System.out::println);
			
			List<Winners> listWinners = winnerService.getByFrequency();
			listWinners .forEach(System.out::println);
			
			starService.dropData();
			Long idStar=1l;
			for (OutputEntity entity : inputListStars) {
				Stars entityToCreate = new Stars();
				entityToCreate.setId(idStar++);
				entityToCreate.setFrequency(entity.getFrequency());
				entityToCreate.setStar(entity.getStar1());
				Stars created = starService.create(entityToCreate);
				// System.out.println("star created. " + created .toString());
			}
			
			List<Stars> listStars = starService.getByFrequency();
			listStars .forEach(System.out::println);
			
			
			brWinners.close();
			brStars.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}