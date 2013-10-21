/**
 * 
 */
package com.timejournal.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.timejournal.actions.RegisterAction;
import com.timejournal.actions.SignInAction;
import com.timejournal.entities.User;
import com.timejournal.entities.dto.UserDTO;
import com.timejournal.validators.UserDTOValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Valid;

/**
 * @author Evgeniy_Kaschavtsev
 *
 */

@Controller
public class TimeJournalController {

	@Autowired
	private SignInAction signInAction;
	@Autowired
	private RegisterAction registerAction;
	@Autowired
	private UserDTOValidator userDTOValidator;	
	
	@RequestMapping(value = "/signIn.action", method = RequestMethod.POST)
	public void signIn(HttpServletRequest request, HttpServletResponse response) {
		signInAction.perform();
	}
	
	@RequestMapping(value = "/registration.action")
	public String registration(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
//		model.addAttribute("user", new User());
		
//		UserDTO userDTO = new UserDTO();
			
		model.put("userDTO", new UserDTO());
		return "Registration";
	}
	
	@RequestMapping(value = "/register.action", method = RequestMethod.POST)
//	public String register(HttpServletRequest request, @ModelAttribute("user") User user,
	@Transactional
	public String register(HttpServletRequest request, @ModelAttribute("userDTO") @Valid UserDTO userDTO,
			BindingResult result) {
//		userValidator.validate(user, result);
		
//		System.out.println(result.hasErrors());
//		System.out.println("password from request = " + (String) request.getParameter("password"));
//		System.out.println();
		userDTOValidator.validate(userDTO, result);
		if (result.hasErrors()) {
			return "Registration";
		}
		return registerAction.perform(request, userDTO);
	}
	
	
}
