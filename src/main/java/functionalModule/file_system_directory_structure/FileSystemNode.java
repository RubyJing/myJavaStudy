package functionalModule.file_system_directory_structure;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件和目录统一表示节点类 (旧版）
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/16 14:11
 */
public class FileSystemNode {
    private String path;
    private boolean isFile;
    private List<FileSystemNode> subNodes = new ArrayList<>();

    public FileSystemNode(String path, boolean isFile) {
        this.path = path;
        this.isFile = isFile;
    }

    public int countNumOfFiles() {
        if (isFile) {
            return 1;
        }
        //文件总数
        int numFiles = 0;
        for (FileSystemNode subNode : subNodes) {
            numFiles += subNode.countNumOfFiles();
        }
        return numFiles;
    }

    public long countSizeOfFiles() {
        if (isFile){
            File file = new File(path);
            if (!file.exists()){
                return 0;
            }
            return file.length();
        }
        //文件大小总数
        long countSizeFiles = 0L;
        for (FileSystemNode subNode : subNodes) {
            countSizeFiles += subNode.countSizeOfFiles();
        }
        return countSizeFiles;
    }

    public String getPath() {
        return path;
    }

    public void addSubNode(FileSystemNode fileOrDir) {
        subNodes.add(fileOrDir);
    }

    public void removeSubNode(FileSystemNode fileOrDir) {
        int size = subNodes.size();
        int i = 0;
        for (; i < size; ++i) {
            if (subNodes.get(i).getPath().equalsIgnoreCase(fileOrDir.getPath())) {
                break;
            }
        }
        if (i < size) {
            subNodes.remove(i);
        }
    }
}
