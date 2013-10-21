package com.timejournal.convertors;

import org.springframework.stereotype.Component;

import com.timejournal.entities.User;
import com.timejournal.entities.dto.UserDTO;

/**
 * 
 * @author Evgeniy_Kaschavtsev
 *
 */
public class UserConvertor {
	
	/**
	 * 
	 * @param userDTO
	 * @return
	 */
	public static User toUser(UserDTO userDTO) {
		User user = new User();
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setEmail(userDTO.getEmail());
		user.setLogin(userDTO.getLogin());
		user.setPassword(userDTO.getPassword());
		System.out.println("UserConvertor: " + userDTO.getFirstName());
		return user;
	}

}
