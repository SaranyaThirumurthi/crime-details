package com.hmrc.crimedata.connector;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.hmrc.crimedata.model.Category;

@Component
public class CrimeCategoryConnector {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Category> getCategories() {
					
		ResponseEntity<List<Category>> response =
		        restTemplate.exchange("https://data.police.uk/api/crime-categories",
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Category>>() {
		            });
		return response.getBody();
	}
}

