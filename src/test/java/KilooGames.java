import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.IOException;

public class KilooGames {

    public static final String THINKINGGAMESURL = "https://www.kiloo.com/en/thinking-games/";
    public static final String ALLGAMESBTNXPATH = "//*[@id=\"games\"]/a/img";

    public static final String ALLGAMESURL = "https://www.kiloo.com/en/games/";

    public static final String ALLCATEGORIESURL = "https://www.kiloo.com/en/categories/";
    public static final String CATGAMESXPATH =
            "/html/body/app-root/div/app-lang/app-lang/app-all-categories/div/div/div[151]/app-content-category-box/div/a/div[2]/div[2]";



    public static void simpleNavigation() {

        Driver.driver.get(THINKINGGAMESURL);
        Driver.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ALLGAMESBTNXPATH))).click();
        Assert.assertEquals(Driver.driver.getCurrentUrl(), ALLGAMESURL);
        Driver.driver.navigate().back();
        Driver.driver.navigate().forward();
        Driver.driver.navigate().refresh();

    }

    public static void resizing() {

        Driver.driver.get(THINKINGGAMESURL);
        Driver.driver.manage().window().maximize();
        Driver.driver.manage().window().fullscreen();
        Driver.driver.manage().window().minimize();

    }

    public static void winTabNavigationScrollAndScreenshots() throws IOException {

        Driver.driver.get(THINKINGGAMESURL);
        String thinkingGamesWindow = Driver.driver.getWindowHandle();
        Driver.driver.switchTo().newWindow(WindowType.TAB);
        Driver.driver.navigate().to(ALLGAMESURL);
        String allGamesTab = Driver.driver.getWindowHandle();
        Driver.driver.switchTo().newWindow(WindowType.WINDOW);
        Driver.driver.navigate().to(ALLCATEGORIESURL);
        String allCategoriesWindow = Driver.driver.getWindowHandle();
        Driver.driver.switchTo().window(thinkingGamesWindow);
        Driver.jse.executeScript(Driver.SCROLLDOWNTOBOTTM);
        Files.screenShot(Driver.driver, "bottomThinkingPage");
        Driver.jse.executeScript(Driver.SCROLLUPTOHALFPAGE);
        Files.screenShot(Driver.driver, "halfWayUpThinkingPage");
        Driver.driver.switchTo().window(allGamesTab);
        Driver.jse.executeScript(Driver.SCROLLDOWNTOHALFPAGE);
        Files.screenShot(Driver.driver, "halfWayDownAllGamesPage");
        Driver.jse.executeScript(Driver.SCROLLUPTOTOP);
        Files.screenShot(Driver.driver, "topAllGamesPage");
        Driver.driver.switchTo().window(allCategoriesWindow);
        Driver.jse.executeScript(Driver.SCROLLTOELEMENT,
                Driver.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CATGAMESXPATH))));
        Files.screenShot(Driver.driver, "catGamesAllCategoriesPage");

    }

}
