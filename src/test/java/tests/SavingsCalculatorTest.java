package tests;

import Base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class SavingsCalculatorTest extends TestBase {
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
        selectFund("Death Star real estate");
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

    private void selectFund(String fundToSelect){
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText(fundToSelect);
    }
}
