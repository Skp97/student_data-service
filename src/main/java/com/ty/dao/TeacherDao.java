package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ty.dto.Student;
import com.ty.dto.Teacher;
@Component
@Scope("prototype")
public class TeacherDao {
	EntityManagerFactory entityManagerFactor=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactor.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	public void insert(Teacher teacher,List<Student> students) {
		entityTransaction.begin();
		for(Student s:students) {
			entityManager.persist(s);
		}
		entityManager.persist(teacher);
		entityTransaction.commit();
	}
	public Teacher fetchByTeacherId(int id) {
		Teacher teacher=entityManager.find(Teacher.class, id);
		return teacher;
	}
	public void updateTeacherById(int id,Teacher teacher) {
		Teacher teacherToUpdate=entityManager.find(Teacher.class, id);
		if(teacherToUpdate!=null) {
			teacherToUpdate.setName(teacher.getName());
			teacherToUpdate.setPhoneNUm(teacher.getPhoneNUm());
			teacherToUpdate.setSchool(teacher.getSchool());
			teacherToUpdate.setAddress(teacher.getAddress());
			entityTransaction.begin();
			entityManager.persist(teacherToUpdate);
			entityTransaction.commit();
		}
	}
	public void deleteById(int id) {
		Teacher teacher=entityManager.find(Teacher.class, id);
		System.out.println(teacher);
		entityTransaction.begin();
		entityManager.remove(teacher);
		entityTransaction.commit();
		
	}
	
}
