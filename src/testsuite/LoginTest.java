package testsuite;
/**
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userShouldNavigateToLoginPageSuccessfully *  click on the ‘Sign In’ link
 * * Verify the text ‘Welcome Back!’
 * 2. verifyTheErrorMessage
 * * click on the ‘Sign In’ link
 * * Enter invalid username
 * * Enter invalid password
 * * Click on Login button
 * * Verify the error message ‘Invalid email  or password.’
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //click on the Sign In link
        driver.findElement(By.xpath("//a[@href='/users/sign_in']")).click();
       //verify the text Welcome Back!
        String expectedDisplay = "Welcome Back!";
        String actualDisplay = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals(expectedDisplay, actualDisplay);
    }

    @Test
    public void verifyTheErrorMessage(){
        //click on the Sign In link
        driver.findElement(By.linkText("Sign In")).click();
        //enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("monday@gmail.com");
        //enter invalid password
        driver.findElement(By.id("user[password]")).sendKeys("monday");
        //click on Sign in button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //verify the error message Invalid email or password
        String expectedErrorMessage = "Invalid email or password.";
        String actualErrorMessage = driver.findElement(By.xpath("//li[contains(@class,'form-error__list-item')]")).getText();
       // String actualErrorMessage = driver.findElement(By.xpath("//div[@id='notice']")).getText();
        Assert.assertEquals("Fail to click on login button",expectedErrorMessage, actualErrorMessage);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }


}
