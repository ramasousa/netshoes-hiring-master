package com.netshoes.hiring.adressrestfull.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Address model class
 * 
 * @author raul.sousa
 * 
 */
public class Address implements Serializable, Cloneable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5150097559169157408L;

	/**
	 * Id of the address
	 */
	private String id;

	/**
	 * Street of the address
	 */
	private String street;

	/**
	 * Number of the address
	 */
	private String number;

	/**
	 * Cep of the address
	 */
	private String cep;

	/**
	 * District of the address
	 */
	private String district;

	/**
	 * City of the address
	 */
	private String city;

	/**
	 * State of the address
	 */
	private String state;

	/**
	 * Other Information of the address
	 */
	private String otherInformation;

	/**
	 * Empty constructor
	 */
	public Address() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOtherInformation() {
		return otherInformation;
	}

	public void setOtherInformation(String otherInformation) {
		this.otherInformation = otherInformation;
	}

	/**
	 * @param id
	 * @param street
	 * @param number
	 * @param cep
	 * @param district
	 * @param city
	 * @param state
	 * @param otherInformation
	 */
	public Address(String id, String street, String number, String cep,
			String district, String city, String state, String otherInformation) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.cep = cep;
		this.district = district;
		this.city = city;
		this.state = state;
		this.otherInformation = otherInformation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	/**
	 * Clone method
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
