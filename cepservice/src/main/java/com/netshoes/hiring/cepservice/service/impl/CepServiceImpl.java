package com.netshoes.hiring.cepservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netshoes.hiring.cepservice.exception.CepNotFoundException;
import com.netshoes.hiring.cepservice.mock.CepDataBaseMock;
import com.netshoes.hiring.cepservice.model.Cep;
import com.netshoes.hiring.cepservice.service.CepService;


/**
 * Implementation of CEP API service layer
 * 
 * @author raul.sousa
 * 
 */
@Service
public class CepServiceImpl implements CepService {

	/**
	 * Cep dataBaseMock
	 */
	@Autowired
	private CepDataBaseMock cepDataBaseMock;

	/**
	 * Implementation of Interface
	 * 
	 * @see CepService
	 */
	public Cep getCepById(String id) throws CepNotFoundException {

		final List<Cep> cepList = cepDataBaseMock.getCepList();
		Cep cep = null;

		for (Cep cepInList : cepList) {
			if (cepInList.getId().equals(id)) {
				cep = cepInList;
				break;
			}
		}

		if (cep == null) {
			throw new CepNotFoundException("The cep " + id + " not found");
		}

		return cep;
	}

}
