package controller;

import java.sql.Connection;
import java.sql.SQLException;

import db.MySqlConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.BiodataModel;

public class BiodataController {
  Connection conn = MySqlConnection.getInstance().getConnection();
  PreparedStatement statement;

  public int insert(BiodataModel biodata) {
    int result = -1;

    try {
      statement = conn
          .prepareStatement("insert into biodata (id, nama, noHP, jenisKelamin, wna) values (?, ?, ?, ?, ?)");
      statement.setString(1, biodata.getId());
      statement.setString(2, biodata.getNama());
      statement.setString(3, biodata.getNoHP());
      statement.setString(4, biodata.getJenisKelamin());
      statement.setString(5, biodata.getWna());

      result = statement.executeUpdate();
    } catch (SQLException e) {
      e.getMessage();
    }

    return result;
  };

  public int update(BiodataModel biodata) {
    int result = -1;

    try {
      statement = conn
          .prepareStatement("update biodata set nama = ? , noHP = ? , jenisKelamin = ? , wna = ? where id = ?");
      statement.setString(1, biodata.getNama());
      statement.setString(2, biodata.getNoHP());
      statement.setString(3, biodata.getJenisKelamin());
      statement.setString(4, biodata.getWna());
      statement.setString(5, biodata.getId());

      result = statement.executeUpdate();
    } catch (SQLException e) {
      e.getMessage();
    }

    return result;
  };

  public int delete(BiodataModel biodata) {
    int result = -1;

    try {
      statement = conn
          .prepareStatement("delete from biodata where id = ?");
      statement.setString(1, biodata.getId());

      result = statement.executeUpdate();
    } catch (SQLException e) {
      e.getMessage();
    }

    return result;
  };

  public List<BiodataModel> findAll(BiodataModel biodata) {
    List<BiodataModel> list = new ArrayList<>();
    try (Statement state = conn.createStatement()) {
      try (ResultSet resultSet = state.executeQuery("select * from biodata")) {
        while (resultSet.next()) {
          BiodataModel biodataModel = new BiodataModel();
          biodataModel.setId(resultSet.getString("id"));
          biodataModel.setNama(resultSet.getString("nama"));
          biodataModel.setNoHP(resultSet.getString("noHP"));
          biodataModel.setJenisKelamin(resultSet.getString("jenisKelamin"));
          biodataModel.setWna(resultSet.getString("wna"));
          list.add(biodataModel);
        }
      } catch (SQLException e) {
        e.getMessage();
      }
    } catch (SQLException e) {
      e.getMessage();
    }

    return list;
  };
}