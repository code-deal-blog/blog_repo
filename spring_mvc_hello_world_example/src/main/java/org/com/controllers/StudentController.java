package org.com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

	@RequestMapping(value={"/","homePage"})
	public ModelAndView showHomePage()
	{
		return new ModelAndView("home");
	}
	
	@RequestMapping("welcomePage")
	public ModelAndView showWelcomePage()
	{
		return new ModelAndView("welcome","schoolName","St. Pauls Sr. Sec. School");
	}
}
