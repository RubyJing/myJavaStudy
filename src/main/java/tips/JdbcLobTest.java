package tips;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC处理Blob和Clob
 * @RubyJing
 */
public class JdbcLobTest {
    public static void main(String[] args) {
        Connection con = null;

        try {
            // 加载驱动（Java6以上版本可以省略）
//            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testone","root","");
            //创建语句对象
            PreparedStatement ps = con.prepareStatement("insert into tb_user values (default, ?, ?)");
            ps.setString(1,"RubyJing");
            try (InputStream in = new FileInputStream("test.jpg")){
                // 将SQL语句中第二个占位符换成二进制流
                ps.setBinaryStream(2,in);
                System.out.println(ps.executeUpdate() == 1 ? "插入成功":"插入失败");
            }catch (IOException e){
                System.out.println("读取照片失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null && !con.isClosed()){
                    //释放数据库连接
                    con.close();
                    //指示垃圾回收期可以回收该对象
                    con = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
