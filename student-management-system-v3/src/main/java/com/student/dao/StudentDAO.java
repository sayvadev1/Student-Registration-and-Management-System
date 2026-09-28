package com.student.dao;

import com.student.model.Student;
import com.student.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public boolean save(Student s) {
        String sql = """
            INSERT INTO students
            (first_name, last_name, date_of_birth, email, phone, password,
             gender, department, course_id, city, address, status, registration_date)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'Active', CURDATE())
            """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getFirstName());
            ps.setString(2, s.getLastName());
            ps.setDate(3, Date.valueOf(s.getDateOfBirth()));
            ps.setString(4, s.getEmail());
            ps.setString(5, s.getPhone());
            ps.setString(6, s.getPassword());
            ps.setString(7, s.getGender());
            ps.setString(8, s.getDepartment());
            ps.setInt(9, s.getCourseId());
            ps.setString(10, s.getCity());
            ps.setString(11, s.getAddress());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();

        String sql = """
            SELECT s.student_id, s.first_name, s.last_name, s.email, s.phone,
                   s.gender, s.department, s.city, s.status, c.course_name
            FROM students s
            LEFT JOIN courses c ON s.course_id = c.course_id
            ORDER BY s.student_id DESC
            """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Student s = new Student();
                s.setStudentId(rs.getInt("student_id"));
                s.setFirstName(rs.getString("first_name"));
                s.setLastName(rs.getString("last_name"));
                s.setEmail(rs.getString("email"));
                s.setPhone(rs.getString("phone"));
                s.setGender(rs.getString("gender"));
                s.setDepartment(rs.getString("department"));
                s.setCity(rs.getString("city"));
                s.setStatus(rs.getString("status"));
                students.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public int countByStatus(String status) {
        String sql = "SELECT COUNT(*) FROM students WHERE status = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, status);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int countAll() {
        String sql = "SELECT COUNT(*) FROM students";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) return rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
