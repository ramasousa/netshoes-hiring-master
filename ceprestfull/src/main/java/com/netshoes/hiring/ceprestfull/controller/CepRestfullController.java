package com.netshoes.hiring.ceprestfull.controller;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netshoes.hiring.ceprestfull.exception.CepNotFoundException;
import com.netshoes.hiring.ceprestfull.exception.InvalidCepException;
import com.netshoes.hiring.ceprestfull.model.Cep;
import com.netshoes.hiring.ceprestfull.model.FailedStatus;
import com.netshoes.hiring.ceprestfull.service.CepRestfull;


/**
 * Controller responsible for the CEP API requests
 * 
 * @author raul.sousa
 * 
 */
@Controller
@RequestMapping("/")
public class CepRestfullController {

	/**
	 * Maximum quantity retry 
	 */
	private static final int MAX_QUANTITY_RETRY = 5;

	/**
	 * Zero var
	 */
	private static final String ZERO = "0";

	@Autowired
	private CepRestfull cepService;
	
	/**
	 * This message return when a cep is invalid
	 */
	private static final String MESSAGE_EXCEPTION = "Cep is invalid";

	
	/**
	 * Method responsible for get cep based on a received id
	 * 
	 * @param id CEP id
	 * @return   CEP data
	 * @throws InvalidCepException
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	Cep getCep(@RequestBody Cep cepIn) throws InvalidCepException {

		// Validate the input cep
		if (cepIn == null) {
			throw new InvalidCepException(MESSAGE_EXCEPTION);
		} else if (!StringUtils.isNumeric(cepIn.getId()) || cepIn.getId().length() != 8) {
			throw new InvalidCepException("Cep " + cepIn.getId() + " is invalid");
		}

		// Get the cep in data base and return
		return getCepRetryTentative(cepIn.getId(), 1);
	}

	/**
	 * Method responsible to get a cep. This receives a parameter that indicate number of tentatives
	 * 
	 * @param cepIn
	 * @return
	 * @throws CepNotFoundException
	 */
	private Cep getCepRetryTentative(String id, int tentative) {

		Cep cep = null;

		try {
			cep = getCepLocal(id);
		} catch (CepNotFoundException e) {

			if (tentative <= MAX_QUANTITY_RETRY) {
				id = StringUtils.reverse(StringUtils.reverse(id).substring(tentative)) + fillCepWithZero(tentative);
				cep = getCepRetryTentative(id, ++tentative);
			}
		}

		return cep;
	}

	/**
	 * Method for calling the cepService
	 * 
	 * @param id
	 *            
	 * @return CEP data
	 * @throws CepNotFoundException
	 *             
	 */
	private Cep getCepLocal(String id) throws CepNotFoundException {
		return cepService.getCepById(id);
	}

	@ExceptionHandler(InvalidCepException.class)
	public @ResponseBody
	FailedStatus exceptionHandler() {
		return new FailedStatus(MESSAGE_EXCEPTION);
	}
	
	/**
	 * Return zeros for fill the CEP
	 * 
	 * @param quantity - the quantity of zeros
	 *            
	 * @return
	 */
	private String fillCepWithZero(int quantity) {

		String zero = "";
		int i = 0;

		while (i < quantity) {
			zero = zero + ZERO;
			i++;
		}
		return zero;
	}
}