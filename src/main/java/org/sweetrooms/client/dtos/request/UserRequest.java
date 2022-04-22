package org.sweetrooms.client.dtos.request;

import java.util.Date;

import lombok.ToString;
import org.sweetrooms.enumeration.Provider;
import org.sweetrooms.enumeration.RoleCode;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRequest {

    private Long userId;
	private String userEmail;
	private String userPassword;
	private String userLogin;
	private String userFirstName;
	private String userLastName;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Africa/Tunis")
	private Date userBirthDate;
	private AddressRequest userAddress;
	private Provider provider;
	private RoleCode userType;
}
