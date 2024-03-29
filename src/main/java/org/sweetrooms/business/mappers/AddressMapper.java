package org.sweetrooms.business.mappers;

import org.sweetrooms.dtos.AddressDto;
import org.sweetrooms.persistence.entities.Address;

public class AddressMapper {

	public static Address toAddress(AddressDto addressRequest) {
		return new Address(null, addressRequest.getAddressStreet(), addressRequest.getAddressStreetNumber(),
				CityMapper.toCity(addressRequest.getAddressCity()));
	}

	public static AddressDto toAddressDto(Address address) {
		return new AddressDto(address.getAddressStreet(), address.getAddressStreetNumber(),
				CityMapper.toCityDto(address.getAddressCity()));
	}
}
