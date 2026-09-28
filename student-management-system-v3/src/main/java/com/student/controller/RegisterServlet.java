package com.student.controller;

import com.student.dao.StudentDAO;
import com.student.dao.CourseDAO;
import com.student.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private final StudentDAO studentDAO = new StudentDAO();
    private final CourseDAO courseDAO = new CourseDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (password == null || !password.equals(confirmPassword)) {
            request.setAttribute("error", "Passwords do not match.");
            request.setAttribute("courses", courseDAO.findActiveCourses());
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
            return;
        }

        Student student = new Student();
        student.setFirstName(request.getParameter("firstName"));
        student.setLastName(request.getParameter("lastName"));
        student.setDateOfBirth(request.getParameter("dateOfBirth"));
        student.setEmail(request.getParameter("email"));
        student.setPhone(request.getParameter("phone"));
        student.setPassword(password);
        student.setGender(request.getParameter("gender"));
        student.setDepartment(request.getParameter("department"));
        student.setCourseId(Integer.parseInt(request.getParameter("courseId")));
        student.setCity(request.getParameter("city"));
        student.setAddress(request.getParameter("address"));

        boolean saved = studentDAO.save(student);

        if (saved) {
            if (request.getSession(false) != null && Boolean.TRUE.equals(request.getSession(false).getAttribute("adminLoggedIn"))) {
                response.sendRedirect(request.getContextPath() + "/students");
            } else {
                response.sendRedirect(request.getContextPath() + "/registration-success");
            }
        } else {
            request.setAttribute("error", "Registration failed. Please check the details and try again.");
            request.setAttribute("courses", courseDAO.findActiveCourses());
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
        }
    }
}
