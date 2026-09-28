<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html><html><head><meta charset="UTF-8"><title>Admin Login</title><link rel="stylesheet" href="css/style.css"></head>
<body><div class="page"><div class="card form-card login-card"><h1>Admin Login</h1><p class="muted">Only administrators can access the dashboard.</p>
<% if (request.getAttribute("error") != null) { %><div class="alert"><%= request.getAttribute("error") %></div><% } %>
<form action="admin-login" method="post"><div class="field"><label>Username</label><input name="username" required></div><div class="field"><label>Password</label><input type="password" name="password" required></div><div class="actions"><a class="btn secondary" href="register-student">Student Registration</a><button class="btn primary" type="submit">Login</button></div></form>
</div></div></body></html>
