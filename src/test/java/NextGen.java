import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;

public class NextGen extends Action {

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


    public void goToNextGenFormURL() {
        driver.get(NEXTGENFORMURL);
    }

    public void selectCountryFromDropDown() {
        selectDropDownValueByID(COUNTRYDROPDOWNID, "Brazil");
    }

    public void screenshotSelectedCountryBrazil() throws IOException {
        screenShot(driver, "Brazil");
    }

    public void clickDateField() {
        clickByID(DATEFIELDID);
    }

    public void clickChosenDate() {
        clickByXPath(CHOSENDATEBTNXPATH);
    }

    public void printResultDate() {
        System.out.println("Chosen date is: " + resultFieldByID(DATEFIELDID).getAttribute("value"));
    }

    public void clickQAAutomationMenu() {
        clickByXPath(QAAUTOMATIONMENUXPATH);
    }

    public void clickPracticeAutomationSelection() {
        clickByID(PRACTICEAUTOMATIONSELECTIONID);
    }

    public void clickAlertSelection() {
        clickByID(ALERTSELECTIONID);
    }

    public void assertNextgenAlertURL() {
        assertion(NEXTGENALERTURL);
    }

    public void clickConfirmAlert() {
        clickByXPath(CONFIRMALERTBOXBTNXPATH);
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void printMessageResult(String resultID) {
        System.out.println(resultFieldByID(resultID).getText());
    }

    public void screenshotClickedOnCancelMessage() throws IOException {
        screenShot(driver, "You clicked on Cancel");
    }

    public void clickPromptAlert() {
        clickByXPath(PROMPTALERTBOXBTNXPATH);
    }

    public void sendKeysToAlert(String s) {
        driver.switchTo().alert().sendKeys(s);
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void screenshotThanksForLikingAutomationMessage() throws IOException {
        screenShot(driver, "Thanks for Liking Automation");
    }

}
