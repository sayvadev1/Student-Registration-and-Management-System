<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.student.model.Course" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><%= Boolean.TRUE.equals(request.getAttribute("publicRegistration")) ? "Student Registration" : "Add Student" %></title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="page">
    <div class="card form-card">
        <h1><%= Boolean.TRUE.equals(request.getAttribute("publicRegistration")) ? "Student Registration" : "Add New Student" %></h1>
        <% if (Boolean.TRUE.equals(request.getAttribute("publicRegistration"))) { %>
            <p class="muted">Register using this public form. Dashboard access is not granted to students.</p>
        <% } %>

        <% if (request.getAttribute("error") != null) { %>
            <div class="alert"><%= request.getAttribute("error") %></div>
        <% } %>

        <form action="register" method="post">
            <div class="grid">

                <div class="field">
                    <label>First Name</label>
                    <input type="text" name="firstName" placeholder="Enter first name" required>
                </div>

                <div class="field">
                    <label>Last Name</label>
                    <input type="text" name="lastName" placeholder="Enter last name" required>
                </div>

                <div class="field">
                    <label>Date of Birth</label>
                    <input type="date" name="dateOfBirth" required>
                </div>

                <div class="field">
                    <label>Email</label>
                    <input type="email" name="email" placeholder="Enter email" required>
                </div>

                <div class="field">
                    <label>Mobile Number</label>
                    <input type="tel" name="phone" placeholder="Enter mobile number" required>
                </div>

                <div class="field">
                    <label>Password</label>
                    <input type="password" name="password" placeholder="Enter password" required>
                </div>

                <div class="field">
                    <label>Confirm Password</label>
                    <input type="password" name="confirmPassword" placeholder="Confirm password" required>
                </div>

                <div class="field">
                    <label>Department</label>
                    <select name="department" required>
                        <option value="">Select Department</option>
                        <option value="CSE">CSE</option>
                        <option value="IT">IT</option>
                        <option value="ECE">ECE</option>
                        <option value="Civil">Civil</option>
                        <option value="Mech">Mech</option>
                    </select>
                </div>

                <div class="field">
                    <label>Course</label>
                    <select name="courseId" required>
                        <option value="">Select Course</option>
                        <%
                            List<Course> courses = (List<Course>) request.getAttribute("courses");
                            if (courses != null) {
                                for (Course course : courses) {
                        %>
                            <option value="<%= course.getCourseId() %>">
                                <%= course.getCourseName() %> - <%= course.getDuration() %>
                            </option>
                        <%
                                }
                            }
                        %>
                    </select>
                </div>

                <div class="field">
                    <label>Gender</label>
                    <div class="radio-row">
                        <label><input type="radio" name="gender" value="Male" required> Male</label>
                        <label><input type="radio" name="gender" value="Female"> Female</label>
                        <label><input type="radio" name="gender" value="Other"> Other</label>
                    </div>
                </div>

                <div class="field">
                    <label>City</label>
                    <input type="text" name="city" placeholder="Enter city" required>
                </div>

                <div class="field full">
                    <label>Address</label>
                    <textarea name="address" rows="4" placeholder="Enter address" required></textarea>
                </div>
            </div>

            <div class="actions">
                <a href="/student-management-system/" class="btn secondary">← Home</a>
                <% if (Boolean.TRUE.equals(request.getAttribute("publicRegistration"))) { %>
                    <a href="admin-login" class="btn secondary">Admin Login</a>
                <% } else { %>
                    <a href="dashboard" class="btn secondary">← Dashboard</a>
                <% } %>
                <button type="submit" class="btn primary">Register Student</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
