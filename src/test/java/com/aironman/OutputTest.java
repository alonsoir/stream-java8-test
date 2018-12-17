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

import com.aironman.pojo.OutputEntity;
import com.aironman.service.OutputService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class OutputTest {

	@Autowired
	OutputService service;
	
	OutputEntity entity;
	
	@Before
	public void setUp() throws Exception {
		entity = new OutputEntity();
		entity.setId(1l);
		entity.setFecha("jueves, 13 de diciembre de 2018, 19:14:35 CET");
		entity.setFrequency(13.876786f);
		entity.setStar1(1);
		entity.setStar2(2);
		entity.setWinner1(3);
		entity.setWinner2(4);
		entity.setWinner3(5);
		entity.setWinner4(6);
		entity.setWinner5(7);
	}
	
	@After
	public void dropData() {
		service.dropData();
	}

	@Test
	public void testCreateEntities() {
		System.out.println("testCreateEntities...");
		OutputEntity created = service.create(entity);
		Assert.assertNotNull(created );
		System.out.println("testCreateEntities. DONE! " + created .toString());
	}
	
	@Test
	public void testGetOrderByFrequency() {
		System.out.println("testGetOrderByFrequency...");
		List<OutputEntity> list = service.getByFrequency(entity.getFrequency());
		list.stream().forEach(System.out::println);
		Assert.assertNotNull("List cannot be null",list);
		System.out.println("testGetOrderByFrequency DONE!");
	}
}
