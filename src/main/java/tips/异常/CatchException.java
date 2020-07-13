package tips.异常;

import java.io.*;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 捕获异常的方式
 *
 * finally遇见如下情况不会执行:
 *
 * 在前面的代码中用了System.exit()退出程序。
 * finally语句块中发生了异常。
 * 程序所在的线程死亡。
 * 关闭CPU。
 * @author RubyJing
 * @version 1.0
 * @date 2020/7/13 15:44
 */
public class CatchException {

    public static void main(String[] args) throws MyException {
        String filePath = "src/main/java/tips/异常";
//        readFile("src/main/java/tips/异常");
        readFile3(filePath);
    }


    //=================try-catch========================

    private static void readFile(String filePath) {
        try {
            File file = File.createTempFile("测试下",".txt", new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException o) {
            o.printStackTrace();
        }
    }

    private static void readFile2(String filePath) {
        try {
            File file = File.createTempFile("测试下",".txt", new File(filePath));
        } catch (FileNotFoundException | UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException o) {
            o.printStackTrace();
        }
    }

    //=====================try-catch-finally=========================

    private static void readFile3(String filePath) throws MyException {
        File file = new File(filePath);
        String result;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((result = reader.readLine()) != null){
                System.out.println(result);
            }
        } catch (IOException e) {
            System.out.println("readFile method catch block.");
            MyException ex = new MyException("read file failed.");
            ex.initCause(e);
            throw ex;
        }finally {
            System.out.println("readFile method finally block.");
            if (null != reader){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //=========================try-finally============================
    //try-finally可用在不需要捕获异常的代码，可以保证资源在使用后被关闭。
    // 例如IO流中执行完相应操作后，关闭相应资源；使用Lock对象保证线程同步，通过finally可以保证锁会被释放；数据库连接代码时，关闭连接操作等等。

    private static void tryFinally(){
        //以Lock加锁为例，演示try-finally
        ReentrantLock lock = new ReentrantLock();
        try {
            //需要加锁的代码
        }finally {
            lock.unlock();//保证锁一定被释放
        }
    }

    //===================try-with-resource(Java7)=====================
    //自动释放的资源需要是实现了 AutoCloseable 接口的类。

    private static void tryWithResourceTest(){
        try (Scanner scanner =  new Scanner(new FileInputStream("c:/abc"),"UTF-8")){

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }




}
