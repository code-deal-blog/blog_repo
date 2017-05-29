package org.com.controllers;

import java.util.Date;
import java.util.List;
import org.com.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

	@ModelAttribute
	public void getAllCommonModelAttributes(Model model)
	{
		model.addAttribute("schoolName","St. Paul's Sr. Sec. School.");
	}
	
	@RequestMapping(value={"formRequest"})
	public ModelAndView viewStudentFormRequest()
	{
		return new ModelAndView("formRequest"/*,"schoolName","St. Paul's Sr. Sec. School."*/);
	}
	
	@RequestMapping(value="formRequest",method=RequestMethod.POST)
	public String processFormUsingRequestParam(@RequestParam("sName")String name,
			                                   @RequestParam("sAge")Integer age,
			                                   @RequestParam("sDob")Date dob,
			                                   @RequestParam("sHobbies")List<String> hobbies,
			                                   Model model)
	{
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		model.addAttribute("dob",dob);
		model.addAttribute("hobbies",hobbies);
		/*model.addAttribute("schoolName","St. Paul's Sr. Sec. School.");*/
		return "detailsRequest";
	}
	
	@RequestMapping("formModel")
	public ModelAndView viewStudentFormModel()
	{
		return new ModelAndView("formModel"/*,"schoolName","St. Paul's Sr. Sec. School."*/);
	}
	
	@RequestMapping(value="formModel",method=RequestMethod.POST)
	public String processFormUsingModelAttribute(@ModelAttribute Student student,
												 Model model)
	{
		model.addAttribute("student",student);
		/*model.addAttribute("schoolName","St. Paul's Sr. Sec. School.");*/
		return "detailsModel";
	}
	
}
