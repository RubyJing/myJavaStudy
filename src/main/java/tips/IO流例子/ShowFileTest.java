package tips.IO流例子;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 使用NIO.2查询文件夹下文件
 * @author RubyJing
 */
public class ShowFileTest {
    public static void main(String[] args) throws IOException {
        Path initPath = Paths.get("C:\\Users\\30371\\IdeaProjects\\myJavaStudy\\src\\main\\java\\tips\\IO流例子");
        Files.walkFileTree(initPath,new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attr)
            {
                System.out.println(file.getFileName().toString());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
