/**
 * 
 */
package in.parteek;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import in.parteek.beans.Student;
import in.parteek.dao.Dao;

/**
 * Created on : 2019-04-01, 11:28:15 p.m.
 *
 * @author Parteek Dheri
 */
@Controller
public class HomeController {

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	private Dao dao = new Dao();

	@RequestMapping("/")
	public String goHome(Model model) {
//		Student stud1 = new Student(5,"ishan","9t7 9t8","1@gmail.com");
//		Student stud2 = new Student(0,null,"9t7 9t8","1@gmail.com");
//		Student stud3 = new Student(5,"AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH","9t7 9t8","1@gmail.com");
//		dao.validatestudent(stud1);
		model.addAttribute("student", new Student());

		return "homee";
	}

	@RequestMapping("/createStudent")
	public String createStudent(Model model, @ModelAttribute Student student) {
		log.info("student at {}", student.toString());
		List<String> errorList = dao.validatestudent(student);
		if (errorList.isEmpty()) {
			dao.addStudent(student);
			model.addAttribute("student",new Student());
		}else {
			model.addAttribute("errorList",errorList);
		}
		return "homee";
	}

}
