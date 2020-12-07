package system.edit_product;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import system.WebDriverPath;

public class EditProduct {

	private WebDriver webDriver;

	@Before
	public void configuration() {
		System.setProperty("webdriver.edge.driver", WebDriverPath.webDriverPath);
		webDriver = new EdgeDriver();
	}

	@Test
	public void editProduct() throws InterruptedException {
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
		
		WebElement navbarDropdownMenuLink = webDriver.findElement(By.id("navbarDropdownMenuLink"));
		navbarDropdownMenuLink.click();
		Thread.sleep(1000);
		
		WebElement linkProducts = webDriver.findElement(By.id("linkProducts"));
		linkProducts.click();
		Thread.sleep(1000);
		
		assertTrue(webDriver.getTitle().contentEquals("Food Menu - Produtos"));
		
		WebElement buttonEditProduct = webDriver.findElement(By.id("buttonEditProduct"));
		buttonEditProduct.click();
		Thread.sleep(1000);
		
		assertTrue(webDriver.getTitle().contentEquals("Food Menu - Editar Produto"));
		
		WebElement inputDescription = webDriver.findElement(By.id("inputDescription"));
		inputDescription.clear();
		inputDescription.sendKeys("8 Fatias");
		Thread.sleep(1000);
		
		Select inputCategory = new Select(webDriver.findElement(By.id("inputCategory")));
		inputCategory.selectByVisibleText("Pizzas");
		Thread.sleep(1000);
		
		WebElement buttonSubmit = webDriver.findElement(By.id("buttonSubmit"));
		buttonSubmit.click();
		Thread.sleep(1000);

		assertTrue(webDriver.getTitle().contentEquals("Food Menu - Produtos"));
		Thread.sleep(4000);
		webDriver.close();
	}
}
