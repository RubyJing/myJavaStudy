package tips.IO流例子;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
//        MyUtil.fileCopyNIO("C:\\Users\\30371\\IdeaProjects\\myJavaStudy\\src\\main\\java\\tips\\IO流例子\\resource",
//                "C:\\Users\\30371\\IdeaProjects\\myJavaStudy\\src\\main\\java\\tips\\IO流例子\\target");

        /**
         * 列出当前文件夹下的文件
         */
        File f = new File("C:\\Users\\30371\\IdeaProjects\\myJavaStudy\\src\\main\\java\\tips\\IO流例子");
        for (File temp: f.listFiles()){
            if(temp.isFile()){
                System.out.println(temp.getName());
            }
        }
    }
}
