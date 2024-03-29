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
import com.jwt.service.PatientMedicineService;


@Controller
public class PatientMedicineController {

	private static final Logger logger = Logger
			.getLogger(PatientMedicineController.class);

	public PatientMedicineController() {
		System.out.println("PatientMedicineController()");
	}

	@Autowired
	private PatientMedicineService patientMedicineService;

	@RequestMapping(value = "/PatientsMedicines")
	public ModelAndView listPatientMedicines(ModelAndView model) throws IOException {
		List<PatientMedicine> listPatientMedicine = patientMedicineService.getAllPatientMedicine();
		model.addObject("listPatientMedicine", listPatientMedicine);
		model.setViewName("PatientMedicine");
		return model;
	}
	
	@RequestMapping(value = "/newPatientMedicine", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		PatientMedicine patientMedicine = new PatientMedicine();
		model.addObject("patientMedicine", patientMedicine);
		model.setViewName("PatientMedicineForm");
		return model;
   }

	@RequestMapping(value = "/savePatientMedicine", method = RequestMethod.POST)
	public ModelAndView savePatientMedicine(@ModelAttribute PatientMedicine patientMedicine) {
		if (patientMedicine.getDignosis_no() == 0) { // if employee id is 0 then creating the
			patientMedicineService.addPatientMedicine(patientMedicine);
		} else {
			patientMedicineService.updatePatientMedicine(patientMedicine);
		}
		return new ModelAndView("redirect:/");
	}
	

	@RequestMapping(value = "/deletePatientMedicine", method = RequestMethod.GET)
	public ModelAndView deletePatientMedicine(HttpServletRequest request) {
		int PatientMedicineID = Integer.parseInt(request.getParameter("dignosis_no"));
		patientMedicineService.deletePatientMedicine(PatientMedicineID);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editPatientMedicine", method = RequestMethod.GET)
	public ModelAndView editContactPatient(HttpServletRequest request) {
		int PatientMedicineID = Integer.parseInt(request.getParameter("dignosis_no"));
		PatientMedicine patientMedicine = patientMedicineService.getPatientMedicine(PatientMedicineID);
		ModelAndView model = new ModelAndView("PatientMedicineForm");
		model.addObject("patientMedicine", patientMedicine);
		
		return model;
	}
	
	
}
