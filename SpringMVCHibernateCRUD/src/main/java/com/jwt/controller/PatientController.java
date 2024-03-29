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

import com.jwt.service.PatientService;


@Controller
public class PatientController {

	private static final Logger logger = Logger
			.getLogger(PatientController.class);

	public PatientController() {
		System.out.println("PatientController");
	}

	@Autowired
	private PatientService patientService;

	@RequestMapping(value = "/PatientsView")
	public ModelAndView listPatients(ModelAndView model) throws IOException {
		List<Patient> listPatient = patientService.getAllPatients();
		model.addObject("listPatient", listPatient);
		model.setViewName("PatientHome");
		return model;
	}
	
	@RequestMapping(value = "/newPatient", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Patient patient = new Patient();
		model.addObject("patient", patient);
		model.setViewName("PatientForm");
		return model;
   }

	@RequestMapping(value = "/savePatient", method = RequestMethod.POST)
	public ModelAndView savePatient(@ModelAttribute Patient patient) {
		if (patient.getRegistration_no() == 0) { // if employee id is 0 then creating the
			patientService.addPatient(patient);
		} else {
			patientService.updatePatient(patient);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deletePatient", method = RequestMethod.GET)
	public ModelAndView deletePatient(HttpServletRequest request) {
		int PatientId = Integer.parseInt(request.getParameter("registration_no"));
		patientService.deletePatient(PatientId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editPatient", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int PatientId = Integer.parseInt(request.getParameter("registration_no"));
		Patient patient = patientService.getPatient(PatientId);
		ModelAndView model = new ModelAndView("PatientForm");
		model.addObject("patient", patient);
		return model;
	}
	
}
