package org.kwince.tmp;

import java.util.List;

import org.kwince.contribs.osem.dao.OsemManager;
import org.kwince.contribs.osem.event.EventDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
		
	@Autowired
	private EventDispatcher dispatcher;
	@Autowired
	private OsemManager osem;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<College> colleges = osem.find("{match_all:{}}", College.class);
		model.addAttribute("entities", colleges);
		return "home";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam("id") String id, Model model) {
		model.addAttribute("entity", osem.read(id, College.class));
		return "edit";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(College entity,Model model) {
		entity = osem.update(entity);
		model.addAttribute("entity", entity);
		return "saved";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String save(@RequestParam("id") String id,Model model) {
		College c = osem.read(id, College.class);
		if(c == null) {
			model.addAttribute("id", id);
			return "not_found";
		}
		model.addAttribute("entity", c);
		osem.delete(c);
		return "deleted";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		osem.create(new College("test"));
		return "redirect:/";
	}
	
}
