package tips.类加载;

import java.io.*;

/**
 * 自定义类加载器
 * <p>
 * <p>
 * 比如应用是通过网络来传输 Java 类的字节码，为保证安全性，
 * 这些字节码经过了加密处理，这时系统类加载器就无法对其进行加载，
 * 这样则需要自定义类加载器来实现。
 * <p>
 * 自定义类加载器一般都是继承自 ClassLoader 类，只需要重写 findClass 方法即可
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/8/6 10:27
 */
public class MyClassLoader extends ClassLoader {

    private String root;

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = loadClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException(name);
        } else {
            return defineClass(name, classData, 0, classData.length);
        }

    }

    private byte[] loadClassData(String className) {
        String fileName = root + File.separatorChar
                + className.replace(',', File.separatorChar) + ".class";

        try {
            InputStream ins = new FileInputStream(fileName);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int length = 0;
            while ((length = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public static void main(String[] args) {
        MyClassLoader classLoader = new MyClassLoader();
        classLoader.setRoot("D:\\myprojcet\\myJavaStudy");
        Class<?> testClass;

        try {
            testClass = classLoader.loadClass("tips.类加载.Test2");
            Object object = testClass.newInstance();
            System.out.println(object.getClass().getClassLoader());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
