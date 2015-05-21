package com.netshoes.hiring.adressrestfull.service;

import java.util.List;

import com.netshoes.hiring.adressrestfull.exception.GenericException;
import com.netshoes.hiring.adressrestfull.model.Address;

/**
 * Endereco service layer
 * 
 * @author raul.sousa
 * 
 */
public interface AddressRestfull {

	/**
	 * Insert a Address model into database
	 * 
	 * @param address
	 * @return
	 */
	String insertAddress(Address address);

	/**
	 * Update a Address model into database
	 * 
	 * @param address
	 * @throws GenericException
	 */
	String updateAddress(Address address) throws GenericException;

	/**
	 * Select a Address model from database
	 * 
	 * @param id
	 * @return
	 */
	Address selectAddress(String id);

	/**
	 * Delete a Address model from database
	 * 
	 * @param id
	 */
	boolean deleteAddress(String id);

	/**
	 * Select all address for testing purposes only
	 * 
	 * @return
	 */
	List<Address> selectAll();
}
