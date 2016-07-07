import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Extract_Text {

	static WebDriver driver;
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.setBinary("/usr/bin/google-chrome");
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("http://www.google.co.in");
		List<WebElement> txtfields = driver.findElements(By.xpath("//input[@type='text' or @type='password']"));
		  
		  //for loop to send text In all text box one by one.
		  for(int a=0; a<txtfields.size();a++){   
			  System.out.println(txtfields.get(a).getText());
		  }
	}

}
