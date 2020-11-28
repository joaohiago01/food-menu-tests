package system.remove_product;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class RemoveProduct {
	
	private WebDriver webDriver;

	@Before
	public void configuration() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Cliente\\Downloads\\College\\TT\\food-menu-tests\\drivers\\msedgedriver.exe");
		webDriver = new EdgeDriver();
	}

	@Test
	public void removeProduct() throws InterruptedException {
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

		WebElement buttonDelete = webDriver.findElement(By.id("buttonDelete"));
		buttonDelete.click();
		Thread.sleep(1000);
		
		WebElement buttonConfirmDelete = webDriver.findElement(By.id("buttonConfirmDelete"));
		buttonConfirmDelete.click();
		Thread.sleep(1000);

		assertTrue(webDriver.getTitle().contentEquals("Food Menu - Produtos"));
		Thread.sleep(4000);
		webDriver.close();
	}
}
