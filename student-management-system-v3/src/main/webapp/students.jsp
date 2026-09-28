<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.student.model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Students - StudentMS</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="page">
    <div class="card">
        <div class="topbar">
            <div>
                <h1>All Students</h1>
                <p class="muted">Registered students</p>
            </div>
            <div class="actions-inline page-nav">
                <a class="btn secondary" href="dashboard">← Dashboard</a>
                <a class="btn primary" href="add-student">+ Add Student</a>
                <a class="btn secondary" href="logout">Logout</a>
            </div>
        </div>

        <div class="notice-bar">
            <span>Admin view</span>
            <span>Manage and review registered students from here.</span>
        </div>

        <div class="table-wrap">
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Gender</th>
                    <th>Department</th>
                    <th>City</th>
                    <th>Status</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Student> students = (List<Student>) request.getAttribute("students");
                    if (students != null && !students.isEmpty()) {
                        for (Student s : students) {
                %>
                <tr>
                    <td><%= s.getStudentId() %></td>
                    <td><%= s.getFirstName() %> <%= s.getLastName() %></td>
                    <td><%= s.getEmail() %></td>
                    <td><%= s.getPhone() %></td>
                    <td><%= s.getGender() %></td>
                    <td><%= s.getDepartment() %></td>
                    <td><%= s.getCity() %></td>
                    <td><span class="badge"><%= s.getStatus() %></span></td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="8" class="empty-state">No students registered yet.</td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>

        <div class="bottom-nav">
            <a class="btn secondary" href="dashboard">← Back to Dashboard</a>
            <a class="btn primary" href="add-student">Add New Student</a>
        </div>
    </div>
</div>
</body>
</html>
