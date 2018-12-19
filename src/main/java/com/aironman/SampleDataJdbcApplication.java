package com.aironman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.aironman.pojo.OutputEntity;
import com.aironman.pojo.Stars;
import com.aironman.pojo.Winners;

@SpringBootApplication
public class SampleDataJdbcApplication {

	@Autowired
	JdbcTemplate jdbcTemplate;

	static String pathToWinner = null;
	static String pathToStar = null;
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

		if (args.length != 2) {
			System.err.println("Please provide two arguments, PATH_TO/clean_final_output_winners.txt PATH_TO/clean_final_output_stars.txt");
			System.exit(-1);
		}
		pathToWinner = args[0];
		pathToStar = args[1];
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

	/***
	 * Spring call this method after creating every dependency. Probably not necessary.
	 */
	@PostConstruct
	public void processFiles() {

		if (pathToWinner == null || pathToStar == null)
			return;

		try {
			BufferedReader brWinners = importWinnersFromInputFile();

			BufferedReader brStars = importStarsFromInputFile();

			prepareJDBCTables();
			
			insert_And_Show_Winners_Order_By_Frequency();

			insert_And_Show_Stars_Order_By_Frequency();
			
			brWinners.close();
			brStars.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void insert_And_Show_Stars_Order_By_Frequency() {
		Long idStar = 1l;
		List<Stars> listStars = new ArrayList<Stars>();
		for (OutputEntity entity : inputListStars) {
			Stars entityToCreate = new Stars();
			entityToCreate.setId(idStar++);
			entityToCreate.setFrequency(entity.getFrequency());
			entityToCreate.setStar(entity.getStar1());
			listStars .add(entityToCreate);
		}
		importStars(listStars);
		jdbcTemplate.query("SELECT id, star,frequency FROM STARS ORDER BY frequency DESC",
				(rs, rowNum) -> new Stars(rs.getLong("id"), rs.getInt("star"), rs.getFloat("frequency")))
				.forEach(star -> System.out.println(star .toString()));
	}

	private void insert_And_Show_Winners_Order_By_Frequency() {
		Long idWinner = 1l;
		List<Winners> listWinners = new ArrayList<Winners>();
		for (OutputEntity entity : inputListWinners) {
			Winners entityToCreate = new Winners();
			entityToCreate.setId(idWinner++);
			entityToCreate.setFrequency(entity.getFrequency());
			entityToCreate.setWinner(entity.getWinner1());
			listWinners.add(entityToCreate);
		}
		importWinners(listWinners);
		jdbcTemplate.query("SELECT id, winner,frequency FROM WINNERS ORDER BY frequency DESC",
				(rs, rowNum) -> new Winners(rs.getLong("id"), rs.getInt("winner"), rs.getFloat("frequency")))
				.forEach(winner -> System.out.println(winner.toString()));
	}

	private void prepareJDBCTables() {
		jdbcTemplate.execute("DROP TABLE WINNERS IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE WINNERS (\n" + "	id SERIAL,\n" + "	winner INTEGER,\n"
				+ "	frequency FLOAT\n" + ")");
		
		jdbcTemplate.execute("DROP TABLE STARS IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE STARS (\n" + "	id SERIAL,\n" + "	star INTEGER,\n"
				+ "	frequency FLOAT\n" + ")");
	}

	private BufferedReader importStarsFromInputFile() throws FileNotFoundException {
		File inputFStars = new File(pathToStar);
		InputStream inputFSStars = new FileInputStream(inputFStars);
		BufferedReader brStars = new BufferedReader(new InputStreamReader(inputFSStars));
		inputListStars = brStars.lines().map(mapToItemStars).collect(Collectors.toList());
		return brStars;
	}

	private BufferedReader importWinnersFromInputFile() throws FileNotFoundException {
		File inputFWinners = new File(pathToWinner);
		InputStream inputFSWinners = new FileInputStream(inputFWinners);
		BufferedReader brWinners = new BufferedReader(new InputStreamReader(inputFSWinners));
		inputListWinners = brWinners.lines().map(mapToItemWinners).collect(Collectors.toList());
		return brWinners;
	}

	private final void importWinners(final List<Winners> listWinners) {
		jdbcTemplate.batchUpdate("INSERT INTO WINNERS(winner,frequency) VALUES (?,?)",
				new BatchPreparedStatementSetter() {
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						Winners winner = listWinners.get(i);
						ps.setInt(1, winner.getWinner());
						ps.setFloat(2, winner.getFrequency());
					}

					public int getBatchSize() {
						return listWinners.size();
					}
				});

	}

	private final void importStars(final List<Stars> listStars) {
		jdbcTemplate.batchUpdate("INSERT INTO STARS(star,frequency) VALUES (?,?)",
				new BatchPreparedStatementSetter() {
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						Stars star= listStars.get(i);
						ps.setInt(1, star.getStar());
						ps.setFloat(2, star.getFrequency());
					}

					public int getBatchSize() {
						return listStars.size();
					}
				});

	}
}