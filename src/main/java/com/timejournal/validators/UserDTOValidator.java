package com.timejournal.validators;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.timejournal.entities.User;
import com.timejournal.entities.dto.UserDTO;

@Component
@Transactional
public class UserDTOValidator implements Validator {

	// @Autowired
	// private UserDAO userDAO;
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserDTO userDTO = (UserDTO) target;

		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
		// "firstName.empty",
		// "Please, enter the first name.");
		//
		// String firstName = userDTO.getFirstName();
		// if ((!"".equals(firstName)) &&
		// (!Pattern.matches("^[a-zA-Z0-9 ,.-]+$", firstName))) {
		// errors.rejectValue("firstName", "firstName.mismatching",
		// "The first name must contains only letters,");
		// errors.rejectValue("firstName", "firstName.mismatching",
		// " ditgitals, spaces, points and commas.");
		// }

		// ValidationUtils.rejectIfEmpty(errors, "billingAddress",
		// "billingAddress.empty",
		// "Please, enter the billing address.");
		// String billingAddress = user.getBillingAddress();
		// if ((!"".equals(billingAddress))
		// && (!Pattern.matches("^[a-zA-Z0-9 ,.-]+$", billingAddress))) {
		// errors.rejectValue("billingAddress", "billingAddress.mismatching",
		// "The billing address must contains only letters,");
		// errors.rejectValue("billingAddress", "billingAddress.mismatching",
		// " ditgitals, spaces, points and commas.");
		// }

		// ValidationUtils.rejectIfEmpty(errors, "login", "login.empty",
		// "Please, enter the login.");
		// String login = userDTO.getLogin();
		// if ((!"".equals(login)) && (!Pattern.matches("^[a-zA-Z0-9 ,.-]+$",
		// login))) {
		// errors.rejectValue("login", "login.mismatching",
		// "The login must contains only letters,");
		// errors.rejectValue("login", "login.mismatching",
		// " ditgitals, spaces, points and commas.");
		// }
//
//		User newUser = new User();
//		newUser.setLogin(userDTO.getLogin());
//		
//		entityManager.createQuery("select l from Users l where l.login = :login").setParameter("login", userDTO.getLogin());
		
		try {
			User user = (User) entityManager
					.createQuery("select l from User l where l.login = :login")
					.setParameter("login", userDTO.getLogin()).getSingleResult();
			errors.rejectValue("login", "login.mismatching", "The login '"
					+ userDTO.getLogin() + "' already exists.");
			errors.rejectValue("login", "login.mismatching",
					"Please, enter another.");			
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		
//		if (userDAO.selectUsersTO(newUser).size() > 0) {
//			errors.rejectValue("login", "login.mismatching", "The login '"
//					+ newUser.getLogin() + "' already exists.");
//			errors.rejectValue("login", "login.mismatching",
//					"Please, enter another.");
//		}

		// if ((!"".equals(login)) && (!"".equals(firstName)) &&
		// (login.equals(firstName))) {
		// errors.rejectValue("login", "login.loginAsFullname",
		// "Login should not match the first name.");
		// }
		//
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
		// "password.empty",
		// "Please, enter the password.");
		// String password = userDTO.getPassword();
		// if ((!"".equals(password)) && (password.length() < 6)) {
		// errors.rejectValue("password", "password.tooShort",
		// "Password must be 6 characters minimum.");
		// }

		String password = userDTO.getPassword();
		if (!"".equals(password)) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"confirmedPassword", "confirmedPassword.mismatching",
					"Please, re-enter the password.");
			String confirmedPassword = userDTO.getConfirmedPassword();
			if (!password.equals(confirmedPassword)) {
				errors.rejectValue("confirmedPassword",
						"confirmedPassword.passwordDontMatch",
						"Passwords do not match.");
			}
		}

	}
}
