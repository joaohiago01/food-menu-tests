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

public class CreateUserMissingSomeField {

	private WebDriver webDriver;

	@Before
	public void configuration() {
		System.setProperty("webdriver.edge.driver", WebDriverPath.webDriverPath);
		webDriver = new EdgeDriver();
	}

	@Test
	public void createUserMissingSomeField() throws InterruptedException {
		webDriver.get("http://localhost:8080/food-menu-web/pages/user_register.jsp");
		assertTrue(webDriver.getTitle().contentEquals("Food Menu - Fa�a Parte"));

		WebElement inputName = webDriver.findElement(By.id("inputName"));
		inputName.sendKeys("Jo�o Hiago Santos Sousa");
		Thread.sleep(2000);

		WebElement inputEmail = webDriver.findElement(By.id("inputEmail"));
		inputEmail.sendKeys("joao@gmail.com");
		Thread.sleep(2000);

		WebElement inputPassword = webDriver.findElement(By.id("inputPassword"));
		inputPassword.sendKeys("123456789");
		Thread.sleep(2000);

		WebElement buttonSubmit = webDriver.findElement(By.id("buttonSubmit"));
		buttonSubmit.click();
		Thread.sleep(2000);

		assertFalse(webDriver.getTitle().contentEquals("Food Menu - Cadastro Restaurante"));
		Thread.sleep(4000);
		webDriver.close();
	}
}
