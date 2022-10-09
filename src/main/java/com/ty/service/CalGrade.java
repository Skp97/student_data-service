package com.ty.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ty.dto.Student;
@Component
@Scope("prototype")
public class CalGrade {
	public char grade(Student student) {
		
		int percentage=(student.getEnglish()+student.getEnglish()+student.getScience()+student.getSocialScience())/4;
		
		if(percentage>=60)
		  return 'A';
		else if(percentage<60 && percentage>=45 )
			return 'B';
		else if(percentage<45 && percentage>=30)
			return 'C';
		else
			return 'F';	
	}
}
