package com.example.homework3;

import com.example.homework3.dao.DaoHelper;
import com.example.homework3.dao.WorkerDao;
import com.example.homework3.models.Worker;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws SQLException {
        WorkerDao workerDao = new WorkerDao();
        List<Worker> workers = workerDao.getWorkers();
        System.out.println(workers);
    }
}
