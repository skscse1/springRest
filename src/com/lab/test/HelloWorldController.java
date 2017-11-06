package com.lab.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HelloWorldController {

	@RequestMapping("/hello")
	public ModelAndView helloworld()
	{
		/*
		Student st1=new Student();
		st1.setFirstname("Sukesh");
		st1.setLastname("Singh");
		st1.setId(100);*/
		ModelAndView model=new ModelAndView("helloworld");
		
		model.addObject("msg","Hello World");
		return model;
	}
	@ResponseBody
	@RequestMapping(value="/students", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getStudentList()
	{
		Student st1=new Student();
		st1.setFirstname("Sukesh");
		st1.setLastname("Singh");
		st1.setId(100);
		
		Student st2=new Student();
		st2.setFirstname("Mukesh");
		st2.setLastname("Singh");
		st2.setId(200);
		
		ArrayList<Student> studentList=new ArrayList<Student>();
		studentList.add(st1);
		studentList.add(st2);
		return studentList;
	}
	//REST Method to get value according to name specified by the user
	@ResponseBody
	@RequestMapping(value="/students/{name}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Student getStudent(@PathVariable("name") String studentName)
	{
		Student st4=new Student();
		
		st4.setFirstname(studentName);
		st4.setId(300);
		st4.setLastname("Singh");
		
		return st4;
	}
	//Rest Method to Update the existing record using PUT method
	@ResponseBody
	@RequestMapping(value="/students/{name}",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public boolean updateStudent(@PathVariable("name") String studentName,@RequestBody Student st)
	{
		System.out.println("Student Name is:--->"+studentName);
		System.out.println("Student Details are:-->");
		System.out.println("Student id is:-->"+st.getId());
		System.out.println("Student last name is:-->"+st.getLastname());
		
		return true; 
	}
	//Rest Method to create new record using POST method
	@ResponseBody
	@RequestMapping(value="/students",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> postStudent(@RequestBody Student st)
	{
		System.out.println("Student Details are:-->");
		System.out.println("Student id is:-->"+st.getId());
		System.out.println("Student First Name is:-->"+st.getFirstname());
		System.out.println("Student last name is:-->"+st.getLastname());
		
		return new ResponseEntity<Boolean>(HttpStatus.CREATED);
	}
	//REST method to delete a record using delete operation 
	@ResponseBody
	@RequestMapping(value="/students/{name}",method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteStudent(@PathVariable("name") String studentName)
	{
		
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}
}
