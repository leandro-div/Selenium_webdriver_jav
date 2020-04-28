package br.mg.lavieira.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.mg.lavieira.core.Properties.ExecutionTypes;

public class DriverFactory {

	//private static WebDriver driver;
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
		@Override
		protected synchronized WebDriver initialValue() {
			return initDriver();
		}
	};
	private DriverFactory() {}
	public static WebDriver getDriver() {
		return threadDriver.get();
	}
	public static WebDriver initDriver() {
		WebDriver driver = null;
		
		if(Properties.EXECUTION_TYPE == ExecutionTypes.LOCAL) {
			switch (Properties.BROWSER) {
				case CHROME: driver = new ChromeDriver(); break;
				case FIREFOX: driver = new FirefoxDriver(); break;
				case INTERNETEXPLORER: driver = new InternetExplorerDriver(); break;
				}
		}
		
		if(Properties.EXECUTION_TYPE == ExecutionTypes.GRID) {
			DesiredCapabilities cap = null;
			switch (Properties.BROWSER) {
			case CHROME: cap = DesiredCapabilities.chrome(); break;
			case FIREFOX: cap = DesiredCapabilities.firefox(); break;
			case INTERNETEXPLORER: cap = DesiredCapabilities.internetExplorer(); break;
			}
			try {
				driver = new RemoteWebDriver(new URL("http://192.168.1.10:4444/wd/hub"), cap);
			} catch (MalformedURLException e) {
				System.err.println("Falha ao conectar no GRID!!");
				e.printStackTrace();
			}
		}
		driver.manage().window().setSize(new Dimension(800,730));
		return driver;
	}
	public static void killDriver() {
		WebDriver driver = getDriver();
		if (driver!= null) {
			driver.quit();
			driver = null;
		}
		if (threadDriver != null) {
			threadDriver.remove();
		}
			
	}
	
	
}
