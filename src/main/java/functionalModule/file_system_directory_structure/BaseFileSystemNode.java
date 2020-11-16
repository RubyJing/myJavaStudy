package functionalModule.file_system_directory_structure;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/16 14:34
 */
public abstract class BaseFileSystemNode {

    protected String path;

    public BaseFileSystemNode(String path) {
        this.path = path;
    }

    public abstract int countNumOfFiles();
    public abstract long countSizeOfFiles();

    public String getPath() {
        return path;
    }
}
