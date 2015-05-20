package com.netshoes.hiring.cepservice.mock;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.netshoes.hiring.cepservice.model.Cep;

/**
 * This class is a mock to represents all data into a database
 * 
 * Mock generator class
 * 
 * @author raul.sousa
 * 
 */
@Component
public class CepDataBaseMock {

	/**
	 * Cep list
	 */
	private List<Cep> cepList;

	@PostConstruct
	public void generatorInit() {

		cepList = new ArrayList<Cep>(1);

		Cep cep1 = new Cep();
		cep1.setId("06807060");
		cep1.setStreet("Rua Novo Hamburgo");
		cep1.setDistrict("Jardim Vista Alegre");
		cep1.setCity("Embu das Artes");
		cep1.setState("SP");
		cepList.add(cep1);

		Cep cep2 = new Cep();
		cep2.setId("06823240");
		cep2.setDistrict("Jardim Santo Eduardo");
		cep2.setCity("Embu das Artes");
		cep2.setState("SP");
		cep2.setStreet("Rua Marcelina");
		cepList.add(cep2);

		Cep cep3 = new Cep();
		cep3.setId("06807050");
		cep3.setStreet("Rua Niterói");
		cep3.setDistrict("Jardim Vista Alegre");
		cep3.setCity("Embu das Artes");
		cep3.setState("SP");
		cepList.add(cep3);

		Cep cep4 = new Cep();
		cep4.setId("06807040");
		cep4.setStreet("Rua Crisciuma");
		cep4.setDistrict("Jardim Vista Alegre");
		cep4.setCity("Embu das Artes");
		cep4.setState("SP");

		cepList.add(cep4);
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

	
}
