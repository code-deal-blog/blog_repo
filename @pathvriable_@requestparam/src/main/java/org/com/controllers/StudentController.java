package org.com.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping("student/{id}")
	public ModelAndView getStudentById(@PathVariable(value="id")Integer sId)
	{
		System.out.println("Path variable {id} = " +sId);
		return new ModelAndView("result","pathVariable",sId);
	}
	
	/*@RequestMapping(value={"student/{name}/{age}/{id}/{fees}","homePage"})
	public ModelAndView showAllPathVariables(@PathVariable("name") String sName,
											 @PathVariable("age") String sAge,
											 @PathVariable("id") Integer sId,
											 @PathVariable("fees") Long sFees)
	{
		System.out.println("name =" +sName);
		System.out.println("age =" +sAge);
		System.out.println("id =" +sId);
		System.out.println("fees =" +sFees);
		return new ModelAndView("welcome","schoolName","St. Pauls Sr. Sec. School");
	}*/
	
	@RequestMapping(value={"student/{name}/{age}/{id}","homePage"})
	public ModelAndView showAllPathVariables(@PathVariable Map<String, String> pathVariables)
	{
		System.out.println("name =" +pathVariables.get("name"));
		System.out.println("age =" +pathVariables.get("age"));
		System.out.println("id =" +pathVariables.get("id"));
		return new ModelAndView("welcome","schoolName","St. Pauls Sr. Sec. School");
	}
	
	@RequestMapping("employee")
	public String getStudentByNameAndAge(@RequestParam(value="name",required=false,defaultValue="XYZ") String sName,
			                             @RequestParam(value="age",required=false,defaultValue="21") Integer sAge,
			                             Model model)
	{
		System.out.println("Request parametres Name = " +sName+", Age = "+sAge);
		model.addAttribute("name", sName);
		model.addAttribute("age", sAge);
		return "result";
	}
	
	@RequestMapping(value={"employees","homePage"})
	public ModelAndView showAllRequestParameters(@RequestParam Map<String, String> requestParams)
	{
		System.out.println("name =" +requestParams.get("name"));
		System.out.println("age =" +requestParams.get("age"));
		System.out.println("id =" +requestParams.get("id"));
		return new ModelAndView("welcome","schoolName","St. Pauls Sr. Sec. School");
	}
	
}
