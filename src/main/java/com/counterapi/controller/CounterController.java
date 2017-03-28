package com.counterapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.counterapi.bean.WordWrapper;
import com.counterapi.service.CounterService;

@RestController
@RequestMapping("/counter-api")
public class CounterController {
	private static Logger logger = LoggerFactory.getLogger(CounterController.class);
	
	@Autowired
	private CounterService counterService;
	
	@RequestMapping(method=RequestMethod.POST,value="/search")
	public Map getCount(@RequestBody WordWrapper wrapper){
		logger.info("/search request called on counter-api");
		Map<String, List> countResult = new HashMap<String, List>();
		countResult.put("counts", counterService.getCount(wrapper.getSearchText()));
		logger.info("/search request completed on counter-api");
		return countResult;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/top/{count}")
	public String getTopNCount(@PathVariable int count, HttpServletResponse response){
		logger.info("/search request called on counter-api");
		response.setContentType("text/csv");
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                "CounterTopNResult.txt");
        response.setHeader(headerKey, headerValue);
		logger.info("/search request completed on counter-api");
		return counterService.getTopNCount(count);
	}
	
	public CounterService getCounterService() {
		return counterService;
	}

	public void setCounterService(CounterService counterService) {
		this.counterService = counterService;
	}

}
