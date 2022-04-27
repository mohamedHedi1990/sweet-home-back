package org.sweetrooms.business.mappers;

import org.sweetrooms.client.dtos.response.UserDetailsResponse;
import org.sweetrooms.dtos.UserDto;
import org.sweetrooms.enumeration.MediaContext;
import org.sweetrooms.persistence.entities.User;

public class UserMapper {

	public static UserDto toUserDto(User user) {
		return new UserDto(user.getUserFirstName(), user.getUserLastName(), user.getUserDateInscription());
	}

	public static UserDetailsResponse toUserDetailsResponse(User user) {
		return new UserDetailsResponse(user.getUserFirstName(), user.getUserLastName(), user.getUserDateInscription(),
				user.getUserEmail(), user.getUserPhoneNumber(), user.getUserBirthDate(),
				AddressMapper.toAddressDto(user.getUserAddress()), user.getUserRole().getRoleCode(),
				user.getUserMedias().stream().filter(media -> media.getMediaContext() == MediaContext.PICTURE_PROFIL)
						.map(media -> media.getMediaUrl()).findFirst().orElse(null));
	}
}
