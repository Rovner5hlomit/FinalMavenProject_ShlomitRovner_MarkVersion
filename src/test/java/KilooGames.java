import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.IOException;

public class KilooGames extends Files {

    public static final String THINKINGGAMESURL = "https://www.kiloo.com/en/thinking-games/";
    public static final String ALLGAMESBTNXPATH = "//*[@id=\"games\"]/a/img";

    public static final String ALLGAMESURL = "https://www.kiloo.com/en/games/";

    public static final String ALLCATEGORIESURL = "https://www.kiloo.com/en/categories/";
    public static final String CATGAMESXPATH =
            "/html/body/app-root/div/app-lang/app-lang/app-all-categories/div/div/div[151]/app-content-category-box/div/a/div[2]/div[2]";



    void simpleNavigation() {

        driver.get(THINKINGGAMESURL);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ALLGAMESBTNXPATH))).click();
        Assert.assertEquals(driver.getCurrentUrl(), ALLGAMESURL);
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

    }

    void resizing() {

        driver.get(THINKINGGAMESURL);
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        driver.manage().window().minimize();

    }

    void winTabNavigationScrollAndScreenshots() throws IOException {

        driver.get(THINKINGGAMESURL);
        String thinkingGamesWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(ALLGAMESURL);
        String allGamesTab = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to(ALLCATEGORIESURL);
        String allCategoriesWindow = driver.getWindowHandle();
        driver.switchTo().window(thinkingGamesWindow);
        jse.executeScript(SCROLLDOWNTOBOTTM);
        Files.screenShot(driver, "bottomThinkingPage");
        jse.executeScript(SCROLLUPTOHALFPAGE);
        screenShot(driver, "halfWayUpThinkingPage");
        driver.switchTo().window(allGamesTab);
        jse.executeScript(SCROLLDOWNTOHALFPAGE);
        screenShot(driver, "halfWayDownAllGamesPage");
        jse.executeScript(SCROLLUPTOTOP);
        screenShot(driver, "topAllGamesPage");
        driver.switchTo().window(allCategoriesWindow);
        jse.executeScript(SCROLLTOELEMENT,
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CATGAMESXPATH))));
        screenShot(driver, "catGamesAllCategoriesPage");

    }

}
