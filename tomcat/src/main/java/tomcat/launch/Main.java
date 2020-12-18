package tomcat.launch;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.WebResourceSet;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.ClassLoaderFactory;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.EmptyResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.apache.jasper.compiler.AntCompiler;
import org.apache.juli.logging.Log;
import tomcat.servlet.IndexServlet;
import tomcat.servlet.ServletJson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws LifecycleException,
            InterruptedException, ServletException {

        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("tomcat/temp");
        tomcat.setPort(8080);

        String contextPath = "/";
        String docBase = new File(".").getAbsolutePath();

        System.out.println(docBase);

        Context context = tomcat.addContext(contextPath, docBase);

        //Add Json page
        tomcat.addServlet(contextPath, "ServletJson", new ServletJson());
        context.addServletMapping("/json", "ServletJson");

        //Add main page
        tomcat.addServlet(contextPath,"MainPage",new IndexServlet());
        context.addServletMapping("/index","MainPage");

        tomcat.start();
        tomcat.getServer().await();
    }
}