package com.example.homework3.dao;

import com.example.homework3.Constants;
import com.example.homework3.connections.DBconnection;
import com.example.homework3.models.Airplane;
import com.example.homework3.models.Airport;
import com.example.homework3.models.Worker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AirplaneDao {
    public List<Airplane> getAirplanes() throws SQLException {
        String query = "SELECT * FROM " + Constants.AIRPORT_TABLE;
        List<Airplane> airplanes = new ArrayList<>();
        try (Connection connection = DBconnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)
        ) {
            while (resultSet.next()) {
                airplanes.add(new Airplane(
                        resultSet.getInt("Id"),
                        resultSet.getString("Name"),
                        resultSet.getString("Type")
                ));
            }
        }

        return airplanes;
    }

    public Airplane getAirplaneById(int id) throws SQLException {
        String query = "SELECT * FROM " + Constants.AIRPLANE_TABLE + " WHERE id = " + id;
        Airplane airplane = null;
        try (Connection connection = DBconnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)
        ) {
            while (resultSet.next()) {
                airplane = new Airplane(
                        resultSet.getInt("Id"),
                        resultSet.getString("Name"),
                        resultSet.getString("Type")
                );
            }
        }
        return airplane;
    }

    public void addAirplane(HashMap<String, Object> fieldsAndValues) throws SQLException {
        DaoHelper.addRecord(Constants.AIRPLANE_TABLE, fieldsAndValues);
    }

    public void updateAirplane(int id, HashMap<String, Object> columnsForUpdate) {
        DaoHelper.updateRecord(Constants.AIRPLANE_TABLE, id, columnsForUpdate);
    }
}
