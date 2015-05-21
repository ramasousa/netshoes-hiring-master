package com.netshoes.hiring.adressrestfull.service;

import com.netshoes.hiring.adressrestfull.model.CustomAddress;

/**
 * Interface that sign the Cep API call methods
 * 
 * @author raul.sousa
 * 
 */
public interface AddressService {

	/**
	 * Validates a CEP id making a call to cepservice API
	 * 
	 * @param id
	 * @return
	 */
	CustomAddress validateCep(final String id);
}
