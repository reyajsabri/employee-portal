<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<body style='background-color: #1ABC9C;'>
<% String val = request.getParameter("message"); %>
<h1>Interstellar Transport System - Upload Status</h1>
<h2><%= val %></h2>

</body>
</html>