package com.sansthas.springmvc.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sansthas.springmvc.model.Student;
import com.sansthas.springmvc.service.StudentService;

@Controller
@RequestMapping("/")
public class SansthasController {

	@Autowired
	StudentService service;
	
	@Autowired
	MessageSource messageSource;

	/*
	 * List all existing Students.
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listStudents(ModelMap model) {

		List<Student> students = service.findAllStudents();
		model.addAttribute("students", students);
		return "allstudents";
	}

	/*
	 * Add a new Student.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newStudent(ModelMap model) {
		Student student = new Student();
		model.addAttribute("student", student);
		model.addAttribute("edit", false);
		return "registration";
	}

	/*
	 * Handling POST request for validating the user input and saving Student in database.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveStudent(@Valid Student student, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}
		
		if(!service.isStudentCodeUnique(student.getId())){
			FieldError codeError =new FieldError("Student","id",messageSource.getMessage("non.id.id", new Integer[]{student.getId()}, Locale.getDefault()));
		    result.addError(codeError);
			return "registration";
		}
		
		service.saveStudent(student);

		model.addAttribute("success", "Student " + student.getName() + " registered successfully");
		return "success";
	}


	/*
	 * Provide the existing Student for updating.
	 */
	@RequestMapping(value = { "/edit-{id}-student" }, method = RequestMethod.GET)
	public String editStudent(@PathVariable Integer id, ModelMap model) {
		Student student = service.findStudentById(id);
		model.addAttribute("student", student);
		model.addAttribute("edit", true);
		return "registration";
	}
	
	/*
	 * Handling POST request for validating the user input and updating Student in database.
	 */
	@RequestMapping(value = { "/edit-{id}-student" }, method = RequestMethod.POST)
	public String updateStudent(@Valid Student student, BindingResult result,
			ModelMap model, @PathVariable String id) {

		if (result.hasErrors()) {
			return "registration";
		}

		if(!service.isStudentCodeUnique(student.getId())){
			FieldError codeError =new FieldError("Student","id",messageSource.getMessage("non.id.code", new Integer[]{student.getId()}, Locale.getDefault()));
		    result.addError(codeError);
			return "registration";
		}

		service.updateStudent(student);

		model.addAttribute("success", "Student " + student.getName()	+ " updated successfully");
		return "success";
	}

	
	/*
	 * Delete an Student by it's CODE value.
	 */
	@RequestMapping(value = { "/delete-{id}-student" }, method = RequestMethod.GET)
	public String deleteStudent(@PathVariable Integer id) {
		service.deleteStudentById(id);
		return "redirect:/list";
	}

}
