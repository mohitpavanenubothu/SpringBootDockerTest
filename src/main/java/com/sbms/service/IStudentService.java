package com.sbms.service;

import java.util.List;

import com.sbms.model.Student;

public interface IStudentService {

	public Integer saveStudent(Student s);

	public void updateStudent(Student s);

	public void deleteStudent(Integer id);

	public Student getOneStudent(Integer id);

	public List<Student> getAllStudents();

}
