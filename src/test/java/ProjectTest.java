import org.testng.annotations.*;

import java.io.IOException;

public class ProjectTest {

    Files files = new Files();
    KilooGames kilooGames = new KilooGames();
    Hstern hstern = new Hstern();
    NextGen nextGen = new NextGen();
    Wiki wiki = new Wiki();

    Driver[] myPages = {kilooGames, hstern, nextGen, wiki};

    @BeforeClass
    void setUpDesktop() {

        files.createFolder(Files.FOLDERPATH, Files.FOLDERNAME);

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
    void quit() {

        for (int i = 0; i < myPages.length; i++) {

            myPages[i].quitDriver();

        }

    }

}
