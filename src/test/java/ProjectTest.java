import org.testng.annotations.*;

import java.io.IOException;

public class ProjectTest {

    Files files = new Files();
    Action action = new Action();
    KilooGames kilooGames = new KilooGames();
    Hstern hstern = new Hstern();
    NextGen nextGen = new NextGen();
    Wiki wiki = new Wiki();

    Driver[] myPages = {kilooGames, hstern, nextGen, wiki, action};

    @BeforeClass
    void setUpDesktop() {

        files.createFolder(Files.FOLDERPATH, Files.FOLDERNAME);

    }

    @Test
    void simpleNavigation() {

        kilooGames.goToThinkingGamesURL();
        kilooGames.clickAllGamesBtn();
        kilooGames.asserAllGamesURL();
        action.pageBack();
        action.pageForward();
        action.pageRefresh();

    }

    @Test
    void resizing() {

        kilooGames.goToThinkingGamesURL();
        action.maximizeWindow();
        action.windowFullscreen();
        action.minimizeWindow();

    }

    @Test
    void navigateComplex() throws IOException {

        kilooGames.goToThinkingGamesURL();
        kilooGames.thinkingGamesHandle();
        action.openNewTab();
        kilooGames.navigateToAllGamesURL();
        kilooGames.allGamesHandle();
        action.openNewWindow();
        kilooGames.navigateToAllCategoriesURL();
        kilooGames.allCategoriesHandle();
        kilooGames.switchToThinkingGames();
        action.scrollDownToBottom();
        kilooGames.screenshotBottomThinkingPage();
        action.scrollUpHalfPage();
        kilooGames.screenshotHalfWayThinkingPage();
        kilooGames.switchToAllGames();
        action.scrollDownHalfPage();
        kilooGames.screenshotHalfWayAllGamesPage();
        action.scrollUpToTop();
        kilooGames.screenshotTopAllGamesPage();
        kilooGames.switchToAllCategories();
        kilooGames.scrollToCatGames();
        kilooGames.screenshotCatGames();

    }

    @Test
    void elementsHTMLActions() {

        hstern.goToHSternURL();
        action.scrollDownToBottom();
        hstern.doubleClickNewsLetterSignUp();
        hstern.insertEmail();
        hstern.clickAgreeToTermsCheckBox();
        hstern.clickAgreeToTermsCheckBox();
        hstern.rightClickAboutLink();

    }

    @Test
    void elementsHTMLAssertAndParagraph() throws IOException {

        hstern.goToHSternURL();
        hstern.clickPrismasLink();
        hstern.assertPrismasURL();
        hstern.screenshotPrismasParagraph();
        hstern.copyPrismasParagraphTextToFile();

    }

    @Test
    void dropDownAndAlert() throws IOException {

        nextGen.goToNextGenFormURL();
        nextGen.selectCountryFromDropDown();
        nextGen.screenshotSelectedCountryBrazil();
        nextGen.clickDateField();
        nextGen.clickChosenDate();
        nextGen.printResultDate();
        action.setWindowSize();
        action.scrollUpToTop();
        nextGen.clickQAAutomationMenu();
        nextGen.clickPracticeAutomationSelection();
        nextGen.clickAlertSelection();
        nextGen.assertNextgenAlertURL();
        nextGen.clickConfirmAlert();
        nextGen.dismissAlert();
        nextGen.printMessageResult(NextGen.RESULTFIELDONEID);
        nextGen.screenshotClickedOnCancelMessage();
        nextGen.clickPromptAlert();
        nextGen.sendKeysToAlert("yes");
        nextGen.acceptAlert();
        nextGen.printMessageResult(NextGen.RESULTFIELDTWOID);
        nextGen.screenshotThanksForLikingAutomationMessage();

    }

    @Test
    void copyWikiParagraph() throws IOException {

        wiki.goToWikipediaBDayURL();
        wiki.scrollToLyricsTitle();
        wiki.screenshotHappyBDay();
        wiki.copySongParagraphTextToFile();

    }

    @AfterClass
    void quit() {

        for (int i = 0; i < myPages.length; i++) {

            myPages[i].quitDriver();

        }

    }

}
