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



import com.jwt.model.Stock;

import com.jwt.service.StockService;

@Controller
public class StockController {

	private static final Logger logger = Logger
			.getLogger(StockController.class);

	public StockController() {
		System.out.println("StockController()");
	}

	@Autowired
	private StockService stockService;

	@RequestMapping(value = "/")
	public ModelAndView listStock(ModelAndView model) throws IOException {
		List<Stock> listStock = stockService.getAllStocks();
		model.addObject("listStock", listStock);
		model.setViewName("home");
		return model;
	}
	
/*	@RequestMapping(value = "/Patients")
	public ModelAndView listStocks(ModelAndView model) throws IOException {
		List<Stock> listStock = stockService.getAllStocks();
		model.addObject("listStock", listStock);
		model.setViewName("Patient");
		return model;
	}
	*/

	@RequestMapping(value = "/newStock", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Stock stock = new Stock();
		model.addObject("stock", stock);
		model.setViewName("EmployeeForm");
		return model;
   }

	@RequestMapping(value = "/saveStock", method = RequestMethod.POST)
	public ModelAndView saveStock(@ModelAttribute Stock stock) {
		if (stock.getIds() == 0) { // if employee id is 0 then creating the
			// employee other updating the employee
			stockService.addStock(stock);
		} else {
			stockService.updateStock(stock);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deleteStock", method = RequestMethod.GET)
	public ModelAndView deleteStock(HttpServletRequest request) {
		int stockId = Integer.parseInt(request.getParameter("ids"));
		stockService.deleteStock(stockId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editStock", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int stockId = Integer.parseInt(request.getParameter("ids"));
		Stock stock = stockService.getStock(stockId);
		ModelAndView model = new ModelAndView("EmployeeForm");
		model.addObject("stock", stock);

		return model;
	}
	
	@RequestMapping(value = "/editName", method = RequestMethod.GET)
	public ModelAndView editContacts(HttpServletRequest request) {
		String stockid = (request.getParameter("full_name"));
		Stock stock = stockService.getName(stockid);
		ModelAndView model = new ModelAndView("EmployeeForm");
		model.addObject("stock", stock);

		return model;
	}

}
