package br.mg.lavieira.pages;

import br.mg.lavieira.core.BasePage;

public class HomePage extends BasePage {
	
	public String getBalance(String account) {
		return getCellTable("Conta", account, "Saldo", "tabelaSaldo").getText();
	}
	
}
