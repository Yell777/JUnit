import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by User on 16.11.2017.
 */
public class TestBase {

    protected static Path path;
    protected static File file;
    private static Files dir;


    @Before
    public void setupNewDirTemp() {
        try {
            path = Files.createTempDirectory("TempDir");
        } catch (IOException e) {
            System.out.println("Диреткория не создана ");
        }

    }

    @After
    public void deleteTempDir()  {
        try {
            FileUtils.deleteDirectory(path.toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @DataProvider
    public Iterator<Object[]> name() {
        List<Object[]> data = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            data.add(new Object[]{
                    generateRandomName()
            });
        }
        return data.iterator();
    }
    private Object generateRandomName() {
        return "TestFile" + new Random().nextInt();
    }
}
