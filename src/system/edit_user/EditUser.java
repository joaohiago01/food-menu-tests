package system.edit_user;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import system.WebDriverPath;

public class EditUser {

	private WebDriver webDriver;

	@Before
	public void configuration() {
		System.setProperty("webdriver.edge.driver", WebDriverPath.webDriverPath);
		webDriver = new EdgeDriver();
	}

	@Test
	public void editUser() throws InterruptedException {
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
		
		WebElement linkUserProfile = webDriver.findElement(By.id("linkUserProfile"));
		linkUserProfile.click();
		Thread.sleep(2000);
		
		assertTrue(webDriver.getTitle().contentEquals("Food Menu - Perfil"));

		WebElement inputName = webDriver.findElement(By.id("inputName"));
		inputName.clear();
		Thread.sleep(2000);
		inputName.sendKeys("Joao Hiago");
		Thread.sleep(2000);

		WebElement buttonSubmit = webDriver.findElement(By.id("buttonSubmit"));
		buttonSubmit.click();
		Thread.sleep(2000);

		assertTrue(webDriver.getTitle().contentEquals("Food Menu"));
		
		linkUserProfile = webDriver.findElement(By.id("linkUserProfile"));
		linkUserProfile.click();
		Thread.sleep(2000);
		
		assertTrue(webDriver.getTitle().contentEquals("Food Menu - Perfil"));
		Thread.sleep(2000);
		
		inputName = webDriver.findElement(By.id("inputName"));
	
		assertEquals("Joao Hiago", inputName.getAttribute("value"));
		
		Thread.sleep(4000);
		webDriver.close();
	}
}
