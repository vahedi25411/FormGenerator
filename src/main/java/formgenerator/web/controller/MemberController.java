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

import formgenerator.model.Member;
import formgenerator.model.Page;
import formgenerator.model.dao.MemberDAO;

@Controller
@SessionAttributes("member")
public class MemberController {

	@Autowired
	private MemberDAO memberDao;
	
	@RequestMapping("/member/list.html")
	private String list( ModelMap model)
	{
		List<Member> members = memberDao.getMembers();
		
		model.put("members", members);
		model.addAttribute("menu", "<a style='color: white' href='./list.html'>Users</a>&nbsp;&nbsp;<a style='color: white' href='../form/list.html'>Forms</a>");
		
		return "member/list";
	}
	
	@RequestMapping(value="/member/view.html",method = RequestMethod.GET)
	private String view(@RequestParam Integer id,ModelMap model)
	{
		Member member = memberDao.getMember(id);
		
		model.put("member", member);
		model.addAttribute("menu", "<a style='color: white' href='./list.html'>Users</a>&nbsp;&nbsp;<a style='color: white' href='../form/list.html'>Forms</a>");
		
		return "member/view";
	}
	
	@RequestMapping(value="/member/add.html",method = RequestMethod.GET)
	private String add(ModelMap model)
	{
		Member member = new Member();
		
		model.put("member", member);
		model.addAttribute("menu", "<a style='color: white' href='./list.html'>Users</a>&nbsp;&nbsp;<a style='color: white' href='../form/list.html'>Forms</a>");
		
		return "member/add";
	}
	
	@RequestMapping(value="/member/add.html",method = RequestMethod.POST)
	private String add( @ModelAttribute Member member)
	{
		Member savedMember = memberDao.saveMember(member);
		
		return "redirect:list.html";
	}

	@RequestMapping(value="/member/edit.html",method = RequestMethod.GET)
	private String edit(@RequestParam Integer id ,ModelMap model)
	{
		Member member = new Member();
		
		model.put("member", memberDao.getMember(id));
		model.addAttribute("menu", "<a style='color: white' href='./list.html'>Users</a>&nbsp;&nbsp;<a style='color: white' href='../form/list.html'>Forms</a>");
		
		return "member/edit";
	}
	
	@RequestMapping(value="/member/edit.html",method = RequestMethod.POST)
	private String edit( @ModelAttribute Member member, SessionStatus status)
	{
		Member savedMember = memberDao.saveMember(member);
		
		status.setComplete();
		return "redirect:list.html";
	}
	
	@RequestMapping(value="/member/delete.html",method = RequestMethod.GET)
	private String edit( @RequestParam Integer memberId)
	{
		Member member = memberDao.getMember(memberId);
		Boolean result = memberDao.delete(member);
		
		return "redirect:list.html";
	}
}
