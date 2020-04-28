package br.mg.lavieira.pages;

import org.openqa.selenium.By;

import br.mg.lavieira.core.BasePage;

public class AccountsPage extends BasePage {
	
	public void setName(String name) {
		write("nome", name);
	}
	public void save () {
		clickButtonbyText("Salvar");
	}
	public String getMessegeSuccess() {
		return obterText(By.xpath("//div[@class ='alert alert-success']"));
	}
	public String getMessegeError() {
		return obterText(By.xpath("//div[@class ='alert alert-danger']"));
	}
	
	public void clickEditAccount(String string) {
		getCellTable("Conta", string, "Ações", "tabelaContas")
		.findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
		}
	public void clickDeleteAccount(String string) {
		getCellTable("Conta", string, "Ações", "tabelaContas")
		.findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
		
	}


}
