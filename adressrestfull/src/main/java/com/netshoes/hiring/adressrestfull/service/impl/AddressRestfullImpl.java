package com.netshoes.hiring.adressrestfull.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netshoes.hiring.adressrestfull.exception.GenericException;
import com.netshoes.hiring.adressrestfull.mockpersistence.AddressPersistence;
import com.netshoes.hiring.adressrestfull.model.Address;
import com.netshoes.hiring.adressrestfull.service.AddressRestfull;

/**
 * Endereco service layer impl
 * 
 * @author raul.sousa
 * 
 */
@Service
public class AddressRestfullImpl implements AddressRestfull {

	/**
	 * Persistence API
	 */
	@Autowired
	private AddressPersistence enderecoPersistence;

	/**
	 * @see AddressRestfull
	 */
	public String insertAddress(Address endereco) {
		return enderecoPersistence.insert(endereco);
	}

	/**
	 * @throws GenericException
	 * @see AddressRestfull
	 */
	public String updateAddress(Address endereco) throws GenericException {
		return enderecoPersistence.update(endereco);
	}

	/**
	 * @see AddressRestfull
	 */
	public Address selectAddress(String id) {
		return enderecoPersistence.get(id);
	}

	/**
	 * @see AddressRestfull
	 */
	public boolean deleteAddress(String id) {
		return enderecoPersistence.delete(id);
	}

	/**
	 * @see AddressRestfull
	 */
	public List<Address> selectAll() {
		return enderecoPersistence.listAll();
	}

}
