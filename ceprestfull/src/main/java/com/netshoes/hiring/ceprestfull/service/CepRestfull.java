package com.netshoes.hiring.ceprestfull.service;

import com.netshoes.hiring.ceprestfull.exception.CepNotFoundException;
import com.netshoes.hiring.ceprestfull.model.Cep;

/**
 * 
 * @author raul.sousa
 * 
 */
public interface CepRestfull {

	/**
	 * Method that get a cep in database by Id
	 * 
	 * @param id
	 *           
	 * @return Cep object
	 * @throws CepNotFoundException
	 *             
	 */
	Cep getCepById(final String id) throws CepNotFoundException;
}
