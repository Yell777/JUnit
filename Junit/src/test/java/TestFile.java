import java.io.File;
import java.io.IOException;

/**
 * Created by User on 16.11.2017.
 */
public class TestFile extends TestBase {



    public void TestCreateNewFileTXT(String nameFile) throws IOException {

        String absoluteFilePath = path + "/" + nameFile + ".txt";

        file = new File(absoluteFilePath);
        Assert.assertTrue(file.createNewFile(),"Файл не создан или уже существует");

        System.out.println("Файл создан во временной директории :" + file);

    }

    public void TestCreateFileDoc(String nameFile) throws IOException {

        String absoluteFilePath = path + "/" + nameFile + ".doc";

        file = new File(absoluteFilePath);
        Assert.assertTrue(file.createNewFile(),"Файл не создан или уже существует");
        System.out.println("Файл создан во временной директории :" + file);
    }

    public void TestNewFileCSV(String test) throws IOException {
        String absoluteFilePath = path + "/" + test + ".csv";

        file = new File(absoluteFilePath);
        Assert.assertTrue(file.createNewFile(),"Файл не создан или уже существует");
        System.out.println("Файл создан во временной директории :" + file);
    }


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


    public void TestCreateFalse() throws IOException {
        String absoluteFilePath = path + "/" + "TESTFALSE" + ".csv";
        file = new File(absoluteFilePath);
        file.createNewFile();
        Assert.assertFalse(file.createNewFile(),"Файл уже создан ");

    }


}
