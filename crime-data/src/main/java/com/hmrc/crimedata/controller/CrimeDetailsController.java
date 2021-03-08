package com.hmrc.crimedata.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hmrc.crimedata.model.CrimeDetails;
import com.hmrc.crimedata.service.CrimeDetailsService;

@RestController
@Validated
public class CrimeDetailsController {

	@Autowired
	private CrimeDetailsService crimeDetailsService;
	

	@GetMapping("/crimes")
	public List<CrimeDetails> retrieveCrimeDetails(
			@Valid
			@Pattern(regexp = "([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([A-Za-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y][0-9][A-Za-z]?))))\\s?[0-9][A-Za-z]{2})")
			@RequestParam(required=true) String postcode,
			@Valid
			@Pattern(regexp = "^\\d{4}-(0?[1-9]|1[012])$")
			@RequestParam(required=true) String date) {
		
		return crimeDetailsService.getCrimeDetailsByPostcode(date, postcode);
	}
	
}
