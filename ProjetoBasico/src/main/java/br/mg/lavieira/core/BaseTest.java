package br.mg.lavieira.core;

import static br.mg.lavieira.core.DriverFactory.getDriver;
import static br.mg.lavieira.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.mg.lavieira.pages.LoginPage;

public class BaseTest {
	
	@Rule
	public TestName testName = new TestName();
	
	private LoginPage loginPage = new LoginPage();
	
	@Before
	public void start() {
		loginPage.loginScreen();
		loginPage.login("leandroav.div@gmail.com", "123456");
		}	
		
	@After
	public void finish() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File file = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("target"+File.separator+"screenshot"+
				File.separator + testName.getMethodName() + ".jpg"));

		if (Properties.CLOSE_BROWSER) {
		killDriver();
		}
	}

}
