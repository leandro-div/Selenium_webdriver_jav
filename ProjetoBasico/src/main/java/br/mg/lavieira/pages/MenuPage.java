package br.mg.lavieira.pages;

import br.mg.lavieira.core.BasePage;

public class MenuPage extends BasePage {
	
	public void accessInsertAccountPage() {
		clickLink("Contas");
		clickLink("Adicionar");
	}
	public void accessListAccountPage() {
		clickLink("Contas");
		clickLink("Listar");
	}
	public void accesssCreatMovement() {
		clickLink("Criar Movimentação");
	}
	public void accesssMonthlySummary() {
		clickLink("Resumo Mensal");
	}
	public void accesssHomePage() {
		clickLink("Home");
	}
	

}
