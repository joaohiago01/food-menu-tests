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
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Cliente\\Downloads\\College\\TT\\food-menu-tests\\drivers\\msedgedriver.exe");
		webDriver = new EdgeDriver();
	}
	
	@Test
	public void AccessSystem() {
		webDriver.get("http://localhost:8080/food-menu-web/pages/main.jsp");
		assertFalse(webDriver.getTitle().contentEquals("Food Menu"));
		webDriver.close();
	}
}
