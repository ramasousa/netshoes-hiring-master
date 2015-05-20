package com.netshoes.hiring.cepservice.controller;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netshoes.hiring.cepservice.exception.CepNotFoundException;
import com.netshoes.hiring.cepservice.exception.InvalidCepException;
import com.netshoes.hiring.cepservice.model.Cep;
import com.netshoes.hiring.cepservice.model.FailedStatus;
import com.netshoes.hiring.cepservice.service.CepService;


/**
 * Controller responsible for the CEP API requests
 * 
 * @author raul.sousa
 * 
 */
@Controller
@RequestMapping("/")
public class CepServiceController {

	@Autowired
	private CepService cepService;

	/**
	 * Maximum retry quantity
	 */
	private static final int MAX_QUANTITY_RETRY = 5;

	/**
	 * Zero var
	 */
	private static final String ZERO = "0";

	/**
	 * Method responsible for getting the cep based on a received id
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
			throw new InvalidCepException("cep is invalid");
		} else if (!StringUtils.isNumeric(cepIn.getId()) || cepIn.getId().length() != 8) {
			throw new InvalidCepException("cep " + cepIn.getId() + " is invalid");
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
				id = StringUtils.reverse(StringUtils.reverse(id).substring(tentative)) + fillWithZero(tentative);
				cep = getCepRetryTentative(id, ++tentative);
			}
		}

		return cep;
	}

	/**
	 * Local method for calling the cepService API
	 * 
	 * @param id
	 *            CEP id
	 * @return CEP data
	 * @throws CepNotFoundException
	 *             Thrown when the cep is not found on DB
	 */
	private Cep getCepLocal(String id) throws CepNotFoundException {
		return cepService.getCepById(id);
	}

	@ExceptionHandler(InvalidCepException.class)
	public @ResponseBody
	FailedStatus exceptionHandler() {
		return new FailedStatus("CEP is invalid");
	}
	
	/**
	 * Return zeros for fill the CEP
	 * 
	 * @param quantity - the quantity of zeros
	 *            
	 * @return
	 */
	private String fillWithZero(int quantity) {

		String zero = "";
		int i = 0;

		while (i < quantity) {
			zero = zero + ZERO;
			i++;
		}
		return zero;
	}
}