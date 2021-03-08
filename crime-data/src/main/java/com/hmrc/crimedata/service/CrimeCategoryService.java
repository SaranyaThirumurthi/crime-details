package com.hmrc.crimedata.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hmrc.crimedata.connector.CrimeCategoryConnector;
import com.hmrc.crimedata.exception.NoDataFoundException;
import com.hmrc.crimedata.model.Category;
import com.hmrc.crimedata.model.CategoryList;

@Component
public class CrimeCategoryService {

	@Autowired
	private CrimeCategoryConnector crimeCategoryConnector;

	public CategoryList getCategories() {
		
		List<Category> categories = crimeCategoryConnector.getCategories();
		
		if(categories.isEmpty())
			throw new NoDataFoundException("No crime categoires found");
		else
			return new CategoryList(categories.stream().map(cat -> cat.getUrl()).collect(Collectors.toList()));
	}
}