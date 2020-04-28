package br.mg.lavieira.pages;

import static br.mg.lavieira.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.mg.lavieira.core.BasePage;

public class MovementPage extends BasePage {
	
	public void setDateMoviment(String date) {
		write("data_transacao", date);
	}
	public void setDatePayment(String date) {
		write("data_pagamento", date);
	}
	
	public void setDescription(String description) {
		write("descricao", description);
	}
	public void setInterested(String interested) {
		write("interessado", interested);
	}
	public void setValue(String value) {
		write("valor", value);
	}
	public void setAccout(String accout) {
		selectCombo("conta", accout);
	}
	public void setStatusPaid() {
		clickRadio("status_pago");
	}
	public void save() {
		clickButtonbyText("Salvar");
	}
	public String getMessegeSuccess() {
		return obterText(By.xpath("//div[@class ='alert alert-success']"));
	}
	public List<String> getErrors(){
		List<WebElement> errors = getDriver().findElements(By.xpath("//div[@class ='alert alert-danger']//li"));
		List<String> retorno = new ArrayList<String>();
		for(WebElement error:errors ) {
			retorno.add(error.getText());
		}
		return retorno;
	}
}
