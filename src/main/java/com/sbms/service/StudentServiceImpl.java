package com.sbms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbms.model.Student;
import com.sbms.repo.StudentRepo;
import com.sbms.util.IStudentUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepo repo;

	/*@Autowired
	private StudentUtil util;*/

	@Override
	public Integer saveStudent(Student s) {
		log.info("Inside saveStudent method of Student Service Class");
		// util.calculateDtls(s);
		IStudentUtil.calculateDtls(s);

		int idVal = repo.save(s).getStdId();
		System.out.println("Student is registered having the id value::" + idVal);
		return idVal;
	}

	@Override
	public void updateStudent(Student s) {
		log.info("Inside updateStudent method of Student Service Class");
		IStudentUtil.calculateDtls(s);
		repo.save(s);
	}

	@Override
	public void deleteStudent(Integer id) {
		log.info("Inside deleteStudent method of Student Service Class");
		repo.deleteById(id);
	}

	@Override
	public Student getOneStudent(Integer id) {
		log.info("Inside getOneStudent method of Student Service Class");
		Optional<Student> opt = repo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		log.info("Inside getAllStudents method of Student Service Class");
		List<Student> list = repo.findAll();
		// list.stream().filter(s->s.equals(list)).collect(Collectors.toList());
		return list;
	}

}
