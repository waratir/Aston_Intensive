package com.example.homework3.servlet.worker;

import com.example.homework3.Constants;
import com.example.homework3.dao.WorkerDao;
import com.example.homework3.models.Worker;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/allworkers")
public class WorkerDetailsServlet extends HttpServlet {

    private WorkerDao workerDao;

    @Override
    public void init() throws ServletException {
        workerDao = new WorkerDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Worker> workers = workerDao.getWorkers();
            req.setAttribute("workers", workers);

            req.getRequestDispatcher("/worker.jsp").forward(req, resp);

        } catch (SQLException e) {
            throw new ServletException("Error retrieving worker details", e);
        }
    }
}
