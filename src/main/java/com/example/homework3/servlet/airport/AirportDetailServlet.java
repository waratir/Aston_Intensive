package com.example.homework3.servlet.airport;

import com.example.homework3.dao.AirportDao;
import com.example.homework3.dao.WorkerDao;
import com.example.homework3.models.Airport;
import com.example.homework3.models.Worker;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AirportDetailServlet extends HttpServlet {
    private AirportDao airportDao;

    @Override
    public void init() throws ServletException {
        airportDao = new AirportDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Airport> workers = airportDao.getAirports();
            req.setAttribute("airports", workers);

            req.getRequestDispatcher("/worker.jsp").forward(req, resp);

        } catch (SQLException e) {
            throw new ServletException("Error retrieving worker details", e);
        }
    }
}
