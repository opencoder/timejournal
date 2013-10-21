package com.timejournal.actions;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.timejournal.convertors.UserConvertor;
import com.timejournal.entities.User;
import com.timejournal.entities.dto.UserDTO;

/**
 * Action class adds to the database the new user data from Registration.jsp
 * page.
 * 
 * @author Evgeniy_Kaschavtsev
 * 
 */
@Component
public class RegisterAction /*implements Action*/ {
	
	@PersistenceContext
	EntityManager entityManager;
	
//	@Autowired
//	UserConvertor userConvertor;


	@Transactional
//	@Override	
	public String perform(HttpServletRequest request, Object model) {
		UserDTO userDTO = (UserDTO) model;
		User user =  UserConvertor.toUser(userDTO);
		System.out.println("RegisterAction: " + user.getFirstName());
		System.out.println(" breakpoint");
		System.out.println(user.toString());
		entityManager.persist(user);
		System.out.println("RegisterAction");
		return "Login";
//		return "forward:/showMyTimeJournal.action";
	}
}
