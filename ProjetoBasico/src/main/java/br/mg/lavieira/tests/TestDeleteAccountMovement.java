package br.mg.lavieira.tests;

import org.junit.Assert;
import org.junit.Test;

import br.mg.lavieira.core.BaseTest;
import br.mg.lavieira.pages.AccountsPage;
import br.mg.lavieira.pages.MenuPage;

public class TestDeleteAccountMovement extends BaseTest {

	MenuPage menuPage = new MenuPage();
	AccountsPage accountsPage = new AccountsPage();
	
	
	@Test
	public void testDeleteAccountWithMovement() {
		menuPage.accessListAccountPage();
		
		accountsPage.clickDeleteAccount("Conta com movimentacao");
		
		Assert.assertEquals("Conta em uso na movimentações", accountsPage.getMessegeError());


	}
}
