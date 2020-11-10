package designpatterns.单例模式;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 集群id生成(伪代码）
 * <p>
 * 具体来说，我们需要把这个单例对象序列化并存储到外部共享存储区（比如文件）。进程再使用这个单例对象的时候，
 * 需要先从外部共享存储区中将它读取到内存，并反序列化成对象，然后再使用，使用完成之后还需要再存储回外部共享存储区。
 * 为了保证任何时刻，在进程间都只有一份对象存在，一个进程在获取到对象之后，需要对对象加锁，避免其他进程再将其获取。
 * 在进程使用完这个对象之后，还需要显式地将对象从内存中删除，并且释放对对象的加锁。
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/10 10:00
 */
public class ClusterIdGenerator {
    private AtomicLong id = new AtomicLong(0);
    private static ClusterIdGenerator INSTANCE;
    private static SharedObjectStorage storage = new FileSharedObjectStorage("文件地址");
    private static DistributedLock lock = new DistributedLock();

    private ClusterIdGenerator() {
    }

    public synchronized static ClusterIdGenerator getInstance() {
        if (INSTANCE == null) {
            lock.lock();
            INSTANCE = storage.load(ClusterIdGenerator.class);
        }
        return INSTANCE;
    }

    public synchronized void freeInstance() {
        storage.save(this, ClusterIdGenerator.class);
        INSTANCE = null;//释放对象
        lock.unLock();
    }

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        ClusterIdGenerator clusterIdGenerator = ClusterIdGenerator.getInstance();
        long id = clusterIdGenerator.getId();
        clusterIdGenerator.freeInstance();
    }
}

/**
 * 共享存储区
 */
interface SharedObjectStorage {
    ClusterIdGenerator load(Class<? extends ClusterIdGenerator> clazz);

    <T extends ClusterIdGenerator> void save(T t, Class<? extends ClusterIdGenerator> clazz);
}

/**
 * 文件共享存储区
 */
class FileSharedObjectStorage implements SharedObjectStorage {
    /**
     * 文件地址
     */
    private String fileAddress;

    public FileSharedObjectStorage(String fileAddress) {
        this.fileAddress = fileAddress;
    }


    @Override
    public ClusterIdGenerator load(Class<? extends ClusterIdGenerator> clazz) {
        return null;
    }

    @Override
    public <T extends ClusterIdGenerator> void save(T t, Class<? extends ClusterIdGenerator> clazz) {

    }
}

/**
 * 分布式锁
 */
class DistributedLock {
    public void lock() {
        //加锁
    }

    public void unLock() {
        //解锁
    }
}