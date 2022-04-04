package org.sweetrooms.business.mappers;

import org.sweetrooms.client.dtos.request.AddressRequest;
import org.sweetrooms.persistence.entities.Address;

public class AddressMapper {

	public static Address toAddress(AddressRequest addressRequest)  {
		return new Address(null, addressRequest.getAddressStreet(), addressRequest.getAddressStreetNumber(), addressRequest.getAddressCity(),
				CountryMapper.toCountry(addressRequest.getAddressCountry()));
	}
}
