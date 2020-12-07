package system.create_account;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import system.WebDriverPath;

public class CreateAccount {

	private WebDriver webDriver;
	
	@Before
	public void configuration() {
		System.setProperty("webdriver.edge.driver", WebDriverPath.webDriverPath);
		webDriver = new EdgeDriver();
	}
	
	@Test
	public void createAccountInFoodMenu() throws InterruptedException {
		webDriver.get("http://localhost:8080/food-menu-web/pages/user_register.jsp");
		assertTrue(webDriver.getTitle().contentEquals("Food Menu - Faça Parte"));
		
		WebElement inputName = webDriver.findElement(By.id("inputName"));
		inputName.sendKeys("Hiago");
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
		
		WebElement buttonSubmit = webDriver.findElement(By.id("buttonSubmit"));
		buttonSubmit.click();
		Thread.sleep(2000);
		
		assertTrue(webDriver.getTitle().contentEquals("Food Menu - Cadastro Restaurante"));
				
		WebElement inputCnpj = webDriver.findElement(By.id("inputCnpj"));
		inputCnpj.sendKeys("12.345.678/0910-11");
		Thread.sleep(2000);
		
		WebElement inputNameRestaurant = webDriver.findElement(By.id("inputNameRestaurant"));
		inputNameRestaurant.sendKeys("Pizzaria Monteiro");
		Thread.sleep(2000);
		
		WebElement inputDescription = webDriver.findElement(By.id("inputDescription"));
		inputDescription.sendKeys("Melhor Pizzaria da Cidade");
		Thread.sleep(2000);
		
		WebElement inputPhone = webDriver.findElement(By.id("inputPhone"));
		inputPhone.sendKeys("83999887766");
		Thread.sleep(2000);
		
		WebElement inputCep = webDriver.findElement(By.id("inputCep"));
		inputCep.sendKeys("58500-500");
		Thread.sleep(2000);
		
		WebElement inputCity = webDriver.findElement(By.id("inputCity"));
		inputCity.sendKeys("Monteiro");
		Thread.sleep(2000);
		
		WebElement inputState = webDriver.findElement(By.id("inputState"));
		inputState.sendKeys("PB");
		Thread.sleep(2000);
		
		WebElement inputDistrict = webDriver.findElement(By.id("inputDistrict"));
		inputDistrict.sendKeys("Centro");
		Thread.sleep(2000);
		
		WebElement inputAdress = webDriver.findElement(By.id("inputAdress"));
		inputAdress.sendKeys("Rua Fulano De Tal");
		Thread.sleep(2000);
		
		WebElement inputNumber = webDriver.findElement(By.id("inputNumber"));
		inputNumber.sendKeys("123");
		Thread.sleep(2000);
		
		WebElement inputTimeBegin = webDriver.findElement(By.id("inputTimeBegin"));
		inputTimeBegin.sendKeys("18:00");
		Thread.sleep(2000);
		
		WebElement inputTimeEnd = webDriver.findElement(By.id("inputTimeEnd"));
		inputTimeEnd.sendKeys("23:00");
		Thread.sleep(2000);
		
		Actions action = new Actions(webDriver);
		
		WebElement friday = webDriver.findElement(By.id("friday"));
		action.moveToElement(friday).click().build().perform();
		Thread.sleep(2000);
		
		WebElement saturday = webDriver.findElement(By.id("saturday"));
		action.moveToElement(saturday).click().build().perform();
		Thread.sleep(2000);
		
		WebElement sunday = webDriver.findElement(By.id("sunday"));
		action.moveToElement(sunday).click().build().perform();
		Thread.sleep(2000);
		
		WebElement customRadioDeliveryYes = webDriver.findElement(By.id("customRadioDeliveryYes"));
		action.moveToElement(customRadioDeliveryYes).click().build().perform();
		Thread.sleep(2000);
		
		WebElement buttonSubmitRestaurantRegister = webDriver.findElement(By.id("buttonSubmit"));
		buttonSubmitRestaurantRegister.click();
		Thread.sleep(2000);
		
		assertTrue(webDriver.getTitle().contentEquals("Food Menu"));
		Thread.sleep(4000);
		webDriver.close();
	}
	
}
