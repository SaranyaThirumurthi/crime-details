package com.hmrc.crimedata.connector;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.hmrc.crimedata.model.CrimeDetails;

@Component
public class CrimeDetailsConnector {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public List<CrimeDetails> getCrimeDetails(String date, double lat, double lng) {
		
		ResponseEntity<List<CrimeDetails>> response =
		        restTemplate.exchange(generateUrlForCrimeByLocation(date, lat, lng),
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<CrimeDetails>>() {
		            });
		return response.getBody();
	}
	
	
	private String generateUrlForCrimeByLocation(String date, double latitue, double longitude) {
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl("https://data.police.uk/api/crimes-at-location")
                .queryParam("date", date)
                .queryParam("lat", latitue)
                .queryParam("lng", longitude);
		
		return uriBuilder.toUriString();
	}
}

