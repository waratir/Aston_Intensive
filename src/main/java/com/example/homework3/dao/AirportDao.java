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

public class AirportDao {
    public List<Airport> getAirports() throws SQLException {
        String query = "SELECT * FROM " + Constants.AIRPORT_TABLE;
        List<Airport> airports = new ArrayList<>();
        try (Connection connection = DBconnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)
        ) {
            while (resultSet.next()) {
                airports.add(new Airport(
                        resultSet.getInt("Id"),
                        resultSet.getString("Name"),
                        resultSet.getString("City"),
                        resultSet.getInt("Airplane"),
                        resultSet.getInt("Worker")
                ));
            }
        }

        return airports;
    }

    public Airport getAirportById(int id) throws SQLException {
        String query = "SELECT * FROM " + Constants.AIRPORT_TABLE + " WHERE id = " + id;
        Airport airport = null;
        try (Connection connection = DBconnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)
        ) {
            while (resultSet.next()) {
                airport = new Airport(
                        resultSet.getInt("Id"),
                        resultSet.getString("Name"),
                        resultSet.getString("City"),
                        resultSet.getInt("Airplane"),
                        resultSet.getInt("Worker")
                );
            }
        }
        return airport;
    }

    public void addAirport(HashMap<String, Object> fieldsAndValues) throws SQLException {
        DaoHelper.addRecord(Constants.AIRPORT_TABLE, fieldsAndValues);
    }

    public void updateAirport(int id, HashMap<String, Object> columnsForUpdate) {
        DaoHelper.updateRecord(Constants.AIRPORT_TABLE, id, columnsForUpdate);
    }
}
