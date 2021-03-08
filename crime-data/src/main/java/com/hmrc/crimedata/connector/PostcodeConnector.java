package com.hmrc.crimedata.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.hmrc.crimedata.model.PostcodeDetails;

@Component
public class PostcodeConnector {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public PostcodeDetails getDetails(String postcode) {
				
		PostcodeDetails postcodeDetails =
		        restTemplate.getForObject("http://api.postcodes.io/postcodes/"+postcode, PostcodeDetails.class);
		
		return postcodeDetails;
	}
	
}
