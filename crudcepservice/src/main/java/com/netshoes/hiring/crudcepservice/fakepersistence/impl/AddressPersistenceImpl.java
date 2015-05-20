package com.netshoes.hiring.crudcepservice.fakepersistence.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.netshoes.hiring.crudcepservice.exception.GenericAPIException;
import com.netshoes.hiring.crudcepservice.fakepersistence.AddressPersistence;
import com.netshoes.hiring.crudcepservice.model.Address;

/**
 * Address mock generator class
 * 
 * @author raul.sousa
 * 
 */
@Component
public class AddressPersistenceImpl implements AddressPersistence {

	/**
	 * Address persistence data
	 */
	private Set<Address> addressData;

	@PostConstruct
	public void init() {
		addressData = new HashSet<Address>();
	}

	/**
	 * @see AddressPersistence
	 */
	public String insert(Address address) {
		final String addressId = UUID.randomUUID().toString();
		address.setId(addressId);
		addressData.add(address);
		return addressId;
	}

	/**
	 * @throws GenericAPIException
	 * @see AddressPersistence
	 */
	public String update(Address address) throws GenericAPIException {

		Address found = isInCollection(address.getId());

		if (found != null) {

			Address copy = null;

			try {

				copy = (Address) found.clone();

				if (StringUtils.isNotBlank(address.getOtherInformation())) {
					copy.setOtherInformation(address.getOtherInformation());
				}

				if (StringUtils.isNotBlank(address.getDistrict())) {
					copy.setDistrict(address.getDistrict());
				}

				copy.setCep(address.getCep());
				copy.setStreet(address.getStreet());
				copy.setNumber(address.getNumber());
				copy.setCity(address.getCity());
				copy.setState(address.getState());

				addressData.remove(found);
				addressData.add(copy);

			} catch (CloneNotSupportedException e) {
				throw new GenericAPIException();
			}
			
			return address.getId();

		} else {
			return insert(address);
		}
	}

	/**
	 * @see AddressPersistence
	 */
	public Address get(String id) {
		return isInCollection(id);
	}

	/**
	 * @see AddressPersistence
	 */
	public boolean delete(String id) {
		Address toDelete = isInCollection(id);
		return toDelete != null ? addressData.remove(toDelete) : false;
	}

	/**
	 * Verify if the address is in collection
	 * 
	 * @param endereco
	 */
	private Address isInCollection(String id) {

		for (Address local : addressData) {
			if (local.getId().equalsIgnoreCase(id)) {
				return local;
			}
		}

		return null;
	}

	/**
	 * Testing purposes only
	 */
	public List<Address> listAll() {
		return new ArrayList<Address>(addressData);
	}

}
