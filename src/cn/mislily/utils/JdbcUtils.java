package cn.mislily.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtils {

    private static DataSource dataSource = null;

    static {

        dataSource = new ComboPooledDataSource("book_devoloper");

    }

    public static Connection getConnection() throws SQLException {

        return dataSource.getConnection();

    }

    public static void closeConnection(Connection connection){

        if(connection != null){

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

}
