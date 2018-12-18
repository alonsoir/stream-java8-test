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

import com.aironman.pojo.Stars;
import com.aironman.service.StarService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class StarTest {

	@Autowired
	StarService service;

	

	@Before
	public void setUp() throws Exception {
		
	}
	
	@After
	public void dropData() {
		service.dropData();
	}

	@Test
	public void testCreateEntities() {
		System.out.println("testCreateEntities...");
		Stars star = new Stars();
		star.setId(1l);
		star.setFrequency(10.123456f);
		star.setStar(1);
		Stars created = service.create(star);
		Assert.assertNotNull(created );
		System.out.println( created .toString());
		star.setId(2l);
		star.setFrequency(12.123456f);
		star.setStar(2);
		created = service.create(star);
		Assert.assertNotNull(created );
		System.out.println(created .toString());
		star.setId(3l);
		star.setFrequency(13.123456f);
		star.setStar(3);
		created = service.create(star);
		Assert.assertNotNull(created );
		System.out.println(created .toString());
		star.setId(4l);
		star.setFrequency(14.123456f);
		star.setStar(4);
		created = service.create(star);
		Assert.assertNotNull(created );
		System.out.println(created .toString());
		System.out.println("testCreateEntities DONE!");

	}
	
	@Test
	public void testGetOrderByFrequency() {
		System.out.println("testGetOrderByFrequency...");
		Stars star = new Stars();
		
		star.setId(5l);
		star.setFrequency(10.123456f);
		star.setStar(1);
		Stars created = service.create(star);
		Assert.assertNotNull(created );
		System.out.println(created .toString());

		star.setId(6l);
		star.setFrequency(12.123456f);
		star.setStar(2);
		created = service.create(star);
		Assert.assertNotNull(created );
		System.out.println(created .toString());
		
		star.setId(7l);
		star.setFrequency(13.123456f);
		star.setStar(3);
		created = service.create(star);
		Assert.assertNotNull(created );
		System.out.println(created .toString());
		
		star.setId(8l);
		star.setFrequency(14.123456f);
		star.setStar(4);
		created = service.create(star);
		Assert.assertNotNull(created );
		
		List<Stars> list = service.getByFrequency();
		list.stream().forEach(System.out::println);
		Assert.assertNotNull("List cannot be null",list);
		System.out.println("testGetOrderByFrequency DONE!");
	}
}
