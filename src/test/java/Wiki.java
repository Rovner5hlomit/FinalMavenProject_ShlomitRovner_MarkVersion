import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class Wiki extends Action {

    public static final String WIKIHAPPYBDAYURL = "https://en.wikipedia.org/wiki/Happy_Birthday_to_You";
    public static final String LYRICSTITLEID = "Lyrics";
    public static final String SONGPARAGRAPHXPATH = "//*[@id=\"mw-content-text\"]/div[1]/blockquote/div/p";


    void goToWikipediaBDayURL() {
        driver.get(WIKIHAPPYBDAYURL);
    }

    public void scrollToLyricsTitle() {
        scrollToElementByID(LYRICSTITLEID);
    }

    public void screenshotHappyBDay() throws IOException {
        screenShot(driver, "WikiHappyBDaySong");
    }

    public String getSongParagraphText() {
        return getParagraphText(SONGPARAGRAPHXPATH);
    }

    public void copySongParagraphTextToFile() {
        copyParagraphTextToFile("WikiHappyBDay", getSongParagraphText());
    }

}
