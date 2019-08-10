package com.luv2code.bcryptcalculator.controller;

import javax.annotation.PostConstruct;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.luv2code.bcryptcalculator.model.BcryptMessage;

@Controller
public class BcryptController {

	private BCryptPasswordEncoder bcryptEncoder;

	@PostConstruct
	public void setup() {
		bcryptEncoder = new BCryptPasswordEncoder();
	}

	@GetMapping("/")
	public String showHome(Model theModel) {
		BcryptMessage bcryptMessage = new BcryptMessage();
		theModel.addAttribute("bcryptMessage", bcryptMessage);
		return "index";
	}

	@PostMapping("/encode")
	public String encode(@ModelAttribute("bcryptMessage") BcryptMessage bcryptMessage) {

		String textFromUser = bcryptMessage.getTextFromUser();
		String encodedPassword = bcryptEncoder.encode(textFromUser);
		bcryptMessage.setEncodedPassword(encodedPassword);

		return "index";
	}

}
