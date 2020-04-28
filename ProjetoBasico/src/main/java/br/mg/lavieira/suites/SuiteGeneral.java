package br.mg.lavieira.suites;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.mg.lavieira.core.DriverFactory;
import br.mg.lavieira.pages.LoginPage;
import br.mg.lavieira.tests.TestAccounts;
import br.mg.lavieira.tests.TestBalance;
import br.mg.lavieira.tests.TestDeleteAccountMovement;
import br.mg.lavieira.tests.TestMovement;
import br.mg.lavieira.tests.TestSummary;

@RunWith(Suite.class)
@SuiteClasses({
	TestAccounts.class,
	TestMovement.class,
	TestDeleteAccountMovement.class,
	TestBalance.class,
	TestSummary.class
	
})
public class SuiteGeneral {
	private static LoginPage loginPage = new LoginPage();
	
	
	@BeforeClass
	public static void reset() {
		
		loginPage.loginScreen();
		
		loginPage.login("leandroav.div@gmail.com", "123456");
		
		loginPage.clickReset();
		
		DriverFactory.killDriver();
		
	}
	
	
		
}
