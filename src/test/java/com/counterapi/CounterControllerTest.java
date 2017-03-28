package com.counterapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.counterapi.bean.WordWrapper;
import com.counterapi.controller.CounterController;
import com.counterapi.service.CounterService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(CounterController.class)
public class CounterControllerTest {

	private CounterController counterController;
	@Autowired
    private MockMvc mvc;	

    @MockBean
    private CounterService counterService;
    
    @Autowired
    ObjectMapper objectMapper;
    
	    @Before
	    public void setUp() throws Exception {
	    	counterController = new CounterController();
	        mvc = MockMvcBuilders.standaloneSetup(counterController).build();

	    }
	    
	    @Test
	    public void testGetTopNCount() throws Exception {
	    	Mockito.when(this.counterService.getTopNCount(5)).thenReturn(new String("eget|17\nvel|17\nsed|16\nin|15\net|14"));
	    	counterController.setCounterService(counterService);
	    	System.out.println("counterService : " + counterService);
	    	
	    	mvc.perform(get("/counter-api/top/5").contentType(MediaType.APPLICATION_JSON))
	                .andDo(print())
	                .andExpect(status().isOk())
	                .andExpect(content().contentType("text/csv"));
	    }
	    
	    @Test
	    public void testGetCount() throws Exception {
	    	Mockito.when(this.counterService.getCount(new ArrayList())).thenReturn(new ArrayList());
	    	counterController.setCounterService(counterService);
	    	System.out.println("counterService : " + counterService);
	    	
	    	mvc.perform(post("/counter-api/search").contentType(MediaType.APPLICATION_JSON).content(
	    			objectMapper.writeValueAsBytes(new WordWrapper())))
	                .andDo(print())
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	    }
}
