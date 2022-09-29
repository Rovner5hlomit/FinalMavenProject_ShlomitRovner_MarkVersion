import org.testng.annotations.*;

import java.io.IOException;

public class ProjectTest {

    @BeforeClass
    static void setUpDesktop() {

        Files.createFolder(Files.FOLDERPATH, Files.FOLDERNAME);

    }

    @AfterClass
    static void quitDriver() {

        Driver.driver.quit();

    }

    @Test
    void navigationSimple() {

        KilooGames.simpleNavigation();

    }

    @Test
    void resizeSimple() {

        KilooGames.resizing();

    }

    @Test
    void navigateComplex() throws IOException {

        KilooGames.winTabNavigationScrollAndScreenshots();

    }

    @Test
    void elementsHTMLOne() throws IOException {

        Hstern.elementsHTMLAssertAndParagraph();

    }

    @Test
    void elementsHTMLTwo() throws IOException {

        NextGen.dropDownAndAlert();

    }

    @Test
    void copyWikiParagraph() throws IOException {

        Wiki.copyWikiParagraph();

    }

}
