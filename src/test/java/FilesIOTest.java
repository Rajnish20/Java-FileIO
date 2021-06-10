import com.magic.filesio.FilesIO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class FilesIOTest {

    Path tempPath = Paths.get("C:\\Users\\rajni\\Desktop\\Temp");

    @Test
    public void givenFilePath_whenExist_ShouldReturnTrue() {
        Assertions.assertTrue(Files.exists(tempPath));
    }

    @Test
    public void givenPath_CheckAndDelete_ShouldReturnTrue() {
        if (Files.exists(tempPath))
            FilesIO.deleteFiles(tempPath.toFile());
        Assertions.assertTrue(Files.notExists(tempPath));
    }

    @Test
    public void givenPath_ShouldCreateDirectory_AndReturnTrue() throws IOException {
        Files.createDirectory(tempPath);
        Assertions.assertTrue(Files.exists(tempPath));
    }

    @Test
    public void givenPath_ShouldCreateFiles_AndReturnTrue() {
        IntStream.range(1,5).forEach(counter -> {
            Path tempFiles = Paths.get(tempPath + "\\temp" + counter);
            Assertions.assertTrue(Files.notExists(tempFiles));
            try
            {
                Files.createFile(tempFiles);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            Assertions.assertTrue(Files.exists(tempFiles));
        });
    }

    @Test
    public void ListFiles() throws IOException {
        Files.list(tempPath).filter(Files::isRegularFile).forEach(System.out::println);
    }
}
