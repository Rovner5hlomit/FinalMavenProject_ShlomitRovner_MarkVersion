import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class Wiki {

    public static final String WIKIHAPPYBDAYURL = "https://en.wikipedia.org/wiki/Happy_Birthday_to_You";
    public static final String LYRICSTITLEID = "Lyrics";
    public static final String SONGPARAGRAPHXPATH = "//*[@id=\"mw-content-text\"]/div[1]/blockquote/div/p";


    public static void copyWikiParagraph() throws IOException {

        Driver.driver.get(WIKIHAPPYBDAYURL);
        Driver.jse.executeScript(Driver.SCROLLTOELEMENT, Driver.wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id(LYRICSTITLEID))));
        Files.screenShot(Driver.driver, "WikiHappyBDaySong");
        String wikiParagraphText = Driver.wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SONGPARAGRAPHXPATH))).getText();
        Files.createFile("WikiHappyBDay", wikiParagraphText);

    }

}
