import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class KilooGames extends Action {

    public static final String THINKINGGAMESURL = "https://www.kiloo.com/en/thinking-games/";
    public static final String ALLGAMESBTNXPATH = "//*[@id=\"games\"]/a/img";

    public static final String ALLGAMESURL = "https://www.kiloo.com/en/games/";

    public static final String ALLCATEGORIESURL = "https://www.kiloo.com/en/categories/";
    public static final String CATGAMESXPATH =
            "/html/body/app-root/div/app-lang/app-lang/app-all-categories/div/div/div[151]/app-content-category-box/div/a/div[2]/div[2]";



    public void goToThinkingGamesURL() {
        driver.get(THINKINGGAMESURL);
    }

    public void clickAllGamesBtn() {
        clickByXPath(ALLGAMESBTNXPATH);
    }

    public void asserAllGamesURL() {
        assertion(ALLGAMESURL);
    }





    public String thinkingGamesHandle() {
        return getWindowHandle();
    }

    public void navigateToAllGamesURL() {
        driver.navigate().to(ALLGAMESURL);
    }

    public void navigateToAllCategoriesURL() {
        driver.navigate().to(ALLCATEGORIESURL);
    }

    public String allGamesHandle() {
        return getWindowHandle();
    }

    public String allCategoriesHandle() {
        return getWindowHandle();
    }

    public void switchToThinkingGames() {
        switchToWindow(thinkingGamesHandle());
    }

    public void screenshotBottomThinkingPage() throws IOException {
        screenShot(driver, "bottomThinkingPage");
    }

    public void screenshotHalfWayThinkingPage() throws IOException {
        screenShot(driver, "halfWayUpThinkingPage");
    }

    public void switchToAllGames() {
        switchToWindow(allGamesHandle());
    }

    public void screenshotHalfWayAllGamesPage() throws IOException {
        screenShot(driver, "halfWayDownAllGamesPage");
    }

    public void screenshotTopAllGamesPage() throws IOException {
        screenShot(driver, "topAllGamesPage");
    }

    public void switchToAllCategories() {
        switchToWindow(allCategoriesHandle());
    }

    public void scrollToCatGames() {
        scrollToElementByXPath(CATGAMESXPATH);
    }

    public void screenshotCatGames() throws IOException {
        screenShot(driver, "catGamesAllCategoriesPage");
    }

}
