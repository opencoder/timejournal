package com.timejournal.entities.dto;

import com.timejournal.entities.User;

/**
 * 
 * @author Evgeniy_Kaschavtsev
 *
 */
public class UserDTO extends User {

	private static final long serialVersionUID = -396042141475042785L;

	private String confirmedPassword;

	public String getConfirmedPassword() {
		return confirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}

}
