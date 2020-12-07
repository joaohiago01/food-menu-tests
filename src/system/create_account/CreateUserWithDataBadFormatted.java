package system.create_account;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import system.WebDriverPath;

public class CreateUserWithDataBadFormatted {

	private WebDriver webDriver;

	@Before
	public void configuration() {
		System.setProperty("webdriver.edge.driver", WebDriverPath.webDriverPath);
		webDriver = new EdgeDriver();
	}

	@Test
	public void createUserWithDataBadFormatted() throws InterruptedException {
		webDriver.get("http://localhost:8080/food-menu-web/pages/user_register.jsp");
		assertTrue(webDriver.getTitle().contentEquals("Food Menu - Faça Parte"));

		WebElement inputName = webDriver.findElement(By.id("inputName"));
		inputName.sendKeys("João Hiago Santos Sousa");
		Thread.sleep(2000);

		WebElement inputEmail = webDriver.findElement(By.id("inputEmail"));
		inputEmail.sendKeys("joaogmail.com");
		Thread.sleep(2000);

		WebElement inputCpf = webDriver.findElement(By.id("inputCpf"));
		inputCpf.sendKeys("123.456.789-10");
		Thread.sleep(2000);

		WebElement inputPassword = webDriver.findElement(By.id("inputPassword"));
		inputPassword.sendKeys("12345678910");
		Thread.sleep(2000);

		WebElement buttonSubmit = webDriver.findElement(By.id("buttonSubmit"));
		buttonSubmit.click();
		Thread.sleep(2000);

		assertFalse(webDriver.getTitle().contentEquals("Food Menu - Cadastro Restaurante"));
		Thread.sleep(4000);
		webDriver.close();
	}
}
