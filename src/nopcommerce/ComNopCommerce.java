package nopcommerce;


/**
 * 1. Setup Chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Navigate to Url.
 * “https://demo.nopcommerce.com/login?returnUrl=%2F”
 * 7. Print the current url.
 * 8. Navigate back to the home page.
 * 9. Navigate to the login page.
 * 10. Print the current url.
 * 11. Refresh the page.
 * 12. Enter the email to email field.
 * 13. Enter the password to password field.
 * 14. Click on Login Button.
 * 15. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ComNopCommerce  {
    static String browser = "Chrome"; //set up Chrome browser

    static WebDriver driver; // declaring globally

    public static void main(String[] args) throws InterruptedException{
        if (browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        }else {
            System.out.println("Wrong Browser name");
        }
        String baseUrl = "https://demo.nopcommerce.com/"; //set base url
        driver.get(baseUrl); // get base Url
        driver.manage().window().maximize();//maximise the window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait to driver
        System.out.println(driver.getTitle());//Print Title of the page
        System.out.println(driver.getCurrentUrl());// Print current url
        System.out.println(driver.getPageSource());// Print the page source
        String loginURL = "https://demo.nopcommerce.com/login?returnUrl=%2F"; // new url
        driver.navigate().to(loginURL);//navigate to URL
        driver.navigate().back();// go back to homepage
        driver.navigate().forward();// go forward to homepage
        System.out.println(driver.getCurrentUrl());//print currrent Url
        driver.navigate().refresh();// refresh url

        WebElement emailField = driver.findElement(By.id("Email")); //Enter email to emal field
        emailField.sendKeys("hiral@gmail.com");
        //Enter the password to password field
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Password123");
        //Click on login button
      WebElement logibutton = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button"));
    logibutton.click();
    //Close Browwser
        driver.quit();
    }
}
