package com.timejournal.actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.timejournal.entities.User;

@Component
public class SignInAction /* implements Action */{

	// @Autowired
	// private UserDAO userDAO;

	// @PersistenceContext(unitName="myPersistenceUnit") protected EntityManager
	// entityManager;

	// @PersistenceContext (unitName="timejournal3")
	// protected EntityManager em;

	// @PersistenceContext
	// private EntityManager em;

	// @Override
	// public String perform(HttpServletRequest request, Object model) {
//	@Transactional
	public void perform() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("timejournal3");
		EntityManager em = emf.createEntityManager(); // Retrieve an application
														// managed entity
														// manager

		// User user = new User();
		// user.setUserId(2);
		// user.setLogin("dfgh");
		// user.setPassword("dfg876h");
		// user.setFirstName("dfgh");
		// user.setLastName("dfgh");
		// user.setEmail("dfgh@mail.ru");
		// user.setRoleId(1);

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		// em.persist(user);
		User user = (User) em
				.createQuery("select l from User l where l.login = :login")
				.setParameter("login", "asdfa123sdf").getSingleResult();
		tx.commit();
		em.close();
		emf.close();

		System.out.println("em.createQuery();");
		System.out.println("mail = " + user.getEmail());

		// String errorMsg = "";
		// HttpSession session = request.getSession();
		//
		// if ((!"".equals((String) request.getParameter("password")))
		// && (!"".equals((String) request.getParameter("login")))) {
		// User userToFind = new User();
		// userToFind.setLogin((String) request.getParameter("login"));
		// Collection<User> users = userDAO.selectUsersTO(userToFind);
		// if (users.size() != 0) {
		// User userOfDB = (User) users.toArray()[0];
		//
		// if (((String)
		// request.getParameter("password")).equals(userOfDB.getPassword())) {
		// session.setAttribute("userTO", userOfDB);
		// session.setAttribute("userType", "user");
		// errorMsg = "";
		// request.setAttribute("errorMsg", errorMsg);
		// return "forward:/showItems.action";
		// } else {
		// errorMsg = "Login or password is not valid.\n" +
		// "Please, enter it again.";
		// request.setAttribute("errorMsg", errorMsg);
		// return "Login";
		// }
		// } else {
		// errorMsg = "Login or password is not valid.\n" +
		// "Please, enter it again.";
		// request.setAttribute("errorMsg", errorMsg);
		// return "Login";
		// }
		// } else {
		// errorMsg = "Login or password is empty.\n" + "Please, enter it.";
		// request.setAttribute("errorMsg", errorMsg);
		// return "Login";
		// }
	}

	public static void main(String[] args) {
		new SignInAction().perform();
	}

}
