package com.aironman;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aironman.pojo.Winners;
import com.aironman.service.WinnerService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class WinnerTest {

	@Autowired
	WinnerService service;

	Winners winner;

	@Before
	public void setUp() throws Exception {
		winner = new Winners();
		winner.setId(1l);
		winner.setFrequency(10.123456f);
		winner.setWinner(1);
	}
	
	@After
	public void dropData() {
		service.dropData();
	}

	@Test
	public void testCreateEntities() {
		System.out.println("testCreateEntities...");
		Winners created = service.create(winner);
		Assert.assertNotNull(created );
		System.out.println("testCreateEntities. DONE! " + created .toString());
	}
	
	@Test
	public void testGetOrderByFrequency() {
		System.out.println("testGetOrderByFrequency...");
		List<Winners> list = service.getByFrequency();
		list.stream().forEach(System.out::println);
		Assert.assertNotNull("List cannot be null",list);
		System.out.println("testGetOrderByFrequency DONE!");
	}
}
