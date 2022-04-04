package org.sweetrooms.client.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.sweetrooms.persistence.entities.Address;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {
	private String addressStreet;
    private Integer addressStreetNumber;
    private String addressCity;
    private CountryRequest addressCountry;
    
}
