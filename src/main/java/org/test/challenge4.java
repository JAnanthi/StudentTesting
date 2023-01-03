package org.test;

import org.testng.annotations.Test;

public class challenge4 extends BaseClass {
	@Test
	private void Tc3() {
		launchUrl("https://mail.google.com/mail/");
	}
	@Test
	private void Tc7() {
		launchUrl("https://www.inmakesedu.com/");
	}
	@Test
	private void Tc1() {
		launchUrl("https://m.redbus.in/");
	}
	@Test
	private void Tc9() {
		launchUrl("https://www.flipkart.com/");
	}
	@Test
	private void Tc2() {
		launchUrl("http://www.amazon.in/");
	}
	@Test
	private void Tc5() {
		launchUrl("https://www.facebook.com/");
	}
	@Test
	private void Tc4() {
		launchUrl("https://www.youtube.com/");
	}
}
