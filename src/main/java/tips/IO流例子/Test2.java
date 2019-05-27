package tips.IO流例子;

import java.io.File;
/**
 * 列出当前文件夹下的文件(升级版)
 */
public class Test2 {
    public static void main(String[] args) {
        showDirectory(new File("C:\\Users\\30371\\IdeaProjects\\myJavaStudy\\src\\main\\java\\tips\\IO流例子"));
    }

    public static void showDirectory(File f){
        _walkDirectory(f,0);
    }

    private static void _walkDirectory(File f,int level){
        if (f.isDirectory()){
            for (File temp : f.listFiles()){
                _walkDirectory(temp,level+1);
            }
        }else {
            for (int i=0;i<level - 1;i++){
                System.out.println("\t");
            }
            System.out.println(f.getName());
        }
    }
}
