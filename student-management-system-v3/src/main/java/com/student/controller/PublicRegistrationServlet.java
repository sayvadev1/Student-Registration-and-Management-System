package com.student.controller;

import com.student.dao.CourseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

/** Public student registration entry point. No admin session is required. */
public class PublicRegistrationServlet extends HttpServlet {
    private final CourseDAO courseDAO = new CourseDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        request.setAttribute("courses", courseDAO.findActiveCourses());
        request.setAttribute("publicRegistration", true);
        request.getRequestDispatcher("/registration.jsp").forward(request, response);
    }
}
