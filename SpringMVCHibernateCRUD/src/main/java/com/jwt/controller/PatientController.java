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





import com.jwt.model.Patient;
import com.jwt.model.Stock;
import com.jwt.service.PatientService;


@Controller
public class PatientController {

	private static final Logger logger = Logger
			.getLogger(PatientController.class);

	public PatientController() {
		System.out.println("StockController()");
	}

	@Autowired
	private PatientService patientService;

	@RequestMapping(value = "/Patients")
	public ModelAndView listPatients(ModelAndView model) throws IOException {
		List<Patient> listPatient = patientService.getAllPatients();
		model.addObject("listPatient", listPatient);
		model.setViewName("Patient");
		return model;
	}
	
	
	
}
