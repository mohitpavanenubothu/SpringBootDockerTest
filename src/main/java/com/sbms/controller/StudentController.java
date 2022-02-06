package com.sbms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbms.model.Student;
import com.sbms.service.IStudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/student")
@Slf4j
@Api("All about students")
public class StudentController {

	@Autowired
	private IStudentService service;

	// 1.save
	@PostMapping("/save")
	@ApiOperation("For Student registration")
	public ResponseEntity<String> saveStudent(@RequestBody Student student) {
		try {
			log.info("Inside saveStudent method of Student Controller");
			Integer id = service.saveStudent(student);
			String body = "Student saved with Id" + id;
			return new ResponseEntity<String>(body, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Inside saveStudent method problem occured");
			return new ResponseEntity<String>("Problem in save Student method", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// 2.update
	@PutMapping("/update")
	public ResponseEntity<String> updateStudent(@RequestBody Student student) {
		log.info("Inside updateStudent method of Student Controller");
		service.updateStudent(student);
		String body = "Student Updated!" + student.getStdId();
		return ResponseEntity.ok(body);
	}

	// 3.find by did
	@GetMapping("/find/{id}")
	public ResponseEntity<Student> fetchOneStudent(@PathVariable Integer id) {
		log.info("Inside fetchOneStudent method of Student Controller");
		Student s = service.getOneStudent(id);
		return ResponseEntity.ok(s);

	}

	// 4.find all
	@GetMapping("/allStudents")
	public ResponseEntity<List<Student>> getAllStudents() {
		log.info("Inside getAllStudents method of Student Controller");
		List<Student> list = service.getAllStudents();
		return ResponseEntity.ok(list);
	}

	// 5.delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
		log.info("Inside deleteStudent method of Student Controller");
		service.deleteStudent(id);
		String body = "Student deleted succussfully with id::" + id;
		return ResponseEntity.ok(body);

	}

}
