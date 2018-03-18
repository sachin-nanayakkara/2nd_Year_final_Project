package com.jwt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.jwt.model.Item;

import com.jwt.service.ItemService;


@Controller
public class ItemController {

	private static final Logger logger = Logger
			.getLogger(ItemController.class);

	public ItemController() {
		System.out.println("EmployeeController()");
	}
	
	@Autowired
	private ItemService itemService;

	/*@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/")
	public ModelAndView listEmployee(ModelAndView model) throws IOException {
		List<Employee> listEmployee = employeeService.getAllEmployees();
		model.addObject("listEmployee", listEmployee);
		model.setViewName("home");
		return model;
	}
	*/
	
	
	@RequestMapping(value = "/RenderItem")
	public ModelAndView listItem(ModelAndView model) throws IOException {
		List<Item> listItem = itemService.getAllItems();
	    model.addObject("listItem", listItem);
		model.setViewName("Item_home");
		return model;
   }
   
	
	
	//newItemView
	@RequestMapping(value = "/newItem", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Item item= new Item();
		model.addObject("item", item);
		model.setViewName("ItemForm");
		return model;
	}
	
	@RequestMapping(value = "/saveItem", method = RequestMethod.POST)
	public ModelAndView saveItem(@ModelAttribute Item item) {
		if (item.getId() == 0) { // if employee id is 0 then creating the
			// employee other updating the employee
		    itemService.addItem(item);
		} else {
		   itemService.updateItem(item);
		}
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteItem", method = RequestMethod.GET)
	public ModelAndView deleteItem(HttpServletRequest request) {
		int itemId = Integer.parseInt(request.getParameter("id"));
		//employeeService.deleteEmployee(employeeId);
		itemService.deleteItem(itemId);
		return new ModelAndView("redirect:/");
    }

	@RequestMapping(value = "/editItem", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int itemid = Integer.parseInt(request.getParameter("id"));
		Item item = itemService.getItem(itemid);
		ModelAndView model = new ModelAndView("ItemForm");
		model.addObject("item", item);

		return model;
	}
	
}
