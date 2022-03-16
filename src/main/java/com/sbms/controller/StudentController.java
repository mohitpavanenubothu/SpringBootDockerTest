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

import com.sbms.exception.StudentNotFoundException;
import com.sbms.model.Student;
import com.sbms.service.IStudentService;
import com.sbms.vo.CommanResponse;

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
	public ResponseEntity<?> saveStudent(@RequestBody Student student) throws Exception {
		log.info("Inside saveStudent method of Student Controller");
		Integer id = service.saveStudent(student);
		String result = "Student saved with Id" + id;
		// return ResponseEntity.status(HttpStatus.OK).body(new CommanResponse());
		return CommanResponse.generateResponse("Successfully Student data inserted", HttpStatus.CREATED, result);
	}

	// 2.update
	@PutMapping("/update")
	public ResponseEntity<Object> updateStudent(@RequestBody Student student) throws Exception {
		log.info("Inside updateStudent method of Student Controller");
		Integer id = service.updateStudent(student);
		System.out.println("Update record id is" + id);
		String body = "Student Updated!" + student.getStdId();
		return CommanResponse.generateResponse("Student data is Updated", HttpStatus.OK, body);
	}

	// 3.find by did
	@GetMapping("/find/{id}")
	public ResponseEntity<Object> fetchOneStudent(@PathVariable Integer id) throws StudentNotFoundException {
		log.info("Inside fetchOneStudent method of Student Controller");
		Student student = service.getOneStudent(id);
		return CommanResponse.generateResponse("This StudentId Details is", HttpStatus.OK, student);

	}

	// 4.find all
	@GetMapping("/allStudents")
	public ResponseEntity<?> getAllStudents() throws StudentNotFoundException {
		log.info("Inside getAllStudents method of Student Controller");
		List<Student> list = service.getAllStudents();
		return CommanResponse.generateResponse("All Student Details are", HttpStatus.OK, list);
	}

	// 5.delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable Integer id) throws StudentNotFoundException {
		log.info("Inside deleteStudent method of Student Controller");
		service.deleteStudent(id);
		String body = "Student deleted succussfully with id::" + id;
		return CommanResponse.generateResponse("Tourist Deleted Successfully", HttpStatus.OK, body);
	}

}
