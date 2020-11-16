package functionalModule.file_system_directory_structure;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/16 14:37
 */
public class Directory extends BaseFileSystemNode {

    private List<BaseFileSystemNode> subNodes = new ArrayList<>();

    public Directory(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        int numOfFiles = 0;
        for (BaseFileSystemNode subNode : subNodes) {
            numOfFiles += subNode.countNumOfFiles();
        }
        return numOfFiles;
    }

    @Override
    public long countSizeOfFiles() {
        long sizeofFiles = 0L;
        for (BaseFileSystemNode subNode : subNodes) {
            sizeofFiles += subNode.countSizeOfFiles();
        }
        return sizeofFiles;
    }

    public void addSubNode(BaseFileSystemNode fileOrDir) {
        subNodes.add(fileOrDir);
    }

    public void removeSubNode(BaseFileSystemNode fileOrDir) {
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
