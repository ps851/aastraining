package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pages.CalculatorPage;

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
        CalculatorPage calculatorPage = new CalculatorPage(driver);

        //1. vybrat fond
        calculatorPage.selectFund("Death Star real estate");
        //2.zadat sumu
        calculatorPage.enterInvestment("5000");
        //3.zadat pocet rokov
        calculatorPage.enterYears("10");
        //4.zadat email
        calculatorPage.enterEmail("test@mail.com");
        //5.overit button
        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());
    }

    @Test
    public void itShouldNotSelectAnyFundOnPageOpen(){
        String option = new Select(driver.findElement(By.id("fundSelect"))).getFirstSelectedOption().getText();
        System.out.println(option);
        Assert.assertEquals("Select your fund", option);
    }
}
