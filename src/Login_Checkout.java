import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Checkout {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("secret_sauce");
		driver.findElement(By.className("submit-button")).click();
		driver.findElement(By.xpath("//button[@data-test = 'add-to-cart-sauce-labs-backpack']")).click();
		Assert.assertEquals(driver.findElement(By.id("remove-sauce-labs-backpack")).getText(), "Remove");
		driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-fleece-jacket']")).click();
		Assert.assertEquals(driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).getText(), "Remove");
		driver.findElement(By.cssSelector("a.shopping_cart_link")).click();
		driver.findElement(By.className("checkout_button")).click();
		driver.findElement(By.name("firstName")).sendKeys("Michael");
		driver.findElement(By.id("last-name")).sendKeys("Keevs");
		driver.findElement(By.id("postal-code")).sendKeys("985741");
		driver.findElement(By.cssSelector("input[type='submit']")).click();		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.cssSelector("#finish")).click();
		

	}

}
