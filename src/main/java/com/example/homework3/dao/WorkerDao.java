package com.example.homework3.dao;

import com.example.homework3.Constants;
import com.example.homework3.connections.DBconnection;
import com.example.homework3.models.Worker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WorkerDao {

    public List<Worker> getWorkers() throws SQLException {
        String query = "SELECT * FROM " + Constants.WORKER_TABLE;
        List<Worker> workers = new ArrayList<>();
        try (Connection connection = DBconnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)
        ) {
            while (resultSet.next()) {
                workers.add(new Worker(
                        resultSet.getInt("Id"),
                        resultSet.getString("Name"),
                        resultSet.getInt("Phone"),
                        resultSet.getString("Email")
                ));
            }
        }

        return workers;
    }

    public Worker getWorkerById(int id) throws SQLException {
        String query = "SELECT * FROM " + Constants.WORKER_TABLE + " WHERE id = " + id;
        Worker worker = null;
        try (Connection connection = DBconnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)
        ) {
            while (resultSet.next()) {
                worker = new Worker(
                        resultSet.getInt("Id"),
                        resultSet.getString("Name"),
                        resultSet.getInt("Phone"),
                        resultSet.getString("Email")
                );
            }
        }
        return worker;
    }

    public void addWorker(HashMap<String, Object> fieldsAndValues) throws SQLException {
        DaoHelper.addRecord(Constants.WORKER_TABLE, fieldsAndValues);
    }

    public void updateWorker(int id, HashMap<String, Object> columnsForUpdate) {
        DaoHelper.updateRecord(Constants.WORKER_TABLE, id, columnsForUpdate);
    }
}
