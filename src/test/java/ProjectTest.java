import org.testng.annotations.*;

import java.io.IOException;

public class ProjectTest extends Files {

    KilooGames kilooGames = new KilooGames();
    Hstern hstern = new Hstern();
    NextGen nextGen = new NextGen();
    Wiki wiki = new Wiki();

    @BeforeClass
    void setUpDesktop() {

        createFolder(FOLDERPATH, FOLDERNAME);

    }

    @Test
    void navigationSimple() {

        kilooGames.simpleNavigation();

    }

    @Test
    void resizeSimple() {

        kilooGames.resizing();

    }

    @Test
    void navigateComplex() throws IOException {

        kilooGames.winTabNavigationScrollAndScreenshots();

    }

    @Test
    void elementsHTMLOne() throws IOException {

        hstern.elementsHTMLAssertAndParagraph();

    }

    @Test
    void elementsHTMLTwo() throws IOException {

        nextGen.dropDownAndAlert();

    }

    @Test
    void copyWikiParagraph() throws IOException {

        wiki.copyWikiParagraph();

    }

    @AfterClass
    void quitDriver() {

        driver.quit();

    }

}
