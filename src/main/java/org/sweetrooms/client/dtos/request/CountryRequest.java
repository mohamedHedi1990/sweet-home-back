package org.sweetrooms.client.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryRequest {
	private Long countryId;
	private String countryLabel;
	private String countryCode;
}
