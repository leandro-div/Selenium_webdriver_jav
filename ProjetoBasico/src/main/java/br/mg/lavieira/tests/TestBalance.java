package br.mg.lavieira.tests;

import org.junit.Assert;
import org.junit.Test;

import br.mg.lavieira.core.BaseTest;
import br.mg.lavieira.pages.HomePage;
import br.mg.lavieira.pages.MenuPage;


public class TestBalance extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private HomePage homePage = new HomePage(); 
	@Test
	public void testBalanceAccount() {
		menuPage.accesssHomePage();
		
		Assert.assertEquals("534.00", homePage.getBalance("Conta para saldo"));
		
	}
	

}
