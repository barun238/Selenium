package tutorials;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestingMyApplication {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "E:\\SoftwareTesting\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
				
		WebElement login = driver.findElement(By.id("nav-link-accountList"));
		login.click();
		
		WebElement email =driver.findElement(By.id("ap_email"));
		email.sendKeys("bkumararun1991@gmail.com");
		
		WebElement continueButton = driver.findElement(By.id("continue"));
		continueButton.click();
		
		WebElement password = driver.findElement(By.id("ap_password"));
		password.sendKeys("Arun123456");
		
		WebElement loginButton1 = driver.findElement(By.id("signInSubmit"));
		loginButton1.click();
		
		WebElement confirmation = driver.findElement(By.xpath("//span[contains(text(),'Hello, Arunkumar')]"));
		System.out.println("You signed in ");
		
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("Iphone 11");
		
		String oldWindowHandle = driver.getWindowHandle();
		
		WebElement searchButton = driver.findElement(By.xpath("//*[@id=\'nav-search-submit-text\']/input"));
		searchButton.click();
		
		WebElement selectMobile = driver.findElement(By.linkText("New Apple iPhone 11 (64GB) - Black"));
		selectMobile.click();
		
		Set<String> handles = driver.getWindowHandles();
		
		for (String newWindow : handles) {
			driver.switchTo().window(newWindow);
			
		}
		
		WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\'add-to-cart-button\']"));
		addToCartButton.click();
		
		driver.close();
		
		driver.switchTo().window(oldWindowHandle);
		
		
		WebElement cartIcon = driver.findElement(By.id("nav-cart"));
		cartIcon.click();
		
		Thread.sleep(2000);
		
		
		WebElement deletingItem = driver.findElement(By.xpath("//input[@value='Delete']"));
		deletingItem.click();
		
		Thread.sleep(2000);
		
		WebElement optionsIcon = driver.findElement(By.id("nav-hamburger-menu"));
		optionsIcon.click();
		
		Thread.sleep(2000);
		
		WebElement signOut = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/ul[1]/li[29]/a"));
		signOut.click();
		
		WebElement signedOutConfirmation = driver.findElement(By.xpath("//h1[contains(text(),'Login')]"));
		System.out.println("You Signed Out");
		
		driver.close();
		
	}

}
