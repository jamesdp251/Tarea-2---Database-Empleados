<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="my.webapp.employee.Employee"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Lista de empleados</title>
    </head>

    <body>

        <h1>Lista de empleados</h1>

        <%
            List<Employee> empleadosList =
                    (List<Employee>) request.getAttribute("empleadosList");
        %>

        <table border="1">

            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Departamento</th>
            </tr>

            <% for(Employee employee : empleadosList) { %>

                <tr>
                    <td><%= employee.getId() %></td>
                    <td><%= employee.getNombre() %></td>
                    <td><%= employee.getDepartamento() %></td>
                </tr>

            <% } %>

        </table>

    </body>
</html>
