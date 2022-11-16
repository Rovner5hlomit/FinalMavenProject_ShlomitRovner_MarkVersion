import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Action extends Driver{

    Actions actions = new Actions(driver);

    public void doubleClickByXPath(String xpath) {
        actions.doubleClick(wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)))).perform();
    }

    public void contextClickByXPath(String xpath) {
        actions.contextClick(wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)))).perform();
    }

    public void sendKeysByID(String id, String s) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id))).sendKeys(s);
    }

    public void clickByID(String id) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id))).click();
    }

    public void clickByXPath(String xpath) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
    }

    public String getTextByXPath(String xpath) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).getText();
    }

    public void assertion(String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    public void pageBack() {
        driver.navigate().back();
    }

    public void pageForward() {
        driver.navigate().forward();
    }

    public void pageRefresh() {
        driver.navigate().refresh();
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void minimizeWindow() {
        driver.manage().window().minimize();
    }

    public void windowFullscreen() {
        driver.manage().window().fullscreen();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public void openNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
    }

    public void openNewWindow() {
        driver.switchTo().newWindow(WindowType.WINDOW);
    }

    public void switchToWindow(String url) {
        driver.switchTo().window(url);
    }

    public void scrollDownToBottom() {
        jse.executeScript(SCROLLDOWNTOBOTTM);
    }

    public void scrollDownHalfPage() {
        jse.executeScript(SCROLLDOWNTOHALFPAGE);
    }

    public void scrollUpToTop() {
        jse.executeScript(SCROLLUPTOTOP);
    }

    public void scrollUpHalfPage() {
        jse.executeScript(SCROLLUPTOHALFPAGE);
    }

    public void scrollToElementByXPath(String xpath) {
        jse.executeScript(SCROLLTOELEMENT,
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))));
    }

    public void scrollToElementByID(String id) {
        jse.executeScript(SCROLLTOELEMENT,
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id))));
    }

    public void selectDropDownValueByID(String elementID, String value) {
        Select dropDown = new Select(driver.findElement(By.id(elementID)));
        dropDown.selectByValue(value);
    }

    public void setWindowSize() {
        driver.manage().window().setSize(new Dimension(1500, 1500));
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void sendKeysToAlert(String s) {
        driver.switchTo().alert().sendKeys(s);
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public WebElement resultFieldByID(String resultID) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id(resultID)));
    }

    public String getParagraphText(String paragraphXPath) {
        return getTextByXPath(paragraphXPath);
    }

    public void copyParagraphTextToFile(String fileName, String paragraphText) {
        createFile(fileName, paragraphText);
    }

}
