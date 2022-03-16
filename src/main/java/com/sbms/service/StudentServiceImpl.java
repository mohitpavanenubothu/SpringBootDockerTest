package com.sbms.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbms.exception.StudentNotFoundException;
import com.sbms.model.Student;
import com.sbms.repo.StudentRepo;
import com.sbms.util.IStudentUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepo repo;

	/*
	 * @Autowired private StudentUtil util;
	 */

	@Override
	public Integer saveStudent(Student s) throws Exception {
		log.info("Inside saveStudent method of Student Service Class");
		// util.calculateDtls(s);
		IStudentUtil.calculateDtls(s);

		int idVal = repo.save(s).getStdId();
		System.out.println("Student is registered having the id value::" + idVal);
		return idVal;
	}

	@Override
	public Integer updateStudent(Student s) throws Exception {
		Integer i = 0;
		log.info("Inside updateStudent method of Student Service Class");
		try {
			IStudentUtil.calculateDtls(s);
			repo.save(s);
			i = 1;
		} catch (Exception e) {
			i = 0; // TODO: handle exception
		}
		return i;
	}

	@Override
	public Integer deleteStudent(Integer id) throws StudentNotFoundException {
		Integer i = 0;
		log.info("Inside deleteStudent method of Student Service Class");
		try {
			repo.deleteById(id);
			i = 1;
		} catch (Exception e) {
			i = 0;
			// TODO: handle exception
		}
		return i;
	}

	@Override
	public Student getOneStudent(Integer id) throws StudentNotFoundException {
		log.info("Inside getOneStudent method of Student Service Class");
		Optional<Student> opt = repo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Override
	public List<Student> getAllStudents() throws StudentNotFoundException {
		log.info("Inside getAllStudents method of Student Service Class");
		List<Student> list = repo.findAll();
		// for each inside lamda
		// list.stream().forEach(s -> System.out.println(s));

		// Method reference
		list.stream().forEach(System.out::println);
		// convert to list to map using streams api
		Map<String, String> map = list.stream().collect(Collectors.toMap(Student::getStdName, Student::getStdCourse));
		System.out.println("Map data is" + map);

		return list;
	}

}
