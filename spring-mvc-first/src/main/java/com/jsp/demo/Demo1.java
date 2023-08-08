package com.jsp.demo;

import java.sql.Time;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Demo1 {
	@RequestMapping("/test1")
	public ModelAndView test1() {

		ModelAndView andView = new ModelAndView("first.jsp");
		andView.addObject("msg", "welcome to spring mvc");
		return andView;
	}

	@RequestMapping("/test2")
	public ModelAndView test2() {
		ModelAndView andView = new ModelAndView("time.jsp");
		andView.addObject("time", LocalDateTime.now());
		return andView;
	}

	@RequestMapping("/test3")
	public ModelAndView test3() {
		Student student = new Student();
		student.setId(1);
		student.setName("ram");
		student.setAge(22);

		ModelAndView andView = new ModelAndView("third.jsp");
		andView.addObject("student", student);
		return andView;
	}
	
	@RequestMapping("/loadstu")
	public ModelAndView load() {
		ModelAndView andView=new ModelAndView("register.jsp");
		andView.addObject("stu",new Student());
		return andView;
	}
	@RequestMapping("/datastu")
	public ModelAndView save(@ModelAttribute Student student) {
		ModelAndView andView=new ModelAndView("third.jsp");
		andView.addObject("student",student);
		return andView;
	}
	@RequestMapping("/datastu1")
	public void data(@ModelAttribute Student student) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("god");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		if(student !=null) {
			entityTransaction.begin();
			entityManager.persist(student);
			entityTransaction.commit();
		}
	}

}