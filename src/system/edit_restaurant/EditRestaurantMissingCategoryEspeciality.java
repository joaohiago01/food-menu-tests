package system.edit_restaurant;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import system.WebDriverPath;

public class EditRestaurantMissingCategoryEspeciality {

	private WebDriver webDriver;

	@Before
	public void configuration() {
		System.setProperty("webdriver.edge.driver", WebDriverPath.webDriverPath);
		webDriver = new EdgeDriver();
	}

	@Test
	public void editRestaurantMissingCategoryEspeciality() throws InterruptedException {
		webDriver.get("http://localhost:8080/food-menu-web/pages/login.jsp");
		assertTrue(webDriver.getTitle().contentEquals("Food Menu - Login"));

		WebElement inputEmail = webDriver.findElement(By.id("inputEmail"));
		inputEmail.sendKeys("joao@gmail.com");
		Thread.sleep(2000);
		
		WebElement inputPassword = webDriver.findElement(By.id("inputPassword"));
		inputPassword.sendKeys("123456");
		Thread.sleep(2000);

		WebElement buttonLogin = webDriver.findElement(By.id("buttonLogin"));
		buttonLogin.click();
		Thread.sleep(2000);

		assertTrue(webDriver.getTitle().contentEquals("Food Menu"));
		
		WebElement linkRestaurantEdit = webDriver.findElement(By.id("linkRestaurantEdit"));
		linkRestaurantEdit.click();
		Thread.sleep(2000);
		
		assertTrue(webDriver.getTitle().contentEquals("Food Menu - Editar Restaurante"));
		
		//Not work because Selenium using exception of select non multiple
		/*Select inputEspecialitySelect = new Select(webDriver.findElement(By.id("inputEspecialitySelect")));
		inputEspecialitySelect.deselectAll();*/
		
		WebElement buttonSubmitRestaurantEdit = webDriver.findElement(By.id("buttonSubmitRestaurantEdit"));
		buttonSubmitRestaurantEdit.click();
		Thread.sleep(2000);

		assertFalse(webDriver.getTitle().contentEquals("Food Menu"));
		Thread.sleep(4000);
		webDriver.close();
	}
}
