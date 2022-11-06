import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class Wiki extends Files {

    public static final String WIKIHAPPYBDAYURL = "https://en.wikipedia.org/wiki/Happy_Birthday_to_You";
    public static final String LYRICSTITLEID = "Lyrics";
    public static final String SONGPARAGRAPHXPATH = "//*[@id=\"mw-content-text\"]/div[1]/blockquote/div/p";


    void copyWikiParagraph() throws IOException {

        driver.get(WIKIHAPPYBDAYURL);
        jse.executeScript(SCROLLTOELEMENT, wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id(LYRICSTITLEID))));
        screenShot(driver, "WikiHappyBDaySong");
        String wikiParagraphText = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SONGPARAGRAPHXPATH))).getText();
        createFile("WikiHappyBDay", wikiParagraphText);

    }

}
