import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Flight_Search {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.findElement(By.className("commonModal__close")).click();
		driver.findElement(By.xpath("//span[text()='From']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[contains(text(),'New Delhi, India')]")).click();
		driver.findElement(By.xpath("//label[@for='toCity']")).click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement toCity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Mumbai, India')]")));
	    toCity.click();
		driver.findElement(By.cssSelector("div[aria-label='Wed Jul 16 2025']")).click();
		driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();	
	}

}
