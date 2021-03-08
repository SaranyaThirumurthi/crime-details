package com.hmrc.crimedata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hmrc.crimedata.connector.CrimeDetailsConnector;
import com.hmrc.crimedata.connector.PostcodeConnector;
import com.hmrc.crimedata.exception.NoDataFoundException;
import com.hmrc.crimedata.model.CrimeDetails;
import com.hmrc.crimedata.model.PostcodeDetails;

@Component
public class CrimeDetailsService {

	@Autowired
	private PostcodeConnector postcodeConnector;

	@Autowired
	private CrimeDetailsConnector crimeDetailsConnector;
	
	public List<CrimeDetails> getCrimeDetailsByPostcode(String date, String postcode) {
		
		PostcodeDetails postcodeDetails = postcodeConnector.getDetails(postcode);
				
		List<CrimeDetails> crimeDetails = crimeDetailsConnector.getCrimeDetails(date, postcodeDetails.getResult().getLatitude(), postcodeDetails.getResult().getLongitude());
		
		if(crimeDetails.isEmpty())
			throw new NoDataFoundException("No crime details found for the specified date and location");
		else
			return crimeDetails;
	}
}