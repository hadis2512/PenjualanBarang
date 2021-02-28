package koneksi;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class db_config {
    private static Connection connection;

    public static Connection getConnection(){
        //pengecekan koneksi database
        if (connection==null){
            try{
                String host     = "localhost";
                String username = "root";
                String password = "";
                String db_name  = "";
                String port     = "3306";
                
                String url = "jdbc:mysql://localhost/warung";
                
                MysqlDataSource source = new MysqlDataSource();
                source.setUser(username);
                source.setPassword(password);
                source.setURL(url);
                connection = source.getConnection();
                System.out.println("Berhasil menghubungkan ke database");
            } catch (SQLException ex){
                System.out.println("Gagal menghubungkan ke database");
            }
        }
        return connection;
    }
}
