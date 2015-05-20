package com.netshoes.hiring.crudcepservice.service;

import com.netshoes.hiring.crudcepservice.model.CustomCep;

/**
 * Interface that sign the Cep API call methods
 * 
 * @author raul.sousa
 * 
 */
public interface CepService {

	/**
	 * Validates a CEP id making a call to cepservice API
	 * 
	 * @param id
	 * @return
	 */
	CustomCep validateCep(final String id);
}
