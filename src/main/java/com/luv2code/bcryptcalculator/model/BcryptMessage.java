package com.luv2code.bcryptcalculator.model;

import lombok.Data;

@Data
public class BcryptMessage {
	
	private String textFromUser;
	
	private String encodedPassword;

	public String getTextFromUser() {
		return textFromUser;
	}

	public void setTextFromUser(String textFromUser) {
		this.textFromUser = textFromUser;
	}

	public String getEncodedPassword() {
		return encodedPassword;
	}

	public void setEncodedPassword(String encodedPassword) {
		this.encodedPassword = encodedPassword;
	}
}
