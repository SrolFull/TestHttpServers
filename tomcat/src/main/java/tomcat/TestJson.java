package tomcat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestJson", urlPatterns = "/employeeServlet")
public class TestJson extends javax.servlet.http.HttpServlet{
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode data = mapper.createObjectNode();
        data.put("id", 1);
        data.put("name","Aristov Roman");
        data.put("city","EKB");
        data.put("public", true);
        String json = mapper.writeValueAsString(data);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json;charset=UTF-8");
        out.print(json);
        out.flush();
    }
}