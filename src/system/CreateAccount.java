package system;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateAccount {

	private WebDriver webDriver;
	
	@Before
	public void configuration() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Cliente\\Downloads\\College\\TT\\food-menu-tests\\drivers\\msedgedriver.exe");
		webDriver = new EdgeDriver();
	}
	
	@Test
	public void createClient() throws InterruptedException {
		webDriver.get("");
		assertTrue(webDriver.getTitle().contentEquals("Food Menu - Faça Parte"));
		
		WebElement inputName = webDriver.findElement(By.id("inputName"));
		inputName.sendKeys("João Hiago Santos Sousa");
		Thread.sleep(2000);
		
		WebElement inputEmail = webDriver.findElement(By.id("inputEmail"));
		inputEmail.sendKeys("joao@gmail.com");
		Thread.sleep(2000);
		
		WebElement inputCpf = webDriver.findElement(By.id("inputCpf"));
		inputCpf.sendKeys("123.456.789-10");
		Thread.sleep(2000);
		
		WebElement inputPassword = webDriver.findElement(By.id("inputPassword"));
		inputPassword.sendKeys("123456");
		Thread.sleep(2000);
		
		WebElement buttonSubmit = webDriver.findElement(By.className("btn btn-danger btn-lg btn-block font-weight-bold"));
		buttonSubmit.click();
		Thread.sleep(2000);
		
		assertTrue(webDriver.getTitle().contentEquals("Food Menu - Cadastro Restaurante"));
	}
}
