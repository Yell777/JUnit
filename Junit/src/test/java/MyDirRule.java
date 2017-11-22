import org.apache.commons.io.FileUtils;
import org.junit.rules.ExternalResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by User on 21.11.2017.
 */
public class MyDirRule extends ExternalResource {
    private static Path path;


    public Path getPath() {
        return  path;
    }


    @Override
    protected void before() {
        try {
            path = Files.createTempDirectory("TempDir");
        } catch (IOException e) {
            System.out.println("Диреткория не создана ");
        }
    }

    ;

    @Override
    protected void after() {
        try {
            FileUtils.deleteDirectory(path.toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ;



}