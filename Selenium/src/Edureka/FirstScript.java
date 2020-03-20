package Edureka;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.*;
import java.util.concurrent.TimeUnit;


public class FirstScript {
public static void main(String[] args)
{
	
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sanathan Narayanan\\Desktop\\Selenium\\chromedriver.exe");
	
	ChromeOptions options = new ChromeOptions();
    options.addExtensions(new File("C:\\Users\\Sanathan Narayanan\\Desktop\\Selenium\\4.2_0.crx"));
    options.addArguments("--incognito");
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    
    /*
    Proxy proxy = new Proxy(); 
    proxy.setHttpProxy("103.47.153.13:80"); 
    proxy.setSslProxy("103.47.153.13:80");
    capabilities.setCapability(CapabilityType.PROXY, proxy);
    */
    
    
    ChromeDriver driver = new ChromeDriver(capabilities);
	String j;
	int i;
	//WebDriver driver = new ChromeDriver();
	
	driver.get("chrome://extensions/?id=nijecnmimhpeklpmjfeibapgmlaphanj");
	JavascriptExecutor js = (JavascriptExecutor) driver; 
	js.executeScript("document.querySelector('extensions-manager').shadowRoot.querySelector('#viewManager > extensions-detail-view.active').shadowRoot.querySelector('div#container.page-container > div.page-content > div#options-section extensions-toggle-row#allow-incognito').shadowRoot.querySelector('label#label input').click()");
	
	
	driver.navigate().to("https://academicscc.vit.ac.in/parent/parent_login.asp");
	for(i=1;i<=31;i++)
	{
	j=String.format("%02d",i); 
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	driver.findElement(By.cssSelector("body > table:nth-child(3) > tbody > tr > td > form > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(2) > input")).sendKeys("16BCE1314");
	driver.findElement(By.cssSelector("body > table:nth-child(3) > tbody > tr > td > form > table > tbody > tr > td > table > tbody > tr:nth-child(3) > td:nth-child(2) > input")).sendKeys(j+"042098");
	driver.findElement(By.cssSelector("body > table:nth-child(3) > tbody > tr > td > form > table > tbody > tr > td > table > tbody > tr:nth-child(6) > td > input:nth-child(1)")).click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	Alert alt = driver.switchTo().alert();
	alt.accept();
	}
	js.executeScript("window.alert('Completed Pass!')");
}
}
