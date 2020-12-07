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

public class CreateRestaurantMissingSomeField {

	private WebDriver webDriver;

	@Before
	public void configuration() {
		System.setProperty("webdriver.edge.driver", WebDriverPath.webDriverPath);
		webDriver = new EdgeDriver();
	}

	@Test
	public void createRestaurantMissingSomeField() throws InterruptedException {
		webDriver.get("http://localhost:8080/food-menu-web/pages/restaurant_register.jsp");
		assertTrue(webDriver.getTitle().contentEquals("Food Menu - Cadastro Restaurante"));

		WebElement inputCnpj = webDriver.findElement(By.id("inputCnpj"));
		inputCnpj.sendKeys("12.345.678/0910-11");
		Thread.sleep(2000);

		WebElement inputNameRestaurant = webDriver.findElement(By.id("inputNameRestaurant"));
		inputNameRestaurant.sendKeys("Pizzaria Monteiro");
		Thread.sleep(2000);

		WebElement buttonSubmitRestaurantRegister = webDriver.findElement(By.id("buttonSubmit"));
		buttonSubmitRestaurantRegister.click();
		Thread.sleep(2000);

		assertFalse(webDriver.getTitle().contentEquals("Food Menu"));
		Thread.sleep(4000);
		webDriver.close();
	}
}
