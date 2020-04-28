package br.mg.lavieira.tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.mg.lavieira.core.BaseTest;
import br.mg.lavieira.pages.AccountsPage;
import br.mg.lavieira.pages.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestAccounts extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	AccountsPage accountsPage = new AccountsPage();
	
	@Test
	public void test1InsetAcount() {
		menuPage.accessInsertAccountPage();
			
		accountsPage.setName("Conta de Teste");
		accountsPage.save();
		
		Assert.assertEquals("Conta adicionada com sucesso!", accountsPage.getMessegeSuccess());
		
	}
	@Test
	public void test2EditAcount() {
		menuPage.accessListAccountPage();
		
		accountsPage.clickEditAccount("Conta para alterar");
		
		accountsPage.setName("Conta alterada");
		accountsPage.save();
		
		Assert.assertEquals("Conta alterada com sucesso!", accountsPage.getMessegeSuccess());
	}
	@Test
	public void test3DuplicatedAccount() {
		menuPage.accessInsertAccountPage();
		
		accountsPage.setName("Conta mesmo nome");
		accountsPage.save();
		
		Assert.assertEquals("Já existe uma conta com esse nome!", accountsPage.getMessegeError());

	}

	

}
