package com.netshoes.hiring.ceprestfull.db.mock;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.netshoes.hiring.ceprestfull.model.Cep;

/**
 * This class is a mock to represents all data into a database
 * 
 * Mock generator class
 * 
 * @author raul.sousa
 * 
 */
@Component
public class CepRestfullDataBaseMock {

	/**
	 * Cep list
	 */
	private List<Cep> cepList;
	
	@Value("#{webservice['ids.cep'].split(';')}")
	private List<String> listIdsCep;
	
	@PostConstruct
	public void initDBMock() {
		
		cepList = new ArrayList<Cep>();
		
		Integer numberCep = 1000;
		
		for (String idCep : listIdsCep) {
			
			Cep cep = new Cep();
			cep.setId(idCep);
			cep.setStreet("Rua Novo Hamburgo");
			cep.setDistrict("Jardim Vista Alegre");
			cep.setCity("Embu das Artes");
			cep.setState("SP");
			cep.setNumber(numberCep);
			
			numberCep += 1000;
			
			cepList.add(cep);
		}

	}
	
	/**
	 * 
	 * @return
	 */
	public List<Cep> getCepList() {
		return cepList;
	}

	/**
	 * 
	 * @param cepList
	 */
	public void setCepList(List<Cep> cepList) {
		this.cepList = cepList;
	}

	/**
	 * @return the listIdsCep
	 */
	public List<String> getListIdsCep() {
		return listIdsCep;
	}

	/**
	 * @param listIdsCep the listIdsCep to set
	 */
	public void setListIdsCep(List<String> listIdsCep) {
		this.listIdsCep = listIdsCep;
	}

	
	
}
