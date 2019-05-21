package tips.对象克隆;

import java.io.*;

public class MyUtil {
    private MyUtil(){
        throw new AssertionError();
    }

    @SuppressWarnings("uncheked")
    public static <T extends Serializable> T clone(T obj) throws Exception{
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(obj);

        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T)ois.readObject();
    }
}
