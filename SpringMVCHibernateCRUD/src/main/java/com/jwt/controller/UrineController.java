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






import com.jwt.model.PatientMedicine;
import com.jwt.model.Urine;
import com.jwt.service.UrineService;

@Controller

public class UrineController {

	private static final Logger logger = Logger
			.getLogger(UrineController.class);

	public UrineController() {
		System.out.println("UrineController()");
	}

	@Autowired
	private UrineService urineService;

	@RequestMapping(value = "/UrineView")
	public ModelAndView listUrine(ModelAndView model) throws IOException {
		List<Urine> listUrine = urineService.getAllUrines();
		model.addObject("listUrine", listUrine);
		model.setViewName("UrineHome");
		return model;
	}
	
	@RequestMapping(value = "/newUrine", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Urine urine = new Urine();
		model.addObject("urine", urine);
		model.setViewName("UrineForm");
		return model;
   }

	@RequestMapping(value = "/saveUrine", method = RequestMethod.POST)
	public ModelAndView saveUrine(@ModelAttribute Urine urine) {
		if (urine.getRegistration_no() == 0) { // if employee id is 0 then creating the
			urineService.addUrine(urine);
		} else {
			urineService.updateUrine(urine);
		}
		return new ModelAndView("redirect:/");
	}
	

	@RequestMapping(value = "/deleteUrine", method = RequestMethod.GET)
	public ModelAndView deleteUrine(HttpServletRequest request) {
		int UrineId = Integer.parseInt(request.getParameter("registration_no"));
		urineService.deleteUrine(UrineId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editUrine", method = RequestMethod.GET)
	public ModelAndView editUrine(HttpServletRequest request) {
		int UrineId = Integer.parseInt(request.getParameter("registration_no"));
		Urine urine = urineService.getUrine(UrineId);
		ModelAndView model = new ModelAndView("UrineForm");
		model.addObject("urine", urine);
		
		return model;
	}
	
	
	
	
	
}
