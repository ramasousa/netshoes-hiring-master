package com.netshoes.hiring.adressrestfull.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.netshoes.hiring.adressrestfull.exception.AddressValidationException;
import com.netshoes.hiring.adressrestfull.exception.GenericException;
import com.netshoes.hiring.adressrestfull.exception.InvalidAddressException;
import com.netshoes.hiring.adressrestfull.exception.ResourceException;
import com.netshoes.hiring.adressrestfull.model.Address;
import com.netshoes.hiring.adressrestfull.model.CustomAddress;
import com.netshoes.hiring.adressrestfull.model.FailedStatus;
import com.netshoes.hiring.adressrestfull.service.AddressRestfull;
import com.netshoes.hiring.adressrestfull.service.AddressService;

/**
 * Controller responsible for handle the CRUD API requests
 * 
 * @author raul.sousa
 * 
 */
@Controller
@RequestMapping("/")
public class AddressRestfullController {

	/**
	 * AddressRestfull service
	 */
	@Autowired
	private AddressRestfull addressRestfull;

	/**
	 * AddressService service
	 */
	@Autowired
	private AddressService addressService;

	/**
	 * Create address endpoint API
	 * 
	 * @param address
	 * @throws InvalidAddressException
	 * @throws AddressValidationException
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	Address createAddress(@RequestBody Address address) throws InvalidAddressException, AddressValidationException {

		if(isInvalidAddress(address)) {
			throw new InvalidAddressException();
		}
		
		this.validateCepAPI(address);

		final String id = addressRestfull.insertAddress(address);
		address.setId(id);

		return address;
	}

	/**
	 * Update address endpoint API
	 * 
	 * @param address
	 * @throws InvalidAddressException
	 * @throws GenericException
	 * @throws AddressValidationException
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void updateAddress(@RequestBody Address address) throws InvalidAddressException, GenericException,
			AddressValidationException {

		if(isInvalidAddress(address)) {
			throw new InvalidAddressException();
		}
		
		this.validateCepAPI(address);
		addressRestfull.updateAddress(address);
	}

	/**
	 * Get address endpoint API
	 * 
	 * @param id
	 * @return
	 * @throws ResourceException
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Address getAddress(@PathVariable String id) throws ResourceException {

		Address endereco = addressRestfull.selectAddress(id);

		if (endereco == null) {
			throw new ResourceException();
		}

		return endereco;
	}

	/**
	 * List all address for testing purposes
	 * 
	 * @return
	 * @throws ResourceException
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<Address> getAll() throws ResourceException {
		return addressRestfull.selectAll();
	}

	/**
	 * Delete address endpoint API
	 * 
	 * @param id
	 * @throws ResourceException
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteAddress(@PathVariable String id) throws ResourceException {

		if (!addressRestfull.deleteAddress(id)) {
			throw new ResourceException();
		}
	}

	/**
	 * Exception handler for Invalid input data
	 * 
	 * @return
	 */
	@ExceptionHandler(InvalidAddressException.class)
	public @ResponseBody
	FailedStatus exceptionHandler() {
		return new FailedStatus("Erro ao incluir/alterar o Endereco");
	}

	/**
	 * Exception handler for generic error
	 * 
	 * @return
	 */
	@ExceptionHandler(GenericException.class)
	public @ResponseBody
	FailedStatus exceptionGenericHandler() {
		return new FailedStatus("Erro generico na API");
	}

	/**
	 * Exception handler for cep Validation
	 * 
	 * @return
	 */
	@ExceptionHandler(AddressValidationException.class)
	public @ResponseBody
	FailedStatus exceptionCepValidationHandler(AddressValidationException ex) {
		return new FailedStatus(ex.getMessage() != null ? ex.getMessage() : "Erro na validacao do cep");
	}

	/**
	 * 
	 * @param address
	 * @return
	 */
	private boolean isInvalidAddress(Address address) {
		return address == null ||
				StringUtils.isBlank(address.getCep()) ||
				StringUtils.isBlank(address.getCity()) ||
				StringUtils.isBlank(address.getState()) || 
				StringUtils.isBlank(address.getNumber()) || 
				StringUtils.isBlank(address.getStreet());
	}
	
	/**
	 * @param address
	 * @throws AddressValidationException
	 */
	private void validateCepAPI(Address address) throws AddressValidationException {

		CustomAddress customCep = addressService.validateCep(address.getCep());

		if (customCep == null) {
			throw new AddressValidationException();
		}

		if (StringUtils.isNotBlank(customCep.getStatusMessage())) {
			throw new AddressValidationException(customCep.getStatusMessage());
		}
	}


}
