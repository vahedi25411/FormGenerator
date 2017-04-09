package formgenerator.web.controller;

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

import formgenerator.model.Page;
import formgenerator.model.dao.FormDAO;
import formgenerator.model.dao.PageDAO;

@Controller
@SessionAttributes("page")
public class PageController {
	
	@Autowired
	private PageDAO pageDao;
	@Autowired
	private FormDAO formDao;
	
	@RequestMapping("/page/list.html")
	private String list(@RequestParam Integer formId ,ModelMap model)
	//private String list(ModelMap model)
	{
		if (formId>0)
		{
			List<Page> pages = pageDao.getPages(formId);
			
			//List<Page> pages = pageDao.getPages();
			
			model.put("pages", pages);
			model.addAttribute("formId", formId);
			model.addAttribute("menu", "<a style='color: white' href='../member/list.html'>Users</a>&nbsp;&nbsp;<a style='color: white' href='../form/list.html'>Forms</a>&nbsp;>&nbsp;<a style='color: white' href='list.html?formId="+formId+"'>Pages</a>");
			
			return "page/list";
		}
		else
		{
			return "form/list";
		}
		
	}
	
	@RequestMapping(value="/page/add.html",method = RequestMethod.GET)
	private String add(ModelMap model,@RequestParam Integer formId)
	{
		Page page = new Page();
		
		model.put("page", page);
		model.addAttribute("formId", formId);
		model.addAttribute("menu", "<a style='color: white' href='../member/list.html'>Users</a>&nbsp;&nbsp;<a style='color: white' href='../form/list.html'>Forms</a>&nbsp;>&nbsp;<a style='color: white' href='list.html?formId="+formId+"'>Pages</a>");
		
		return "page/add";
	}
	
	@RequestMapping(value="/page/add.html",method = RequestMethod.POST)
	private String add( @ModelAttribute Page page,@RequestParam Integer formId)
	{
		page.setForm(formDao.getForm(formId));
		Page savedPage = pageDao.savePage(page);
		
		return "redirect:list.html?formId="+formId;
	}


	@RequestMapping(value="/page/edit.html",method = RequestMethod.GET)
	private String edit(@RequestParam Integer formId,@RequestParam Integer pageId, ModelMap model)
	{
		
		model.put("page", pageDao.getPage(pageId));
		model.addAttribute("formId", formId);
		model.addAttribute("menu", "<a style='color: white' href='../member/list.html'>Users</a>&nbsp;&nbsp;<a style='color: white' href='../form/list.html'>Forms</a>&nbsp;>&nbsp;<a style='color: white' href='list.html?formId="+formId+"'>Pages</a>");
		
		return "page/edit";
	}
	
	@RequestMapping(value="/page/edit.html",method = RequestMethod.POST)
	private String edit( @ModelAttribute Page page,@RequestParam Integer formId, SessionStatus status)
	{

		Page savedPage = pageDao.savePage(page);
		
		status.setComplete();
		
		return "redirect:list.html?formId="+formId;
	}
	
	@RequestMapping(value="/page/delete.html",method = RequestMethod.GET)
	private String edit( @RequestParam Integer formId, @RequestParam Integer pageId)
	{
		Page page = pageDao.getPage(pageId);
		Boolean result = pageDao.delete(page);
		
		return "redirect:list.html?formId="+formId;
	}


}
