package my.webapp.employee;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import my.webapp.database.Database;

@WebServlet(urlPatterns = {"/EmployeeServlet"})
public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            Database db = new Database();

            Connection conn = db.getConnection();

            PreparedStatement pstat = conn.prepareStatement(
                    "SELECT * FROM empleados;"
            );

            ResultSet rs = pstat.executeQuery();

            List<Employee> empleadosList = new ArrayList<>();

            while (rs.next()) {

                empleadosList.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("departamento")
                ));
            }

            request.setAttribute("empleadosList", empleadosList);

            request.getRequestDispatcher("employee.jsp").forward(request, response);

        } catch (SQLException ex)
        {
            System.getLogger(EmployeeServlet.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
