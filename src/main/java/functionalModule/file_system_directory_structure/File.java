package functionalModule.file_system_directory_structure;

/**
 * 文件类
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/16 14:35
 */
public class File extends BaseFileSystemNode {
    public File(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        return 1;
    }

    @Override
    public long countSizeOfFiles() {
        java.io.File file = new java.io.File(path);
        if (!file.exists()){
            return 0;
        }
        return file.length();
    }
}
