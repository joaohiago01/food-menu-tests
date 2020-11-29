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
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Cliente\\Downloads\\College\\TT\\food-menu-tests\\drivers\\msedgedriver.exe");
		webDriver = new EdgeDriver();
	}
	
	@Test
	public void AccessSystem() throws InterruptedException {
		webDriver.get("http://localhost:8080/food-menu-web/pages/index.jsp");
		assertTrue(webDriver.getTitle().contentEquals("Food Menu - Home"));
		Thread.sleep(7000);
		webDriver.close();
	}
}
