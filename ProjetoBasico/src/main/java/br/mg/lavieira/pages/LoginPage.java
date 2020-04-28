package br.mg.lavieira.pages;

import br.mg.lavieira.core.BasePage;
import br.mg.lavieira.core.DriverFactory;

public class LoginPage extends BasePage {
	
	public void loginScreen() {
		DriverFactory.getDriver().get("https://seubarriga.wcaquino.me");
	}
	public void setEmail(String email) {
		write("email", email);
	}
	public void setPassword(String password) {
		write("senha",password);
	}
	public void enter() {
		clickButtonbyText("Entrar");
		
	}
	public void login(String email, String password) {
		setEmail(email);
		setPassword(password);
		enter();
		
	}
	public void clickReset() {
		clickLink("reset");
	}

}
