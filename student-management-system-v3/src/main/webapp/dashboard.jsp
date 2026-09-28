<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Dashboard</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="layout">
    <aside class="sidebar">
        <h2>StudentMS</h2>
        <a class="active" href="dashboard">Dashboard</a>
        <a href="students">View All Students</a>
        <a href="add-student">Add New Student</a>
        <a href="logout">Logout</a>
    </aside>

    <main class="main">
        <h1>Dashboard</h1>
        <p class="muted">Student Management System</p>

        <section class="stats">
            <div class="stat-card">
                <span>Total Students</span>
                <strong><%= request.getAttribute("totalStudents") %></strong>
            </div>
            <div class="stat-card">
                <span>Active Students</span>
                <strong><%= request.getAttribute("activeStudents") %></strong>
            </div>
            <div class="stat-card">
                <span>Inactive Students</span>
                <strong><%= request.getAttribute("inactiveStudents") %></strong>
            </div>
            <div class="stat-card">
                <span>Total Courses</span>
                <strong><%= request.getAttribute("totalCourses") %></strong>
            </div>
        </section>

        <section class="quick">
            <h2>Quick Actions</h2>
            <div class="actions">
                <a class="btn primary" href="students">View All Students</a>
                <a class="btn primary" href="add-student">Add New Student</a>
                <a class="btn secondary" href="register-student" target="_blank">Open Public Registration</a>
            </div>
        </section>
    </main>
</div>
</body>
</html>
