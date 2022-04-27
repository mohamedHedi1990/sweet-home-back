package org.sweetrooms.client.dtos.response;

import java.util.Date;

import org.sweetrooms.dtos.AddressDto;
import org.sweetrooms.enumeration.RoleCode;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsResponse {
	private String userFirstName;
	private String userLastName;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Africa/Tunis")
	private Date userDateInscription;
	private String userEmail;
	private String userPhoneNumber;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Africa/Tunis")
	private Date userBirthDate;
	private AddressDto userAddress;
    private RoleCode role;
    private String userPictureUrl;
}
