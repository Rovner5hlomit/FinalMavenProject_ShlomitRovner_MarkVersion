import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;

public class NextGen extends Files {

    public static final String NEXTGENFORMURL = "https://nxtgenaiacademy.com/demo-site/";
    public static final String COUNTRYDROPDOWNID = "vfb-13-country";
    public static final String DATEFIELDID = "vfb-18";
    public static final String CHOSENDATEBTNXPATH = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[7]/a";
    public static final String QAAUTOMATIONMENUXPATH = "//*[@id=\"menu-item-4131\"]/a/span";
    public static final String PRACTICEAUTOMATIONSELECTIONID = "menu-item-4157";
    public static final String ALERTSELECTIONID = "menu-item-4132";

    public static final String NEXTGENALERTURL = "https://nxtgenaiacademy.com/alertandpopup/";
    public static final String CONFIRMALERTBOXBTNXPATH =
            "//*[@id=\"content\"]/article/div/div/section[3]/div/div[2]/div/div/div/center/button";
    public static final String RESULTFIELDONEID = "demo";
        public static final String PROMPTALERTBOXBTNXPATH =
            "//*[@id=\"content\"]/article/div/div/section[3]/div/div[3]/div/div/div/center/button";
    public static final String RESULTFIELDTWOID = "demoone";


    void dropDownAndAlert() throws IOException {

        driver.get(NEXTGENFORMURL);
        Select dropDown = new Select(driver.findElement(By.id(COUNTRYDROPDOWNID)));
        dropDown.selectByValue("Brazil");
        screenShot(driver, "Brazil");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(DATEFIELDID))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CHOSENDATEBTNXPATH))).click();
        WebElement resultDate = wait
                        .until(ExpectedConditions.presenceOfElementLocated(By.id(DATEFIELDID)));
        System.out.println("Chosen date is: " + resultDate.getAttribute("value"));

        driver.manage().window().setSize(new Dimension(1500, 1500));
        jse.executeScript(SCROLLUPTOTOP);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(QAAUTOMATIONMENUXPATH))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(PRACTICEAUTOMATIONSELECTIONID))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(ALERTSELECTIONID))).click();
        Assert.assertEquals(driver.getCurrentUrl(), NEXTGENALERTURL);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CONFIRMALERTBOXBTNXPATH))).click();
        driver.switchTo().alert().dismiss();
        WebElement resultFieldOne = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id(RESULTFIELDONEID)));
        System.out.println(resultFieldOne.getText());
        screenShot(driver, "You clicked on Cancel");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PROMPTALERTBOXBTNXPATH))).click();
        driver.switchTo().alert().sendKeys("yes");
        driver.switchTo().alert().accept();
        WebElement resultFieldTwo = wait
                        .until(ExpectedConditions.presenceOfElementLocated(By.id(RESULTFIELDTWOID)));
        System.out.println(resultFieldTwo.getText());
        screenShot(driver, "Thanks for Liking Automation");

    }

}
