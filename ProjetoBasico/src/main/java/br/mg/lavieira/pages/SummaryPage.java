package br.mg.lavieira.pages;

import org.openqa.selenium.By;

import br.mg.lavieira.core.BasePage;


public class SummaryPage extends BasePage {
	
	public void deleteMovement() {
		clickButton(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
	}
	
	public String getMessegeSuccess() {
		return obterText(By.xpath("//div[@class ='alert alert-success']"));
	}
	
	public void selectYear(String year) {
		selectCombo("ano", year);
	}
	public void find() {
		clickButton(By.xpath("//input[@value='Buscar']"));
	}

}
