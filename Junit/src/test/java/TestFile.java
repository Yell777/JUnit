import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;
import java.io.IOException;

/**
 * Created by User on 16.11.2017.
 */
public class TestFile extends TestBase implements MyCategories {

    @Test
    @Category(PositiveTests.class)
    public void TestCreateNewFileTXT() throws IOException {

        String absoluteFilePath = path + "/" + "Test" + ".txt";

        file = new File(absoluteFilePath);
        Assert.assertTrue("Файл не создан или уже существует",file.createNewFile());
        System.out.println("Файл создан во временной директории :" + file);

    }

    @Test
    @Category(PositiveTests.class)
    public void TestCreateFileDoc() throws IOException {

        String absoluteFilePath = path + "/" + "Test" + ".doc";

        file = new File(absoluteFilePath);
        Assert.assertTrue("Файл не создан или уже существует",file.createNewFile());
        System.out.println("Файл создан во временной директории :" + file);
    }

    @Test
    @Category(PositiveTests.class)
    public void TestNewFileCSV() throws IOException {
        String absoluteFilePath = path + "/" + "TEst" + ".csv";

        file = new File(absoluteFilePath);
        Assert.assertTrue("Файл не создан или уже существует",file.createNewFile());
        System.out.println("Файл создан во временной директории :" + file);
    }

    @Test
    @Category(NegativeTests.class)
    public void TestCreateNewFileErorrIOExp() throws IOException {
        String absoluteFilePath = "/TestWrong.doc";;
        file = new File(absoluteFilePath);
        try{
            file.createNewFile();
            Assert.fail("Expected IOException");
        } catch (IOException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }

    }

    @Test
    @Category(NegativeTests.class)
    public void TestCreateFalse() throws IOException {
        String absoluteFilePath = path + "/" + "TESTFALSE" + ".csv";
        file = new File(absoluteFilePath);
        file.createNewFile();
        Assert.assertFalse("Файл уже создан ",file.createNewFile());

    }


}
