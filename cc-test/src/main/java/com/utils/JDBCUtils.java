package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author shanglei
 * @date 2017/7/26.
 */
public class JDBCUtils {

    /**
     * 插入一条记录，传sql
     */

    public static void insertData(String sql) {

        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://192.168.102.72:3306/tstorddb?useUnicode=true&characterEncoding=UTF-8&connectTimeout"
                    + "=60000&socketTimeout=60000&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true",
                "zhtx_dev3", "zhtx123879");
            statement = connection.createStatement();
            int i = statement.executeUpdate(sql);
            if (i > 0) {
                System.out.println("插入成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                statement = null;
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                connection = null;
            }
        }
    }

    public static void updata(String sql) {

        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://192.168.102.72:3306/tstorddb?useUnicode=true&characterEncoding=UTF-8&connectTimeout"
                    + "=60000&socketTimeout=60000&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true",
                "zhtx_dev3", "zhtx123879");
            statement = connection.createStatement();
            int i = statement.executeUpdate(sql);
            if (i > 0) {
                System.out.println("插入成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                statement = null;
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                connection = null;
            }
        }
    }

}
