package formgenerator.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import formgenerator.model.Form;
import formgenerator.model.FormElement;
import formgenerator.model.Page;
import formgenerator.model.dao.FormDAO;
import formgenerator.model.dao.PageDAO;

@Controller
@SessionAttributes("form")
public class FormController {
	@Autowired
	private FormDAO formDao;
	@Autowired
	private PageDAO pageDao;

	@RequestMapping(value={"index.html","add.html","edit.html"})
	private String index(ModelMap model)
	{
		
		return "redirect:form/list.html";
	
		
	}
	
	@RequestMapping(value={"form/list.html"})
	private String list(ModelMap model)
	{
		List<Form> forms = formDao.getForms();
		
		model.put("forms", forms);
		model.addAttribute("menu", "<a style='color: white' href='../member/list.html'>Users</a>&nbsp;&nbsp;<a style='color: white' href='./list.html'>Forms</a>");
		
		return "form/list";
	
		
	}
	
	@RequestMapping(value={"/form/add.html"},method = RequestMethod.GET)
	private String add(ModelMap model)
	{
		Form form = new Form();
		
		model.put("form", form);
		model.addAttribute("menu", "<a style='color: white' href='../member/list.html'>Users</a>&nbsp;&nbsp;<a style='color: white' href='./list.html'>Forms</a>");
		
		return "form/add";
	}
	
	@RequestMapping(value={"/form/add.html"},method = RequestMethod.POST)
	private String add( @ModelAttribute Form form)
	{
		Date myDate = new Date();
		form.setCreatedDate(new java.sql.Timestamp(myDate.getTime()));
		Form savedForm = formDao.saveForm(form);
		
		return "redirect:list.html";
	}


	@RequestMapping(value={"/form/edit.html"},method = RequestMethod.GET)
	private String edit(@RequestParam Integer id, ModelMap model)
	{
		
		model.put("form", formDao.getForm(id));
		model.addAttribute("menu", "<a style='color: white' href='../member/list.html'>Users</a>&nbsp;&nbsp;<a style='color: white' href='./list.html'>Forms</a>");
		
		return "form/edit";
	}
	
	@RequestMapping(value={"/form/edit.html"},method = RequestMethod.POST)
	private String edit( @ModelAttribute Form form, SessionStatus status)
	{
		Date myDate = new Date();
		form.setModifiedDate(new java.sql.Timestamp(myDate.getTime()));
		Form savedForm = formDao.saveForm(form);
		
		status.setComplete();
		
		return "redirect:list.html";
	}
	@RequestMapping(value={"/form/preview.html"},method = RequestMethod.GET)
	private String preview(ModelMap model,@RequestParam Integer formId,@RequestParam(required=false) Integer fpId)
	{
		if (fpId==null)
		{
			fpId=0;
		}
		String html="", pageLinks="Form pages : ";
		int counter=1,defaultPage=0;
		boolean isValid=false;
		Form curForm = formDao.getForm(formId);
		
		
		for(Page p:curForm.getPages())
		{
			if (counter==1)  defaultPage=p.getId();
			if (fpId==p.getId()) isValid=true;
			pageLinks = pageLinks + "<a href='preview.html?fpId="+p.getId()+"&formId="+formId+"'>"+counter+"</a>&nbsp;&nbsp;";
			counter++;		
			
		}
		
		Page p;
		if (fpId>0 && isValid)
		{
			p= pageDao.getPage(fpId);

		}
		else
		{
			p= pageDao.getPage(defaultPage);
		}
		
		for(FormElement e : p.getElements())
		{
			html = html + e.toString();
		}
		
		model.put("form", curForm);
		model.addAttribute("html", html);
		model.addAttribute("menu", "<a style='color: white' href='../member/list.html'>Users</a>&nbsp;&nbsp;<a style='color: white' href='./list.html'>Forms</a>");
		model.addAttribute("pageLinks", pageLinks);
		
		return "form/preview";
	}
	
	@RequestMapping(value="/form/delete.html",method = RequestMethod.GET)
	private String edit( @RequestParam Integer formId)
	{
		Form form = formDao.getForm(formId);
		Boolean result = formDao.delete(form);
		
		return "redirect:list.html";
	}

	
}
