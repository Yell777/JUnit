import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 16.11.2017.
 */
@RunWith(DataProviderRunner.class)
public class TestFile extends TestBase implements MyCategories {
    private static int attempt = 1;

    @Test
    @Category(PositiveTests.class)
    @UseDataProvider("users")
    public void TestCreateNewFileTXT(String name) throws IOException {

        String absoluteFilePath = path + "/" + name + ".txt";

        file = new File(absoluteFilePath);
        Assert.assertTrue("Файл не создан или уже существует",file.createNewFile());
        System.out.println("Файл создан во временной директории :" + file);

    }

    @Test
    @Category(PositiveTests.class)
    @UseDataProvider("users")
    public void TestCreateFileDoc(String name) throws IOException {

        String absoluteFilePath = path + "/" + name + ".doc";

        file = new File(absoluteFilePath);
        Assert.assertTrue("Файл не создан или уже существует",file.createNewFile());
        System.out.println("Файл создан во временной директории :" + file);
    }

    @Test
    @Category(PositiveTests.class)
    @UseDataProvider("users")
    public void TestNewFileCSV(String name) throws IOException {
        String absoluteFilePath = path + "/" + name + ".csv";

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

    @Test
    @UnstableTest
    public void randomlyFailingTest() {
        if (attempt == 2) {
            attempt = 1;

        } else {
            Assert.fail("Failed on " + (attempt++) + " attempt");
        }
    }



    @DataProvider
    public static Object[] users() {
        return new Object[] {
                "TestName"

        };
    }



}
