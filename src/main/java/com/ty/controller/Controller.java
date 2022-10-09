package com.ty.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ty.config.TeacherStudentConfig;
import com.ty.dao.TeacherDao;
import com.ty.dto.Student;
import com.ty.dto.Teacher;
import com.ty.service.CalGrade;

public class Controller {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(TeacherStudentConfig.class);
		CalGrade calGrade=(CalGrade) applicationContext.getBean("calGrade");
		Teacher teacher=(Teacher) applicationContext.getBean("teacher");
		teacher.setName("Dr S K Chand");
		teacher.setPhoneNUm(8665412);
		teacher.setSchool("IGIT");
		teacher.setAddress("Sarang");
		
		Student student1=(Student) applicationContext.getBean("student");
		student1.setName("Skp");
		student1.setPhoneNUm(12345);
		student1.setMaths(80);
		student1.setSocialScience(69);
		student1.setEnglish(76);
		student1.setScience(75);
		student1.setGrade(calGrade.grade(student1));
		
		Student student2=(Student) applicationContext.getBean("student");
		student2.setName("Szy");
		student2.setPhoneNUm(12378);
		student2.setMaths(30);
		student2.setSocialScience(69);
		student2.setEnglish(45);
		student2.setScience(39);
		student2.setGrade(calGrade.grade(student2));
		
		Student student3=(Student) applicationContext.getBean("student");
		student3.setName("Swt");
		student3.setPhoneNUm(123490);
		student3.setMaths(70);
		student3.setSocialScience(69);
		student3.setEnglish(76);
		student3.setScience(75);
		student3.setGrade(calGrade.grade(student3));
		
		List<Student> students=new ArrayList<Student>();
		students.add(student3);
		students.add(student2);
		students.add(student1);
		
		teacher.setStudents(students);
		System.out.println(student1);
		System.out.println(student2);
		
		TeacherDao  teacherDao=(TeacherDao) applicationContext.getBean("teacherDao");
		teacherDao.insert(teacher,students);
		
		Teacher teacherFetch=teacherDao.fetchByTeacherId(1);
		System.out.println(teacherFetch);
		
		Teacher teacher1=(Teacher) applicationContext.getBean("teacher");
		teacher1.setName("Dr P K Mallick");
		teacher1.setPhoneNUm(99876);
		teacher1.setSchool("CET");
		teacher1.setAddress("BBSR");
		
		teacherDao.updateTeacherById(2,teacher1);
		
		teacherDao.deleteById(1);
		
	
			
		}
		
		
		
		
		
		
		
		
		
	}

