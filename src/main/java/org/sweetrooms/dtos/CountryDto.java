package org.sweetrooms.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto {
	private Long countryId;
	private String countryLabel;
	private String countryCode;
}
