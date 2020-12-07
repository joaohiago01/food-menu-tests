package system;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AccessSystemWithoutLogin {

	private WebDriver webDriver;

	@Before
	public void configuration() {
		System.setProperty("webdriver.edge.driver", WebDriverPath.webDriverPath);
		webDriver = new EdgeDriver();
	}
	
	@Test
	public void AccessSystem() throws InterruptedException {
		webDriver.get("http://localhost:8080/food-menu-web/pages/main.jsp");
		assertFalse(webDriver.getTitle().contentEquals("Food Menu"));
		Thread.sleep(4000);
		webDriver.close();
	}
}
