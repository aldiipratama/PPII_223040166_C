package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
  private final static String DB_URL = "jdbc:mysql://localhost:3306/tugas_latihan2";
  private final static String DB_USER = "root";
  private final static String DB_PASS = "";

  private static MySqlConnection instance;

  public static MySqlConnection getInstance() {
    if (instance == null) {
      instance = new MySqlConnection();
    }

    return instance;
  }

  public Connection getConnection() {
    Connection connection = null;
    try {
      connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    } catch (SQLException e) {
      e.getMessage();
    }

    return connection;
  }
}