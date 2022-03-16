package com.sbms.service;

import java.util.List;

import com.sbms.exception.StudentNotFoundException;
import com.sbms.model.Student;

public interface IStudentService {

	//1.save
	public Integer saveStudent(Student s) throws Exception ;

	//2.update
	public Integer updateStudent(Student s) throws Exception;

	//3.Delete
	public Integer deleteStudent(Integer id) throws StudentNotFoundException;

	//4.Fetch one student
	public Student getOneStudent(Integer id) throws StudentNotFoundException;

	//5.All
	public List<Student> getAllStudents() throws StudentNotFoundException;

}
