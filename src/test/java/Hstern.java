import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.IOException;

public class Hstern extends Action {

    public static final String HSTERNURL = "https://www.hstern.co.il/";
    public static final String NEWSLETTERSIGNUPXPATH =
            "//*[@id=\"primary\"]/div[14]/div/div/div/div[1]/div[2]/div/div/div/div/h3";
    public static final String EMAILFIELDID = "email";
    public static final String EMAIL = "sheker_kolshehoo@gmail.com";
    public static final String TERMSAGREECHECKBOXID = "terms_agree";
    public static final String ABOUTLINKXPATH = "//*[@id=\"menu-item-244\"]/a";
    public static final String PRISMASLINKXPATH = "//*[@id=\"page\"]/div/ul/ul/li/a";


    public static final String PRISMASURL = "https://www.hstern.co.il/";
    public static final String PARAGRAPHXPATH = "//*[@id=\"main\"]/div[3]/header/div/div/div[1]/div/p";



    void elementsHTMLActions()  {

        driver.get(HSTERNURL);

        jse.executeScript(SCROLLDOWNTOBOTTM);
        doubleClickByXPath(NEWSLETTERSIGNUPXPATH);
        sendKeysByID(EMAILFIELDID, EMAIL);
        clickByID(TERMSAGREECHECKBOXID);
        clickByID(TERMSAGREECHECKBOXID);
        contextClickByXPath(ABOUTLINKXPATH);

    }

        void elementsHTMLAssertAndParagraph() throws IOException {

            driver.get(HSTERNURL);
            clickByXPath(PRISMASLINKXPATH);
            assertion(PRISMASURL);

            screenShot(driver, "PrismasParagraph");
            String paragraphText = getTextByXPath(PARAGRAPHXPATH);
            createFile("CopiedParagraphText", paragraphText);

    }

}
