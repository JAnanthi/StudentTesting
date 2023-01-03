package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Sample extends BaseClass {
	public static void main(String[] args) {
		launchBrowser();
		launchUrl("https://mail.google.com/mail/");
		windowMaximize();
		FbloginPojo f=new FbloginPojo();

		passText("ananthi",f.getEmail());
	
		clickbtn(f.getNxtbtn());
		
		

	}

}
