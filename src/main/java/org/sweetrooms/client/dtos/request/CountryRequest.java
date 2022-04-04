package org.sweetrooms.client.dtos.request;

import java.util.Date;

import org.sweetrooms.enumeration.AnnouncementType;
import org.sweetrooms.enumeration.BedType;

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
