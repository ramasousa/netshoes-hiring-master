package com.netshoes.hiring.crudcepservice.service;

import java.util.List;

import com.netshoes.hiring.crudcepservice.exception.GenericAPIException;
import com.netshoes.hiring.crudcepservice.model.Address;

/**
 * Endereco service layer
 * 
 * @author raul.sousa
 * 
 */
public interface AddressService {

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
	 * @throws GenericAPIException
	 */
	String updateAddress(Address address) throws GenericAPIException;

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
