package tomCat;

import Utility.Employee;
import com.google.gson.Gson;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestJson", urlPatterns = "/employeeServlet")
public class TestJson extends javax.servlet.http.HttpServlet{
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Employee employee = new Employee(1,"Roman","EKB",15000);
        String employeeJsonString = new Gson().toJson(employee);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json;charset=UTF-8");
        out.print(employeeJsonString);
        out.flush();
        System.out.print("Something with GSOn by google");

    }
}