package com.netshoes.hiring.crudcepservice.fakepersistence;

import java.util.List;

import com.netshoes.hiring.crudcepservice.exception.GenericAPIException;
import com.netshoes.hiring.crudcepservice.model.Address;

/**
 * Endereco persistence sign methods
 * 
 * @author raul.sousa
 * 
 */
public interface AddressPersistence {

	/**
	 * Insert a Endereco model into db
	 * 
	 * @param address
	 * @return
	 */
	String insert(Address address);

	/**
	 * Update a Endereco model into db
	 * 
	 * @param address
	 * @throws GenericAPIException
	 */
	String update(Address address) throws GenericAPIException;

	/**
	 * Get a Endereco model from db
	 * 
	 * @param id
	 * @return
	 */
	Address get(String id);

	/**
	 * Delete a Endereco model from db
	 * 
	 * @param id
	 */
	boolean delete(String id);

	/**
	 * List all address (Testing purposes)
	 * 
	 * @return
	 */
	List<Address> listAll();
}
