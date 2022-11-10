import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Action extends Driver{

    Actions actions = new Actions(driver);

    void doubleClickByXPath(String xpath) {
        actions.doubleClick(wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)))).perform();
    }

    void contextClickByXPath(String xpath) {
        actions.contextClick(wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)))).perform();
    }

    void sendKeysByID(String id, String s) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id))).sendKeys(s);
    }

    void clickByID(String id) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id))).click();
    }

    void clickByXPath(String xpath) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
    }

    String getTextByXPath(String xpath) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).getText();
    }

    void assertion(String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

}
