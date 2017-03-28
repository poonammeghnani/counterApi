package com.counterapi;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.counterapi.service.CounterService;

@RunWith(SpringJUnit4ClassRunner.class)
public class CounterServiceTest {
	protected Logger logger = LoggerFactory.getLogger(CounterServiceTest.class);
	private CounterService counterService = new CounterService();
	@Test
	public void testGetCount(){
		List<String> inputList = new ArrayList();
		inputList.add("Lorem");
		inputList.add("Sed");
		inputList.add("Donec");
		
		assertNotNull(counterService.getCount(inputList));
		assertTrue(counterService.getCount(inputList).toString().equals("[{Lorem=8}, {Sed=16}, {Donec=8}]"));
	}
	
	@Test
	public void testGetNCount(){
		assertNotNull(counterService.getTopNCount(5));
	}
}
