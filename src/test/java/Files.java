import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Files {

    public static final String FOLDERPATH = "C:\\Users\\shlomitr\\Desktop\\";
    public static final String FOLDERNAME = "ShlomitFolder";
    public static final String JPG = ".jpg";
    public static final String TXT = ".txt";


    public void createFolder(String folderPath, String folderName) {

        File folder = new File(folderPath + folderName);
        if (folder.mkdir()) {
            System.out.println("Folder Created");
        } else {
            System.out.println("Folder Already Exists");
        }

    }

    public void createFile(String fileName, String text) {

        File file = new File(FOLDERPATH + FOLDERNAME + "\\" + fileName + TXT);
        try {
            if (file.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("File already exists");
            }

            FileWriter writer = new FileWriter(file);
            writer.write(text);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void screenShot(WebDriver driver, String fileName) throws IOException {

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(FOLDERPATH + FOLDERNAME + "\\" + fileName + JPG));


    }

}
