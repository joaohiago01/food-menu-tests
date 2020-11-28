package system.edit_user;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class EditUserMissingSomeField {

	private WebDriver webDriver;

	@Before
	public void configuration() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Cliente\\Downloads\\College\\TT\\food-menu-tests\\drivers\\msedgedriver.exe");
		webDriver = new EdgeDriver();
	}

	@Test
	public void editUserMissingSomeField() throws InterruptedException {
		webDriver.get("http://localhost:8080/food-menu-web/pages/login.jsp");
		assertTrue(webDriver.getTitle().contentEquals("Food Menu - Login"));

		WebElement inputEmail = webDriver.findElement(By.id("inputEmail"));
		inputEmail.sendKeys("joao@gmail.com");
		Thread.sleep(1000);
		
		WebElement inputPassword = webDriver.findElement(By.id("inputPassword"));
		inputPassword.sendKeys("123456");
		Thread.sleep(1000);

		WebElement buttonLogin = webDriver.findElement(By.id("buttonLogin"));
		buttonLogin.click();
		Thread.sleep(1000);

		assertTrue(webDriver.getTitle().contentEquals("Food Menu"));
		
		WebElement linkUserProfile = webDriver.findElement(By.id("linkUserProfile"));
		linkUserProfile.click();
		Thread.sleep(1000);
		
		assertTrue(webDriver.getTitle().contentEquals("Food Menu - Perfil"));

		WebElement inputCpf = webDriver.findElement(By.id("inputCpf"));
		inputCpf.clear();
		Thread.sleep(1000);

		WebElement buttonSubmit = webDriver.findElement(By.id("buttonSubmit"));
		buttonSubmit.click();
		Thread.sleep(1000);

		assertFalse(webDriver.getTitle().contentEquals("Food Menu"));
		Thread.sleep(4000);
		webDriver.close();
	}
}
