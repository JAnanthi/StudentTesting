package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Challenge6 {
	@Parameters("browser")
	@Test
	private void tc1(String browserName) {
		WebDriver driver;
		if(browserName.equals("chromebrowser")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
else if (browserName.equals("Firefoxbrowser")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
}
else {
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver();
	
}
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		
	}
	

}
