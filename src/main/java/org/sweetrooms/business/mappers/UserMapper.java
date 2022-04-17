package org.sweetrooms.business.mappers;

import org.sweetrooms.dtos.UserDto;
import org.sweetrooms.persistence.entities.User;

public class UserMapper {

	public static UserDto toUserDto(User user) {
		return new UserDto(user.getUserFirstName(), user.getUserLastName(), user.getUserDateInscription());
	}
}
