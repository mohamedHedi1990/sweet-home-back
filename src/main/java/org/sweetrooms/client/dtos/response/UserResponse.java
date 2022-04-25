package org.sweetrooms.client.dtos.response;

import java.util.Date;

import org.sweetrooms.dtos.AddressDto;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
	private String userFirstName;
    private String userLastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Africa/Tunis")
    private Date userDateInscription;
    private String userEmail;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Africa/Tunis")
    private Date userBirthDate;
    private AddressDto userAddress;
}
