package com.netshoes.hiring.ceprestfull.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netshoes.hiring.ceprestfull.db.mock.CepRestfullDataBaseMock;
import com.netshoes.hiring.ceprestfull.exception.CepNotFoundException;
import com.netshoes.hiring.ceprestfull.model.Cep;
import com.netshoes.hiring.ceprestfull.service.CepRestfull;


/**
 * 
 * @author raul.sousa
 * 
 */
@Service
public class CepRestfullImpl implements CepRestfull {

	/**
	 * Cep dataBaseMock
	 */
	@Autowired
	private CepRestfullDataBaseMock cepDataBaseMock;

	/**
	 * Implementation of Interface
	 * 
	 * @see CepRestfull
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
