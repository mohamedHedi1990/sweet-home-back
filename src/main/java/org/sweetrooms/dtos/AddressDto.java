package org.sweetrooms.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
	private String addressStreet;
    private Integer addressStreetNumber;
    //private String addressCity;
    private CityDto addressCity;
    
}
