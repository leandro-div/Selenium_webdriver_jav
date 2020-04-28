package br.mg.lavieira.core;

import static br.mg.lavieira.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	public void write(By by , String text) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(text);
	}
	public void write(String id_campo , String text){
		write(By.id(id_campo),text);
	}
	
	public String resultCampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
		
	}
	
	public void clickRadio(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clickRadio(String id) {
		clickRadio(By.id(id));
	}
	
	
	public boolean checkButoon(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	public void selectCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		//combo.selectByIndex(3);
		//combo.selectByValue("2grauincomp");
		combo.selectByVisibleText(valor);
	}
	public void deselectCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}
		
	public String comboCheck(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	public List<String> comboMultCheck(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> AllSelectedOptions = combo.getAllSelectedOptions();
		List<String> values = new ArrayList<String>();
		for(WebElement option:AllSelectedOptions) {
			values.add(option.getText());
		}
		return values;
	}
	
	public int comboQuantity(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
			return options.size();
	}
	
	public boolean comboCheckSeContem(String id, String value) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for(WebElement option: options){
			if(option.getText().equals(value)) {
				return true;
			}
		}
		return false;
	}
	
	public void selectComboPrime(String radical, String value) {
		clickRadio(By.xpath("//*[@id='"+radical+":console_input']/../..//span"));
		clickRadio(By.xpath("//*[@id='"+radical+":console_items']/li[.='"+value+"']"));
	}
	/********************Button**************************/
	
	public void clickButton (By by) {
		 getDriver().findElement(by).click();
	}
	public void clickButton (String id) {
		 clickButton(By.id(id));
	}
	public void clickButtonbyText (String text) {
		clickButton(By.xpath("//button[.='"+text+"']"));
	}
	
	
	/********************Link**************************/
	
	public void clickLink (String link) {
		getDriver().findElement(By.linkText(link)).click();
	}
	
	public String obterText (By by) {
		return getDriver().findElement(by).getText();
	}
	public String obterText (String id) {
		return obterText(By.id(id));
	}
	public String alertaText() {
	
		Alert alert = getDriver().switchTo().alert();
		return alert.getText();
		}
	
	public String alertaTextAccept() {
		
		Alert alert = getDriver().switchTo().alert();
		String stringText = alert.getText();
		alert.accept();
		return stringText;
		}
	
	public String alertaTextDimiss() {
		
		Alert alert = getDriver().switchTo().alert();
		String stringText = alert.getText();
		alert.accept();
		return stringText;
		}
	
	public void alertaWrite(String value) {
		Alert alert = getDriver().switchTo().alert();
		alert.sendKeys(value);
		alert.accept();
	}	
	public void frameIn(String id) {
		getDriver().switchTo().frame(id);		

	}
	public void frameOut() {
		getDriver().switchTo().defaultContent();		

	}
	public void winSwap (String id) {
		getDriver().switchTo().window(id);
	}
	
	/********************JS***************/

	public Object executarJS(String cmd, Object... param) {
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(cmd,param);
	}
	
	/********************Table***************/
	
	public WebElement getCellTable(String columnFind, String value, String columnButton, String idTable ) {
		//procurar coluna
		WebElement table = getDriver().findElement(By.xpath("//*[@id='"+idTable+"']"));
		int idColumn = getColumnIndex(columnFind, table);
		
		//encontra linha
		int idRow = getRowIdex(value, table, idColumn);
		
		//procurar coluna botao 
		int idColumnButton = getColumnIndex(columnButton, table);
		
		//clicar botao 
		WebElement cell = table.findElement(By.xpath(".//tr["+idRow+"]/td["+idColumnButton+"]"));
		return cell;
	}

	
	public void clickButtonTable(String columnFind, String value, String columnButton, String idTable ) {
	
		WebElement cell = getCellTable(columnFind, value, columnButton, idTable);
		cell.findElement(By.xpath(".//input")).click();
	}

	private int getRowIdex(String value, WebElement table, int idColumn) {
		List<WebElement> rows = table.findElements(By.xpath("./tbody/tr/td["+idColumn+"]"));
		int idRow = -1;
		for(int i = 0 ; i < rows.size() ; i++) {
			if (rows.get(i).getText().equals(value)) {
				idRow = i+1;
				break;
				}
		}
		return idRow;
	}

	private int getColumnIndex(String column, WebElement table) {
		List<WebElement> columns = table.findElements(By.xpath(".//th"));
		int idColumn = -1;
		for(int i = 0 ; i < columns.size() ; i++) {
			if (columns.get(i).getText().equals(column)) {
				idColumn = i+1;
				break;
				}
		}
		return idColumn;
	}
}
