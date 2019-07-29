package tests;

import Base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class CalculationTest extends TestBase {

    @Test
    public void itShouldCalculateTotalIncome() {
        //1. vybrat fund, zadat sumu, roky, email
        selectFund("Death Star real estate");
        enterInvestment("1000");
        enterYears("10");
        enterEmail("test1@mail.com");
        //2. overit ze total income nie je prazdny
        //driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText());
        Assert.assertFalse(getTotalIncome().isEmpty());
        Assert.assertTrue(getTotalIncome().contains("kr"));
    }

    @Test
    public void itShouldCalculateInterestIncome() {
        //1. vybrat fund, zadat sumu, roky, email
        selectFund("Tom & Jerry corp");
        enterInvestment("2000");
        enterYears("20");
        enterEmail("test2@mail.com");
        //2. overit ze interest income nie je prazdny
        driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText();
        Assert.assertFalse(getTotalInterest().isEmpty());
        Assert.assertTrue(getTotalInterest().contains("kr"));
    }

    @Test
    public void itShouldCalculateRisk() {
        //1. vybrat fund, zadat sumu, roky, email
        selectFund("Batman's Cave Development");
        enterInvestment("3000");
        enterYears("30");
        enterEmail("test3@mail.com");
        //2. overit ze Risk nie je prazdny
        //driver.findElement(By.cssSelector("div.result > div:nth-child(3) > p")).getText());
        Assert.assertFalse(getRisk().isEmpty());
    }

    @Test
    public void itShouldCalculateTotalIncomeForEachFund(){
        String[] arrayOfFunds ={"Batman's Cave Development", "Tom & Jerry corp", "Death Star real estate"};
        for (String arrayOfFund : arrayOfFunds) {
            selectFund(arrayOfFund);
            enterInvestment("3000");
            enterYears("30");
            enterEmail("test3@mail.com");
            Assert.assertFalse(getTotalIncome().isEmpty());
            Assert.assertTrue(getTotalIncome().contains("kr"));
            Assert.assertFalse(getTotalInterest().isEmpty());
            Assert.assertTrue(getTotalInterest().contains("kr"));
            Assert.assertFalse(getRisk().isEmpty());
        }

    }

    private void selectFund(String fundToSelect){
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText(fundToSelect);
    }

    private void enterInvestment(String investmentToEnter){
        driver.findElement(By.id("oneTimeInvestmentInput")).clear();
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(investmentToEnter);
    }

    private void enterYears(String yearsToEnter){
        driver.findElement(By.id("yearsInput")).clear();
        driver.findElement(By.id("yearsInput")).sendKeys(yearsToEnter);
    }

    private void enterEmail(String emailToEnter){
        driver.findElement(By.id("emailInput")).clear();
        driver.findElement(By.id("emailInput")).sendKeys(emailToEnter);
    }

    private String getTotalIncome(){
        return driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText();
    }

    private String getTotalInterest(){
        return driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText();
    }

    private String getRisk(){
        return driver.findElement(By.cssSelector("div.result > div:nth-child(3) > p")).getText();
    }
}
