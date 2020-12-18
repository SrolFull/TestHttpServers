package tomcat.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="JsonServlet", urlPatterns = {"/json"})
public class ServletJson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode user = mapper.createObjectNode();
        user.put("id", 1);
        user.put("Name", "Roman");
        user.put("Age", 20);
        user.put("root",false);
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        out.write(json.getBytes());
        out.flush();
        out.close();
    }
}
