package com.counterapi.bean;

import java.util.List;

public class WordWrapper {
	private List<String> searchText;
	
	public WordWrapper(){
		
	}

	public List<String> getSearchText() {
		return searchText;
	}

	public void setSearchText(List<String> searchText) {
		this.searchText = searchText;
	}
	
}
