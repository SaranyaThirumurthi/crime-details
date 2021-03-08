package com.hmrc.crimedata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmrc.crimedata.model.CategoryList;
import com.hmrc.crimedata.service.CrimeCategoryService;


@RestController
public class CrimeCategoryController {

	@Autowired
	private CrimeCategoryService crimeCategoryService;
	
	
	@GetMapping("/crime/categories")
	public CategoryList getCrimeCategories() {
		
		return crimeCategoryService.getCategories();
	}

}
