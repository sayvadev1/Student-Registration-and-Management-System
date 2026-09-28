package com.student.controller;

import com.student.dao.CourseDAO;
import com.student.dao.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    private final StudentDAO studentDAO = new StudentDAO();
    private final CourseDAO courseDAO = new CourseDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || !Boolean.TRUE.equals(session.getAttribute("adminLoggedIn"))) {
            response.sendRedirect(request.getContextPath() + "/admin-login");
            return;
        }

        request.setAttribute("totalStudents", studentDAO.countAll());
        request.setAttribute("activeStudents", studentDAO.countByStatus("Active"));
        request.setAttribute("inactiveStudents", studentDAO.countByStatus("Inactive"));
        request.setAttribute("totalCourses", courseDAO.countAll());

        request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
    }
}
