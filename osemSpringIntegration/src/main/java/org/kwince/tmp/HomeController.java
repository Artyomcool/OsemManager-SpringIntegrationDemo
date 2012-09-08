package org.kwince.tmp;

import org.elasticsearch.index.query.QueryBuilders;
import org.kwince.contribs.osem.dao.OsemManager;
import org.kwince.contribs.osem.dao.SearchResult;
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
	public String home(@RequestParam(defaultValue="0",value="page") Integer page,Model model) {
		if(page == null)page = 0;
		SearchResult<College> colleges = osem.find(QueryBuilders.matchAllQuery(), page*10, 10, College.class,"date");
		model.addAttribute("page",page);
		model.addAttribute("total",colleges.total());
		model.addAttribute("entities", colleges.result());
		return "home";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam("id") String id, Model model) {
		model.addAttribute("entity", osem.read(id, College.class));
		return "edit";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(College entity,Model model) {
		entity = osem.save(entity);
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
		osem.save(new College("test"),true);
		return "redirect:/";
	}
	
}
