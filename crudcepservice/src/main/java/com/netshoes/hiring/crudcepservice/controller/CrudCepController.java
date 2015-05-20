package com.netshoes.hiring.crudcepservice.controller;

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

import com.netshoes.hiring.crudcepservice.exception.CepValidationException;
import com.netshoes.hiring.crudcepservice.exception.GenericAPIException;
import com.netshoes.hiring.crudcepservice.exception.InvalidAddressInputException;
import com.netshoes.hiring.crudcepservice.exception.ResourceNotFoundException;
import com.netshoes.hiring.crudcepservice.model.FailedStatus;
import com.netshoes.hiring.crudcepservice.model.CustomCep;
import com.netshoes.hiring.crudcepservice.model.Address;
import com.netshoes.hiring.crudcepservice.service.CepService;
import com.netshoes.hiring.crudcepservice.service.AddressService;

/**
 * Controller responsible for handle the CRUD API requests
 * 
 * @author raul.sousa
 * 
 */
@Controller
@RequestMapping("/")
public class CrudCepController {

	/**
	 * Address service
	 */
	@Autowired
	private AddressService addressService;

	/**
	 * Cep service
	 */
	@Autowired
	private CepService cepService;

	/**
	 * Create address endpoint API
	 * 
	 * @param address
	 * @throws InvalidAddressInputException
	 * @throws CepValidationException
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	Address createAddress(@RequestBody Address address) throws InvalidAddressInputException, CepValidationException {

		if(isInvalidAddress(address)) {
			throw new InvalidAddressInputException();
		}
		
		this.validateCepAPI(address);

		final String id = addressService.insertAddress(address);
		address.setId(id);

		return address;
	}

	/**
	 * Update address endpoint API
	 * 
	 * @param address
	 * @throws InvalidAddressInputException
	 * @throws GenericAPIException
	 * @throws CepValidationException
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void updateAddress(@RequestBody Address address) throws InvalidAddressInputException, GenericAPIException,
			CepValidationException {

		if(isInvalidAddress(address)) {
			throw new InvalidAddressInputException();
		}
		
		this.validateCepAPI(address);
		addressService.updateAddress(address);
	}

	/**
	 * Get address endpoint API
	 * 
	 * @param id
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Address getAddress(@PathVariable String id) throws ResourceNotFoundException {

		Address endereco = addressService.selectAddress(id);

		if (endereco == null) {
			throw new ResourceNotFoundException();
		}

		return endereco;
	}

	/**
	 * List all address for testing purposes
	 * 
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<Address> getAll() throws ResourceNotFoundException {
		return addressService.selectAll();
	}

	/**
	 * Delete address endpoint API
	 * 
	 * @param id
	 * @throws ResourceNotFoundException
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteAddress(@PathVariable String id) throws ResourceNotFoundException {

		if (!addressService.deleteAddress(id)) {
			throw new ResourceNotFoundException();
		}
	}

	/**
	 * Exception handler for Invalid input data
	 * 
	 * @return
	 */
	@ExceptionHandler(InvalidAddressInputException.class)
	public @ResponseBody
	FailedStatus exceptionHandler() {
		return new FailedStatus("Erro ao incluir/alterar o Endereco");
	}

	/**
	 * Exception handler for generic error
	 * 
	 * @return
	 */
	@ExceptionHandler(GenericAPIException.class)
	public @ResponseBody
	FailedStatus exceptionGenericHandler() {
		return new FailedStatus("Erro generico na API");
	}

	/**
	 * Exception handler for cep Validation
	 * 
	 * @return
	 */
	@ExceptionHandler(CepValidationException.class)
	public @ResponseBody
	FailedStatus exceptionCepValidationHandler(CepValidationException ex) {
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
	 * @throws CepValidationException
	 */
	private void validateCepAPI(Address address) throws CepValidationException {

		CustomCep customCep = cepService.validateCep(address.getCep());

		if (customCep == null) {
			throw new CepValidationException();
		}

		if (StringUtils.isNotBlank(customCep.getStatusMessage())) {
			throw new CepValidationException(customCep.getStatusMessage());
		}
	}


}
