package designpatterns.原型模式;

import functionalModule.statistics_interface_call_information.Prototype.UserVo;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 原型模式实用例子
 * <p>
 * 假设数据库中存储了大约 10 万条“搜索关键词”信息，每条信息包含关键词、关键词被搜索的次数、信息最近被更新的时间等。
 * 系统 A 在启动的时候会加载这份数据到内存中，用于处理某些其他的业务需求。
 * 为了方便快速地查找某个关键词对应的信息，我们给关键词建立一个散列表索引。
 * <p>
 * 我们还有另外一个系统 B，专门用来分析搜索日志，定期（比如间隔 10 分钟）批量地更新数据库中的数据，并且标记为新的数据版本。
 * <p>
 * 特殊的要求：任何时刻，系统 A 中的所有数据都必须是同一个版本的
 * 还要求：在更新内存数据的时候，系统 A 不能处于不可用状态，也就是不能停机更新数据。
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/12 11:19
 */
public class PrototypeDemo {
    private HashMap<String, SearchWord> currentKeyWords = new HashMap<>();
    private long lastUpdateTime = -1;

    public void refresh() {
        //Deep Copy
//        HashMap<String, SearchWord> newKeyWords = new HashMap<>();
//        for (Map.Entry<String, SearchWord> entry : currentKeyWords.entrySet()) {
//            SearchWord searchWord = entry.getValue();
//            SearchWord newSearchWord = new SearchWord(searchWord.keyWord, searchWord.count, searchWord.lastUpdateTime);
//            newKeyWords.put(entry.getKey(), newSearchWord);
//        }

        //浅拷贝和深拷贝结合:
        // Shallow copy:采用浅拷贝的方式创建 newKeywords
        HashMap<String, SearchWord> newKeyWords = (HashMap<String, SearchWord>) currentKeyWords.clone();

        // 从数据库中取出更新时间 > lastUpdateTime的数据，放入到newKeyWords中
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if (searchWord.lastUpdateTime > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.lastUpdateTime;
            }

//            if (newKeyWords.containsKey(searchWord.keyWord)) {
//                SearchWord oldSearchWord = newKeyWords.get(searchWord.keyWord);
//                oldSearchWord.count = searchWord.count;
//                oldSearchWord.lastUpdateTime = searchWord.lastUpdateTime;
//            } else {
//                newKeyWords.put(searchWord.keyWord, searchWord);
//            }

            // 只深拷贝有更新的数据
            if (newKeyWords.containsKey(searchWord.keyWord)) {
                //删除浅拷贝中的索引
                newKeyWords.remove(searchWord.keyWord);
            }
            newKeyWords.put(searchWord.keyWord, searchWord);
        }

        lastUpdateTime = maxNewUpdatedTime;
        currentKeyWords = newKeyWords;
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        //TODO: 从数据库中取出更新时间 > lastUpdateTime的数据
        return new ArrayList<>();
    }

    /**
     * 使用序列化的方式深度拷贝
     *
     * @return object
     */
    public Object deepCopy(Object object) throws InstanceCreateFailException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(object);

            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(bi);

            return oi.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new InstanceCreateFailException("deepCopy create instance fail");
        }
    }


    public static class SearchWord {
        /**
         * 关键词
         */
        private String keyWord;
        /**
         * 次数
         */
        private long count;
        /**
         * 更新时间戳
         */
        private long lastUpdateTime;

        public SearchWord(String keyWord, long count, long lastUpdateTime) {
            this.keyWord = keyWord;
            this.count = count;
            this.lastUpdateTime = lastUpdateTime;
        }

        public void setKeyWord(String keyWord) {
            this.keyWord = keyWord;
        }

        public void setCount(long count) {
            this.count = count;
        }

        public void setLastUpdateTime(long lastUpdateTime) {
            this.lastUpdateTime = lastUpdateTime;
        }

        public String getKeyWord() {
            return keyWord;
        }

        public long getCount() {
            return count;
        }

        public long getLastUpdateTime() {
            return lastUpdateTime;
        }
    }
}
