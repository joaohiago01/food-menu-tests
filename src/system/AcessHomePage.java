package system;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AcessHomePage {

	private WebDriver webDriver;

	@Before
	public void configuration() {
		System.setProperty("webdriver.edge.driver", WebDriverPath.webDriverPath);
		webDriver = new EdgeDriver();
	}
	
	@Test
	public void AccessHomePage() throws InterruptedException {
		webDriver.get("http://localhost:8080/food-menu-web/pages/index.jsp");
		assertTrue(webDriver.getTitle().contentEquals("Food Menu - Home"));
		Thread.sleep(7000);
		webDriver.close();
	}
}
