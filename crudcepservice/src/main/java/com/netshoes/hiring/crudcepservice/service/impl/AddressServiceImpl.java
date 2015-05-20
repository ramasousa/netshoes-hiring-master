package com.netshoes.hiring.crudcepservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netshoes.hiring.crudcepservice.exception.GenericAPIException;
import com.netshoes.hiring.crudcepservice.fakepersistence.AddressPersistence;
import com.netshoes.hiring.crudcepservice.model.Address;
import com.netshoes.hiring.crudcepservice.service.AddressService;

/**
 * Endereco service layer impl
 * 
 * @author raul.sousa
 * 
 */
@Service
public class AddressServiceImpl implements AddressService {

	/**
	 * Persistence API
	 */
	@Autowired
	private AddressPersistence enderecoPersistence;

	/**
	 * @see AddressService
	 */
	public String insertAddress(Address endereco) {
		return enderecoPersistence.insert(endereco);
	}

	/**
	 * @throws GenericAPIException
	 * @see AddressService
	 */
	public String updateAddress(Address endereco) throws GenericAPIException {
		return enderecoPersistence.update(endereco);
	}

	/**
	 * @see AddressService
	 */
	public Address selectAddress(String id) {
		return enderecoPersistence.get(id);
	}

	/**
	 * @see AddressService
	 */
	public boolean deleteAddress(String id) {
		return enderecoPersistence.delete(id);
	}

	/**
	 * @see AddressService
	 */
	public List<Address> selectAll() {
		return enderecoPersistence.listAll();
	}

}
