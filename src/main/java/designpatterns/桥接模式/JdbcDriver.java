package designpatterns.桥接模式;

import java.sql.*;

/**
 * Jdbc驱动
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/13 14:30
 */
public class JdbcDriver {

    public void query(){
        try {
            //加载及注册JDBC驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sample_db?user=root&password=your_password";
            Connection con = DriverManager.getConnection(url);
            Statement statement = con.createStatement();
            String query = "select * from test";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                rs.getString(1);
                rs.getInt(2);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
