package com.timejournal.actions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;

/**
 * An interface for all actions
 * 
 * @author Evgeni_Kaschavtsev
 * 
 */
public interface Action {

	/**
	 * Method for performing action.
	 * 
	 * @return a URL
	 */
	@Transactional
	String perform(HttpServletRequest request, Object model);
}