package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import sun.font.TrueTypeFont;

public class SavingsCalculatorTest {

    WebDriver driver; //definovanie drivera pre cely kod

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost/savingscalculator.php");
    }

    @Test
    public void itShouldDisplayTitle() {
        //driver.findElement(By.cssSelector("h1")).getText();
        Assert.assertEquals("Savings Calculator", driver.findElement(By.cssSelector("h1")).getText());
    }

    @Test
    public void isShouldDisableApplyButtonOnPageOpen(){
        //driver.findElement(By.cssSelector("button.btn-block")).isEnabled();
        Assert.assertFalse(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());
    }

    @Test
    public void itShouldEnableApplyButton(){
        //1. vybrat fond
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText("Batman's Cave Development");
        //2.zadat sumu
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("1000");
        //3.zadat pocet rokov
        driver.findElement(By.id("yearsInput")).sendKeys("25");
        //4.zadat email
        driver.findElement(By.id("emailInput")).sendKeys("test@mail.com");
        //5.overit button
        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());
    }

    @Test
    public void itShouldNotSelectAnyFundOnPageOpen(){
        String option = new Select(driver.findElement(By.id("fundSelect"))).getFirstSelectedOption().getText();
        System.out.println(option);
        Assert.assertEquals("Select your fund", option);
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
