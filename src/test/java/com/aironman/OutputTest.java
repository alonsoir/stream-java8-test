package com.aironman;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.aironman.pojo.OutputEntity;
import com.aironman.service.OutputService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class OutputTest {

	@Autowired
	OutputService service;
	
	OutputEntity entity;
	
	@Before
	public void setUp() throws Exception {
		entity = new OutputEntity();
		entity.setDate("jueves, 13 de diciembre de 2018, 19:14:35 CET");
		entity.setFrequency(13.876786f);
		entity.setStar1(1);
		entity.setStar2(2);
		entity.setWinner1(3);
		entity.setWinner2(4);
		entity.setWinner3(5);
		entity.setWinner4(6);
		entity.setWinner5(7);
	}
	@Test
	public void testCreateEntities() {
		
		OutputEntity created = service.create(entity);
		Assert.assertNotNull(created );
	}
	
	@Test
	public void testGetOrderByFrequency() {
		List<OutputEntity> list = service.getByFrequency(entity.getFrequency());
		Assert.assertNotNull("List cannot be null",list);
	}
}
