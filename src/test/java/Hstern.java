import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.IOException;

public class Hstern {

    public static final String HSTERNURL = "https://www.hstern.co.il/";
    public static final String EMAILPOPUPXPATH = "//*[@id=\"newsletter-modal\"]/div/div/div[2]";
    public static final String EMAILPOPUPCLOSEXPATH = "/html/body/div[2]/div[4]/div/div/div[1]/button/span";
    public static final String NEWSLETTERSIGNUPXPATH =
            "//*[@id=\"primary\"]/div[14]/div/div/div/div[1]/div[2]/div/div/div/div/h3";
    public static final String EMAILFIELDID = "email";
    public static final String EMAIL = "sheker_kolshehoo@gmail.com";
    public static final String TERMSAGREECHECKBOXID = "terms_agree";
    public static final String SENDBTNXPATH =
            "//*[@id=\"primary\"]/div[14]/div/div/div/div[2]/div[2]/div/div/form/div[1]/button";
    public static final String ABOUTLINKXPATH = "//*[@id=\"menu-item-244\"]/a";
    public static final String PRISMASLINKXPATH = "//*[@id=\"page\"]/div/ul/ul/li/a";


    public static final String PRISMASURL = "https://www.hstern.co.il/product-category/collections/prismas/";
    public static final String PARAGRAPHXPATH = "//*[@id=\"main\"]/div[3]/header/div/div/div[1]/div/p";



    public static void elementsHTMLAssertAndParagraph() throws IOException {

        Driver.driver.get(HSTERNURL);
        if (Driver.driver.findElement(By.xpath(EMAILPOPUPXPATH)).isDisplayed()) {

            Driver.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EMAILPOPUPCLOSEXPATH))).click();

        }

        Driver.jse.executeScript(Driver.SCROLLDOWNTOBOTTM);
        Actions actions = new Actions(Driver.driver);
        actions.doubleClick(Driver.wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(NEWSLETTERSIGNUPXPATH)))).perform();
        Driver.wait.until(ExpectedConditions.presenceOfElementLocated(By.id(EMAILFIELDID))).sendKeys(EMAIL);
        Driver.wait.until(ExpectedConditions.presenceOfElementLocated(By.id(TERMSAGREECHECKBOXID))).click();
        Driver.wait.until(ExpectedConditions.presenceOfElementLocated(By.id(TERMSAGREECHECKBOXID))).click();
        Driver.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SENDBTNXPATH))).click();
        actions.contextClick(Driver.wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ABOUTLINKXPATH)))).perform();
        Driver.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PRISMASLINKXPATH))).click();
        Assert.assertEquals(Driver.driver.getCurrentUrl(), PRISMASURL);

        Files.screenShot(Driver.driver, "PrismasParagraph");
        String paragraphText = Driver.wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(PARAGRAPHXPATH))).getText();
        Files.createFile("CopiedParagraphText", paragraphText);

    }

}
