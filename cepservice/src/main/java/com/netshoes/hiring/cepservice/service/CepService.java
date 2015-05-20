package com.netshoes.hiring.cepservice.service;

import com.netshoes.hiring.cepservice.exception.CepNotFoundException;
import com.netshoes.hiring.cepservice.model.Cep;

/**
 * Interface for signing the methods relative to Cep service layer
 * 
 * @author raul.sousa
 * 
 */
public interface CepService {

	/**
	 * Method that get a cep in database by Id
	 * 
	 * @param id
	 *           
	 * @return Cep object
	 * @throws CepServiceException
	 *             
	 */
	Cep getCepById(final String id) throws CepNotFoundException;
}
