package system.edit_restaurant;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditRestaurantWithCategoryEspeciality {

	private WebDriver webDriver;

	@Before
	public void configuration() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Cliente\\Downloads\\College\\TT\\food-menu-tests\\drivers\\msedgedriver.exe");
		webDriver = new EdgeDriver();
	}

	@Test
	public void editRestaurantWithCategoryEspeciality() throws InterruptedException {
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
		
		Select inputEspecialitySelect = new Select(webDriver.findElement(By.id("inputEspecialitySelect")));
		inputEspecialitySelect.selectByVisibleText("Pizzas");

		WebElement buttonSubmitRestaurantEdit = webDriver.findElement(By.id("buttonSubmitRestaurantEdit"));
		buttonSubmitRestaurantEdit.click();
		Thread.sleep(2000);

		WebElement linkMain = webDriver.findElement(By.id("linkMain"));
		linkMain.click();
		
		Thread.sleep(4000);
		webDriver.close();
	}
}
