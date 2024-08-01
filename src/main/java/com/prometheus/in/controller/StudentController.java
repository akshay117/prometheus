package com.prometheus.in.controller;

import java.util.List;

import com.prometheus.in.entity.Student;
import com.prometheus.in.repository.StudentRepository;
import com.prometheus.in.student.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {

	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

	// create an employee
	@PostMapping
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Results are ok", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))}),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
			@ApiResponse(responseCode = "404", description = "resource not found", content = @Content)})
	@Operation(summary = "Create a new Student in DB")
	public Student createStudent(@RequestBody Student student) {
		return studentService.putStudents(student);
	}



	@DeleteMapping("/{id}")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Results are ok", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))}),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
			@ApiResponse(responseCode = "404", description = "resource not found", content = @Content)})
	@Operation(summary = "Delete a record from DB")
	public void delete(@PathVariable Long  id) {
		studentService.deleteStudentById(id);

	}

	@PutMapping("/{id}")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Results are ok", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))}),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
			@ApiResponse(responseCode = "404", description = "resource not found", content = @Content)})
	@Operation(summary = "Update a record from DB")
	public void updateRecords(@RequestBody Student student) {
		studentService.updateStudent(student);
	}



}

