/**
 * 
 */
package in.parteek.dao;

import java.util.*;

import javax.validation.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import in.parteek.HomeController;
import in.parteek.beans.Student;

/**
 * Created on : 2019-04-02, 3:23:03 p.m.
 *
 * @author Parteek Dheri
 */
public class Dao {
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	public int addStudent(Student obj) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		int id = (int) session.save(obj);

		session.getTransaction().commit();
		session.close();
		return id;
	}

	public List<String> validatestudent(Student s) {

		List<String> errorList = new ArrayList<String>();
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		Validator validator = vf.getValidator();

		Set<ConstraintViolation<Student>> validationError = validator.validate(s);

		if (!validationError.isEmpty()) {
			for (ConstraintViolation<Student> error : validationError) {
				log.warn("path-> {} \n message ->{}",
						error.getPropertyPath(), error.getMessage());
				errorList.add(error.getPropertyPath() + 
						" --- " + error.getMessage());
			}
		} else {
			log.info("No errors in {}", s.toString());
		}
		return errorList;

	}

}
