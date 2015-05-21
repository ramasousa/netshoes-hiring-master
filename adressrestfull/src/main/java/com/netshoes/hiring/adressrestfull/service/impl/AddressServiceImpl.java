package com.netshoes.hiring.adressrestfull.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netshoes.hiring.adressrestfull.model.CustomAddress;
import com.netshoes.hiring.adressrestfull.service.AddressService;

/**
 * Implementation of AddressService interface
 * 
 * @author raul.sousa
 * 
 */
@Service
public class AddressServiceImpl implements AddressService {

	/**
	 * cepservice API uri
	 */
	@Value("#{webservice['adressrestfull_host']}")
	private String uri;

	/**
	 * @see AddressService
	 */
	public CustomAddress validateCep(String id) {

		final String body = "{ \"id\": \"" + id + "\" }";

		CustomAddress customAddress = null;

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CustomAddress> result = restTemplate.exchange(uri, HttpMethod.POST, new HttpEntity<String>(body, headers), CustomAddress.class);

		if(result.getBody() != null) {
			customAddress = ((CustomAddress) result.getBody());
		}
		
		return customAddress;
	}

	
}
