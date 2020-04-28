package br.mg.lavieira.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.mg.lavieira.core.BaseTest;
import br.mg.lavieira.core.DriverFactory;
import br.mg.lavieira.pages.MenuPage;
import br.mg.lavieira.pages.SummaryPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestSummary extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private SummaryPage summary = new SummaryPage();
	
	@Test
	public void test1DeleteMovement() {
		menuPage.accesssMonthlySummary();
		
		summary.deleteMovement();
		
		Assert.assertEquals("Movimentação removida com sucesso!",summary.getMessegeSuccess());
	}
	@Test
	public void test2MonthlySummary() {
		menuPage.accesssMonthlySummary();
		
		Assert.assertEquals("Seu Barriga - Extrato", DriverFactory.getDriver().getTitle());
		
		summary.selectYear("2019");
		summary.find();
		
		List<WebElement> elements = DriverFactory.getDriver().findElements(By.xpath("//table[@id='tabelaExtrato']/tbody/tr"));
		Assert.assertEquals(0,elements.size());
		
	}

}
